package com.zxk175.ssm.pojo;

import java.util.Date;

public class TQuartz {
    private String jobId;

    private String jobGroup;

    private String triggerGroup;

    private String jobName;

    private String triggerName;

    private String className;

    private String enableStatus;

    private String triggerCron;

    private String triggerStatus;

    private Date crateTime;

    private Date updateTime;

    private String descRipt;

    public TQuartz(String jobId, String jobGroup, String triggerGroup, String jobName, String triggerName, String className, String enableStatus, String triggerCron, String triggerStatus, Date crateTime, Date updateTime, String descRipt) {
        this.jobId = jobId;
        this.jobGroup = jobGroup;
        this.triggerGroup = triggerGroup;
        this.jobName = jobName;
        this.triggerName = triggerName;
        this.className = className;
        this.enableStatus = enableStatus;
        this.triggerCron = triggerCron;
        this.triggerStatus = triggerStatus;
        this.crateTime = crateTime;
        this.updateTime = updateTime;
        this.descRipt = descRipt;
    }

    public TQuartz() {
        super();
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId == null ? null : jobId.trim();
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup == null ? null : jobGroup.trim();
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup == null ? null : triggerGroup.trim();
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName == null ? null : triggerName.trim();
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    public String getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(String enableStatus) {
        this.enableStatus = enableStatus == null ? null : enableStatus.trim();
    }

    public String getTriggerCron() {
        return triggerCron;
    }

    public void setTriggerCron(String triggerCron) {
        this.triggerCron = triggerCron == null ? null : triggerCron.trim();
    }

    public String getTriggerStatus() {
        return triggerStatus;
    }

    public void setTriggerStatus(String triggerStatus) {
        this.triggerStatus = triggerStatus == null ? null : triggerStatus.trim();
    }

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDescRipt() {
        return descRipt;
    }

    public void setDescRipt(String descRipt) {
        this.descRipt = descRipt == null ? null : descRipt.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", jobId=").append(jobId);
        sb.append(", jobGroup=").append(jobGroup);
        sb.append(", triggerGroup=").append(triggerGroup);
        sb.append(", jobName=").append(jobName);
        sb.append(", triggerName=").append(triggerName);
        sb.append(", className=").append(className);
        sb.append(", enableStatus=").append(enableStatus);
        sb.append(", triggerCron=").append(triggerCron);
        sb.append(", triggerStatus=").append(triggerStatus);
        sb.append(", crateTime=").append(crateTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", descRipt=").append(descRipt);
        sb.append("]");
        return sb.toString();
    }
}