package com.zxk175.ssm.util.quartz;

import com.zxk175.ssm.pojo.TQuartz;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * TODO(定时任务管理类)
 */
public class QuartzUtil {
    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();

    /**
     * TODO(添加任务)
     *
     * @param quartz
     */
    public static void addJob(TQuartz quartz) {
        try {
            String triggerName = quartz.getTriggerName();
            String triggerGroup = quartz.getTriggerGroup();
            String jobName = quartz.getJobName();
            String jobGroup = quartz.getJobGroup();
            String cron = quartz.getTriggerCron();

            Scheduler scheduler = schedulerFactory.getScheduler();
            Class<?> clazz = Class.forName(quartz.getClassName());
            // 任务名，任务组，任务执行类
            JobDetail jobDetail = JobBuilder
                    .newJob((Class<? extends Job>) clazz)
                    .withIdentity(jobName, jobGroup)
                    .build();
            // 触发器
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            // 触发器名,触发器组
            triggerBuilder.withIdentity(triggerName, triggerGroup);
            triggerBuilder.startNow();
            // 触发器时间设定
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
            // 创建Trigger对象
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();
            // 调度容器设置JobDetail和Trigger
            scheduler.scheduleJob(jobDetail, trigger);
            // 启动
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * TODO(删除任务)
     *
     * @param quartz
     */
    private static void removeJob(TQuartz quartz) throws SchedulerException {
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobKey jobKey = new JobKey(quartz.getJobName(), quartz.getJobGroup());
        scheduler.deleteJob(jobKey);
    }

    /**
     * TODO(修改任务)
     *
     * @param quartz
     */
    public static void modifyJobTime(TQuartz quartz) {
        try {
            String triggerName = quartz.getTriggerName();
            String triggerGroup = quartz.getTriggerGroup();
            String cron = quartz.getTriggerCron();

            Scheduler scheduler = schedulerFactory.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroup);

            //获取trigger
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

            //表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);

            //按新的cronExpression表达式重新构建trigger
            TriggerBuilder<CronTrigger> triggerBuilder = trigger.getTriggerBuilder();
            TriggerBuilder<CronTrigger> cronTriggerTriggerBuilder = triggerBuilder.withIdentity(triggerKey);
            trigger = cronTriggerTriggerBuilder.withSchedule(scheduleBuilder).build();

            //按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * TODO(暂停任务)
     *
     * @param quartz
     * @throws SchedulerException
     */
    public static void pauseJob(TQuartz quartz) throws SchedulerException {
        Scheduler scheduler = schedulerFactory.getScheduler();

        String jobName = quartz.getJobName();
        String jobGroup = quartz.getJobGroup();
        JobKey jobKey = new JobKey(jobName, jobGroup);
        scheduler.pauseJob(jobKey);
    }

    /**
     * TODO(恢复任务)
     *
     * @param quartz
     * @throws SchedulerException
     */
    public static void resumeJob(TQuartz quartz) throws SchedulerException {
        Scheduler scheduler = schedulerFactory.getScheduler();

        String jobName = quartz.getJobName();
        String jobGroup = quartz.getJobGroup();
        JobKey jobKey = new JobKey(jobName, jobGroup);
        scheduler.resumeJob(jobKey);
    }
}
