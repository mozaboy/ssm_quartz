package com.zxk175.ssm.task;

import com.zxk175.ssm.pojo.TUser;
import com.zxk175.ssm.pojo.TUserExample;
import com.zxk175.ssm.quartz.JobFactory;
import com.zxk175.ssm.service.TUserService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zxk175 on 2017/3/1.
 */
public class QuartzTask implements JobFactory {
    //是否点击了‘立刻停止’
    private boolean interrupted = false;

    @Autowired
    private TUserService userService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        if (null == userService) {
            System.out.println("userService为null");
            return;
        }

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TUserExample example = new TUserExample();
        List<TUser> users = userService.getAllUserByExample(example);
        int size = users.size();
        if (null != users && size > 0) {
            for (TUser user : users) {
                if (interrupted) {
                    System.out.println("定时任务QuartzTask.class立刻停止!!!");
                    return;
                }

                System.out.println(sf.format(new Date()) + ":" + user);
            }
        }
    }

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        System.out.println("【关闭】interrupt执行立刻停止:test定时发送...");
        interrupted = true;
    }
}
