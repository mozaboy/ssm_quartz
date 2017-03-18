package com.zxk175.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxk175.ssm.dto.DataTablePage;
import com.zxk175.ssm.dto.ResponseVo;
import com.zxk175.ssm.pojo.TQuartz;
import com.zxk175.ssm.pojo.TQuartzCriteria;
import com.zxk175.ssm.service.TQuartzService;
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
        TQuartzCriteria criteria = new TQuartzCriteria();

        criteria.setOrderByClause("update_time desc");

        //查询结果
        List<TQuartz> quartzList = quartzService.getQuartzList(criteria);

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

    /**
     * 暂停任务
     *
     * @param jobId
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/pause/{jobId}", method = RequestMethod.PUT)
    @ApiOperation(value = "暂停任务", notes = "暂停任务")
    @ApiParam(required = true, name = "quartz", value = "任务实体Bean")
    @ApiImplicitParam(required = true, name = "jobId", value = "任务Id", dataType = "string", paramType = "query")
    public ResponseVo pauseJob(@RequestBody TQuartz quartz, @PathVariable String jobId) throws Exception {
        quartz.setJobId(jobId);
        quartz.setTriggerStatus("2");
        int pauseJob = quartzService.pauseJob(quartz);

        ResponseVo responseVo = null;
        if (pauseJob > 0) {
            responseVo = new ResponseVo(200, "暂停成功！");
        } else {
            responseVo = new ResponseVo(500, "暂停失败！");
        }
        return responseVo;
    }

    /**
     * 恢复任务
     *
     * @param jobId
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/resume/{jobId}", method = RequestMethod.PUT)
    @ApiOperation(value = "恢复任务", notes = "恢复任务")
    @ApiParam(required = true, name = "quartz", value = "任务实体Bean")
    @ApiImplicitParam(required = true, name = "jobId", value = "任务Id", dataType = "string", paramType = "query")
    public ResponseVo resumeJob(@RequestBody TQuartz quartz, @PathVariable String jobId) throws Exception {
        quartz.setJobId(jobId);
        quartz.setTriggerStatus("1");
        int resumeJob = quartzService.resumeJob(quartz);

        ResponseVo responseVo = null;
        if (resumeJob > 0) {
            responseVo = new ResponseVo(200, "恢复成功！");
        } else {
            responseVo = new ResponseVo(500, "恢复失败！");
        }
        return responseVo;
    }

}
