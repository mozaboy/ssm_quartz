package com.zxk175.ssm.util.quartz;

import com.zxk175.ssm.pojo.TQuartz;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * TODO(定时任务管理类)
 */
public class QuartzUtil {
    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    private static String JOB_GROUP_NAME = "DEFAULT_JOBGROUP_NAME";
    private static String TRIGGER_GROUP_NAME = "DEFAULT_TRIGGERGROUP_NAME";

    /**
     * TODO(添加一个定时任务，使用默认的任务组名，触发器名，触发器组名)
     *
     * @param jobName 任务名
     * @param clazz   任务
     * @param cron    时间设置，参考quartz说明文档
     */
    public static void addJob(String jobName, Class clazz, String cron) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            // 任务名，任务组，任务执行类
            JobDetail jobDetail = JobBuilder
                    .newJob((Class<? extends Job>) clazz)
                    .withIdentity(jobName, JOB_GROUP_NAME)
                    .build();

            // 触发器
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            // 触发器名,触发器组
            triggerBuilder.withIdentity(jobName, TRIGGER_GROUP_NAME);
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
     * TODO(添加一个定时任务)
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
     * TODO(修改一个任务的触发时间(使用默认的任务组名，触发器名，触发器组名))
     *
     * @param jobName
     * @param cron
     */
    public static void modifyJobTime(String jobName, String cron) {
        try {
            String triggerGroup = TRIGGER_GROUP_NAME;
            String jobGroup = JOB_GROUP_NAME;

            Scheduler scheduler = schedulerFactory.getScheduler();
            TriggerKey triggerKey = new TriggerKey(jobName, triggerGroup);
            JobKey jobKey = new JobKey(jobName, jobGroup);

            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }

            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(cron)) {
                JobDetail jobDetail = scheduler.getJobDetail(jobKey);
                Class objJobClass = jobDetail.getJobClass();
                removeJob(jobName);
                addJob(jobName, objJobClass, cron);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * TODO(修改一个任务的触发时间)
     *
     * @param triggerName
     * @param triggerGroup
     * @param cron
     */
    public static void modifyJobTime(String triggerName, String triggerGroup, String cron) {
        try {
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
     * TODO(更新任务时间：先移除、再新增)
     *
     * @param quartz
     */
    public static void modifyJobTimeTrue(TQuartz quartz) {
        //先移除
        removeJob(quartz);
        //再新增
        addJob(quartz);
    }

    /**
     * TODO(移除一个任务(使用默认的任务组名，触发器名，触发器组名)
     *
     * @param jobName
     */
    public static void removeJob(String jobName) {
        try {
            String triggerGroup = TRIGGER_GROUP_NAME;
            String jobGroup = JOB_GROUP_NAME;

            Scheduler scheduler = schedulerFactory.getScheduler();
            TriggerKey triggerKey = new TriggerKey(jobName, triggerGroup);
            JobKey jobKey = new JobKey(jobName, jobGroup);

            // 停止触发器
            scheduler.pauseTrigger(triggerKey);
            // 移除触发器
            scheduler.unscheduleJob(triggerKey);
            // 删除任务
            scheduler.deleteJob(jobKey);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * TODO(移除一个任务)
     *
     * @param quartz
     */
    public static void removeJob(TQuartz quartz) {
        try {
            String triggerName = quartz.getTriggerName();
            String triggerGroup = quartz.getTriggerGroup();
            String jobName = quartz.getJobName();
            String jobGroup = quartz.getJobGroup();

            Scheduler scheduler = schedulerFactory.getScheduler();
            TriggerKey triggerKey = new TriggerKey(triggerName, triggerGroup);
            JobKey jobKey = new JobKey(jobName, jobGroup);

            // 停止触发器
            scheduler.pauseTrigger(triggerKey);
            // 移除触发器
            scheduler.unscheduleJob(triggerKey);
            // 删除任务
            scheduler.deleteJob(jobKey);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * TODO(启动所有定时任务)
     */
    public static void startJobs() {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * TODO(关闭所有定时任务)
     */
    public static void shutdownJobs() {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * TODO(停止一个job任务)
     *
     * @param quartz
     * @throws SchedulerException
     */
    public static void pauseJob(TQuartz quartz) throws SchedulerException {
        Scheduler scheduler = schedulerFactory.getScheduler();

        String jobName = quartz.getJobName();
        String jobGroup = quartz.getJobGroup();
        JobKey jobKey = new JobKey(jobName, jobGroup);
        scheduler.interrupt(jobKey);
    }

    /**
     * TODO(恢复一个job任务)
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
