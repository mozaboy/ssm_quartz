package com.zxk175.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxk175.ssm.dto.DataTablePage;
import com.zxk175.ssm.pojo.TQuartz;
import com.zxk175.ssm.pojo.TQuartzExample;
import com.zxk175.ssm.service.TQuartzService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zxk175 on 2017/3/2.
 */
@Api(description = "任务管理", tags = "Quartz Controller")
@Controller
@RequestMapping("/task")
public class QuartzController extends BaseController {
    private static final Logger log = LogManager.getLogger(QuartzController.class);

    @Resource
    private TQuartzService quartzService;

    /**
     * 跳转所有任务信息页面
     *
     * @param request
     * @return
     */
    @ApiIgnore
    @RequestMapping(value = "/show")
    public String toShowUserView(HttpServletRequest request) {
        request.setAttribute("page_title", "查看所有任务信息");
        return "show_task";
    }

    /**
     * 分页获取所有任务信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/show", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "分页获取所有任务信息", notes = "分页获取所有任务信息")
    @ApiImplicitParam(required = true, name = "param", value = "DataTable默认参数", dataType = "string", paramType = "query")
    public DataTablePage<TQuartz> showTaskByPage(String param) throws Exception {
        log.debug("查询所有用户信息");
        int start = 0;
        int length = 0;
        int draw = 0;

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
        }

        DataTablePage<TQuartz> page = null;

        //开始分页,参数1为请求第几页,参数2为请求条数
        PageHelper.startPage((start / length + 1), length);

        //查询条件
        TQuartzExample example = new TQuartzExample();

        example.setOrderByClause("update_time desc");

        //查询结果
        List<TQuartz> quartzList = quartzService.getQuartzList(example);

        //取记录总条数
        PageInfo<TQuartz> pageInfo = new PageInfo<>(quartzList);
        long total = pageInfo.getTotal();

        page = new DataTablePage<TQuartz>();
        page.setData(quartzList);
        page.setRecordsTotal(total);
        page.setRecordsFiltered((int) total);
        page.setDraw(draw);

        return page;
    }
}
