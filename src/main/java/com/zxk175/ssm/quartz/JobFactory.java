package com.zxk175.ssm.quartz;

import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

/**
 * TODO(任务工厂类,非同步)
 * Created by zxk175 on 2017/3/1.
 */
public interface JobFactory extends InterruptableJob {
    void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException;
}
