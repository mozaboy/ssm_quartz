package com.zxk175.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.zxk175.ssm.dto.table.DTPages;
import com.zxk175.ssm.dto.web.ResponseVo;
import com.zxk175.ssm.pojo.TUser;
import com.zxk175.ssm.pojo.TUserCriteria;
import com.zxk175.ssm.service.TUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by zxk175 on 16/11/13.
 */
@Api(description = "用户管理", tags = "User Controller")
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    private static final Logger log = LogManager.getLogger(UserController.class);

    @Resource
    private TUserService userService;

    /**
     * 添加用户信息
     *
     * @param user
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "添加用户信息", notes = "添加用户信息", response = ResponseVo.class)
    @ApiParam(required = true, name = "user", value = "用户实体Bean")
    public ResponseVo addUser(@RequestBody TUser user) throws Exception {
        user.setCreateTime(new Date());
        user.setModifyTime(new Date());
        user.setState((short) 1);
        int insert = userService.insert(user);
        ResponseVo responseVo = null;
        if (insert > 0) {
            responseVo = new ResponseVo(200, "插入成功！");
        } else {
            responseVo = new ResponseVo(500, "插入失败！");
        }
        return responseVo;
    }

    /**
     * 删除用户信息
     *
     * @param uid
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/{uid}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "删除用户信息", notes = "根据url的uid删除指定用户信息", response = ResponseVo.class)
    @ApiImplicitParam(required = true, name = "uid", value = "用户Id", dataType = "long", paramType = "path")
    public ResponseVo removeUser(@PathVariable("uid") Long uid) throws Exception {
        int delete = userService.delete(uid);
        ResponseVo responseVo = null;
        if (delete > 0) {
            responseVo = new ResponseVo(200, "删除成功！");
        } else {
            responseVo = new ResponseVo(500, "删除失败！");
        }
        return responseVo;
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @param uid
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/{uid}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改用户信息", notes = "根据url的uid修改指定用户信息", response = ResponseVo.class)
    @ApiParam(required = true, name = "user", value = "用户实体Bean")
    @ApiImplicitParam(required = true, name = "uid", value = "用户Id", dataType = "long", paramType = "path")
    public ResponseVo modifyUser(@RequestBody TUser user, @PathVariable("uid") Long uid) throws Exception {
        user.setModifyTime(new Date());
        int update = userService.update(user, uid);
        ResponseVo responseVo = null;
        if (update > 0) {
            responseVo = new ResponseVo(200, "修改成功！");
        } else {
            responseVo = new ResponseVo(500, "修改失败！");
        }
        return responseVo;
    }

    /**
     * 跳转所有用户信息页面
     *
     * @param request
     * @return
     */
    @ApiIgnore
    @RequestMapping(value = "/show")
    public String toShowUserView(HttpServletRequest request) {
        request.setAttribute("page_title", "查看所有用户信息");
        return "show_user";
    }

    /**
     * 分页获取所有用户信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/show", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页获取所有用户信息", notes = "分页获取所有用户信息")
    @ApiImplicitParam(required = true, name = "param", value = "DataTable默认参数", dataType = "string", paramType = "query")
    public DTPages<TUser> showUserByPage(String param) throws Exception {
        log.debug("查询所有用户信息");
        int start = 0;
        int length = 0;
        int draw = 0;
        String userName = null;

        //用来触发通用异常
        //int k = 10 / 0;

        JSONArray jsonArray = JSONArray.fromObject(param);
        int arraySize = jsonArray.size();
        //分别为关键的参数赋值
        for (int i = 0; i < arraySize && null != jsonArray; i++) {
            JSONObject obj = (JSONObject) jsonArray.get(i);
            if (obj.get("name").equals("draw")) {
                draw = (int) obj.get("value");
            }
            if (obj.get("name").equals("start")) {
                start = (int) obj.get("value");
            }
            if (obj.get("name").equals("length")) {
                length = (int) obj.get("value");
            }
            if (obj.get("name").equals("userName")) {
                userName = (String) obj.get("value");
            }
        }

        DTPages<TUser> page = null;

        //开始分页,参数1为请求第几页,参数2为请求条数
        PageHelper.startPage((start / length + 1), length);

        //查询条件
        TUserCriteria example = new TUserCriteria();
        TUserCriteria.Criteria criteria = example.createCriteria();

        if (StringUtil.isNotEmpty(userName)) {
            criteria.andUserNameLike(addPercent(userName));
        }

        example.setOrderByClause("modify_time desc");

        //查询结果
        List<TUser> userList = userService.selectByExample(example);

        //取记录总条数
        PageInfo<TUser> pageInfo = new PageInfo<>(userList);
        long total = pageInfo.getTotal();

        page = new DTPages<TUser>();
        page.setData(userList);
        page.setRecordsTotal(total);
        page.setRecordsFiltered((int) total);
        page.setDraw(draw);

        return page;
    }

    /**
     * 拼接百分符号
     *
     * @param str
     * @return
     */
    private String addPercent(String str) {
        return "%" + str + "%";
    }
}
