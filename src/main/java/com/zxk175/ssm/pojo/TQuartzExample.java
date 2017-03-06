package com.zxk175.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TQuartzExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TQuartzExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andJobIdIsNull() {
            addCriterion("job_id is null");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNotNull() {
            addCriterion("job_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobIdEqualTo(String value) {
            addCriterion("job_id =", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotEqualTo(String value) {
            addCriterion("job_id <>", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThan(String value) {
            addCriterion("job_id >", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThanOrEqualTo(String value) {
            addCriterion("job_id >=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThan(String value) {
            addCriterion("job_id <", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThanOrEqualTo(String value) {
            addCriterion("job_id <=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLike(String value) {
            addCriterion("job_id like", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotLike(String value) {
            addCriterion("job_id not like", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdIn(List<String> values) {
            addCriterion("job_id in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotIn(List<String> values) {
            addCriterion("job_id not in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdBetween(String value1, String value2) {
            addCriterion("job_id between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotBetween(String value1, String value2) {
            addCriterion("job_id not between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobGroupIsNull() {
            addCriterion("job_group is null");
            return (Criteria) this;
        }

        public Criteria andJobGroupIsNotNull() {
            addCriterion("job_group is not null");
            return (Criteria) this;
        }

        public Criteria andJobGroupEqualTo(String value) {
            addCriterion("job_group =", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotEqualTo(String value) {
            addCriterion("job_group <>", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupGreaterThan(String value) {
            addCriterion("job_group >", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupGreaterThanOrEqualTo(String value) {
            addCriterion("job_group >=", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLessThan(String value) {
            addCriterion("job_group <", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLessThanOrEqualTo(String value) {
            addCriterion("job_group <=", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupLike(String value) {
            addCriterion("job_group like", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotLike(String value) {
            addCriterion("job_group not like", value, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupIn(List<String> values) {
            addCriterion("job_group in", values, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotIn(List<String> values) {
            addCriterion("job_group not in", values, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupBetween(String value1, String value2) {
            addCriterion("job_group between", value1, value2, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andJobGroupNotBetween(String value1, String value2) {
            addCriterion("job_group not between", value1, value2, "jobGroup");
            return (Criteria) this;
        }

        public Criteria andTriggerGroupIsNull() {
            addCriterion("trigger_group is null");
            return (Criteria) this;
        }

        public Criteria andTriggerGroupIsNotNull() {
            addCriterion("trigger_group is not null");
            return (Criteria) this;
        }

        public Criteria andTriggerGroupEqualTo(String value) {
            addCriterion("trigger_group =", value, "triggerGroup");
            return (Criteria) this;
        }

        public Criteria andTriggerGroupNotEqualTo(String value) {
            addCriterion("trigger_group <>", value, "triggerGroup");
            return (Criteria) this;
        }

        public Criteria andTriggerGroupGreaterThan(String value) {
            addCriterion("trigger_group >", value, "triggerGroup");
            return (Criteria) this;
        }

        public Criteria andTriggerGroupGreaterThanOrEqualTo(String value) {
            addCriterion("trigger_group >=", value, "triggerGroup");
            return (Criteria) this;
        }

        public Criteria andTriggerGroupLessThan(String value) {
            addCriterion("trigger_group <", value, "triggerGroup");
            return (Criteria) this;
        }

        public Criteria andTriggerGroupLessThanOrEqualTo(String value) {
            addCriterion("trigger_group <=", value, "triggerGroup");
            return (Criteria) this;
        }

        public Criteria andTriggerGroupLike(String value) {
            addCriterion("trigger_group like", value, "triggerGroup");
            return (Criteria) this;
        }

        public Criteria andTriggerGroupNotLike(String value) {
            addCriterion("trigger_group not like", value, "triggerGroup");
            return (Criteria) this;
        }

        public Criteria andTriggerGroupIn(List<String> values) {
            addCriterion("trigger_group in", values, "triggerGroup");
            return (Criteria) this;
        }

        public Criteria andTriggerGroupNotIn(List<String> values) {
            addCriterion("trigger_group not in", values, "triggerGroup");
            return (Criteria) this;
        }

        public Criteria andTriggerGroupBetween(String value1, String value2) {
            addCriterion("trigger_group between", value1, value2, "triggerGroup");
            return (Criteria) this;
        }

        public Criteria andTriggerGroupNotBetween(String value1, String value2) {
            addCriterion("trigger_group not between", value1, value2, "triggerGroup");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNull() {
            addCriterion("job_name is null");
            return (Criteria) this;
        }

        public Criteria andJobNameIsNotNull() {
            addCriterion("job_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobNameEqualTo(String value) {
            addCriterion("job_name =", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotEqualTo(String value) {
            addCriterion("job_name <>", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThan(String value) {
            addCriterion("job_name >", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_name >=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThan(String value) {
            addCriterion("job_name <", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLessThanOrEqualTo(String value) {
            addCriterion("job_name <=", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameLike(String value) {
            addCriterion("job_name like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotLike(String value) {
            addCriterion("job_name not like", value, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameIn(List<String> values) {
            addCriterion("job_name in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotIn(List<String> values) {
            addCriterion("job_name not in", values, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameBetween(String value1, String value2) {
            addCriterion("job_name between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andJobNameNotBetween(String value1, String value2) {
            addCriterion("job_name not between", value1, value2, "jobName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameIsNull() {
            addCriterion("trigger_name is null");
            return (Criteria) this;
        }

        public Criteria andTriggerNameIsNotNull() {
            addCriterion("trigger_name is not null");
            return (Criteria) this;
        }

        public Criteria andTriggerNameEqualTo(String value) {
            addCriterion("trigger_name =", value, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameNotEqualTo(String value) {
            addCriterion("trigger_name <>", value, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameGreaterThan(String value) {
            addCriterion("trigger_name >", value, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameGreaterThanOrEqualTo(String value) {
            addCriterion("trigger_name >=", value, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameLessThan(String value) {
            addCriterion("trigger_name <", value, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameLessThanOrEqualTo(String value) {
            addCriterion("trigger_name <=", value, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameLike(String value) {
            addCriterion("trigger_name like", value, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameNotLike(String value) {
            addCriterion("trigger_name not like", value, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameIn(List<String> values) {
            addCriterion("trigger_name in", values, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameNotIn(List<String> values) {
            addCriterion("trigger_name not in", values, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameBetween(String value1, String value2) {
            addCriterion("trigger_name between", value1, value2, "triggerName");
            return (Criteria) this;
        }

        public Criteria andTriggerNameNotBetween(String value1, String value2) {
            addCriterion("trigger_name not between", value1, value2, "triggerName");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNull() {
            addCriterion("class_name is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("class_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("class_name =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("class_name <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("class_name >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_name >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("class_name <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("class_name <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("class_name like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("class_name not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("class_name in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("class_name not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("class_name between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("class_name not between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andEnableStatusIsNull() {
            addCriterion("enable_status is null");
            return (Criteria) this;
        }

        public Criteria andEnableStatusIsNotNull() {
            addCriterion("enable_status is not null");
            return (Criteria) this;
        }

        public Criteria andEnableStatusEqualTo(String value) {
            addCriterion("enable_status =", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusNotEqualTo(String value) {
            addCriterion("enable_status <>", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusGreaterThan(String value) {
            addCriterion("enable_status >", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusGreaterThanOrEqualTo(String value) {
            addCriterion("enable_status >=", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusLessThan(String value) {
            addCriterion("enable_status <", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusLessThanOrEqualTo(String value) {
            addCriterion("enable_status <=", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusLike(String value) {
            addCriterion("enable_status like", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusNotLike(String value) {
            addCriterion("enable_status not like", value, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusIn(List<String> values) {
            addCriterion("enable_status in", values, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusNotIn(List<String> values) {
            addCriterion("enable_status not in", values, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusBetween(String value1, String value2) {
            addCriterion("enable_status between", value1, value2, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andEnableStatusNotBetween(String value1, String value2) {
            addCriterion("enable_status not between", value1, value2, "enableStatus");
            return (Criteria) this;
        }

        public Criteria andTriggerCronIsNull() {
            addCriterion("trigger_cron is null");
            return (Criteria) this;
        }

        public Criteria andTriggerCronIsNotNull() {
            addCriterion("trigger_cron is not null");
            return (Criteria) this;
        }

        public Criteria andTriggerCronEqualTo(String value) {
            addCriterion("trigger_cron =", value, "triggerCron");
            return (Criteria) this;
        }

        public Criteria andTriggerCronNotEqualTo(String value) {
            addCriterion("trigger_cron <>", value, "triggerCron");
            return (Criteria) this;
        }

        public Criteria andTriggerCronGreaterThan(String value) {
            addCriterion("trigger_cron >", value, "triggerCron");
            return (Criteria) this;
        }

        public Criteria andTriggerCronGreaterThanOrEqualTo(String value) {
            addCriterion("trigger_cron >=", value, "triggerCron");
            return (Criteria) this;
        }

        public Criteria andTriggerCronLessThan(String value) {
            addCriterion("trigger_cron <", value, "triggerCron");
            return (Criteria) this;
        }

        public Criteria andTriggerCronLessThanOrEqualTo(String value) {
            addCriterion("trigger_cron <=", value, "triggerCron");
            return (Criteria) this;
        }

        public Criteria andTriggerCronLike(String value) {
            addCriterion("trigger_cron like", value, "triggerCron");
            return (Criteria) this;
        }

        public Criteria andTriggerCronNotLike(String value) {
            addCriterion("trigger_cron not like", value, "triggerCron");
            return (Criteria) this;
        }

        public Criteria andTriggerCronIn(List<String> values) {
            addCriterion("trigger_cron in", values, "triggerCron");
            return (Criteria) this;
        }

        public Criteria andTriggerCronNotIn(List<String> values) {
            addCriterion("trigger_cron not in", values, "triggerCron");
            return (Criteria) this;
        }

        public Criteria andTriggerCronBetween(String value1, String value2) {
            addCriterion("trigger_cron between", value1, value2, "triggerCron");
            return (Criteria) this;
        }

        public Criteria andTriggerCronNotBetween(String value1, String value2) {
            addCriterion("trigger_cron not between", value1, value2, "triggerCron");
            return (Criteria) this;
        }

        public Criteria andTriggerStatusIsNull() {
            addCriterion("trigger_status is null");
            return (Criteria) this;
        }

        public Criteria andTriggerStatusIsNotNull() {
            addCriterion("trigger_status is not null");
            return (Criteria) this;
        }

        public Criteria andTriggerStatusEqualTo(String value) {
            addCriterion("trigger_status =", value, "triggerStatus");
            return (Criteria) this;
        }

        public Criteria andTriggerStatusNotEqualTo(String value) {
            addCriterion("trigger_status <>", value, "triggerStatus");
            return (Criteria) this;
        }

        public Criteria andTriggerStatusGreaterThan(String value) {
            addCriterion("trigger_status >", value, "triggerStatus");
            return (Criteria) this;
        }

        public Criteria andTriggerStatusGreaterThanOrEqualTo(String value) {
            addCriterion("trigger_status >=", value, "triggerStatus");
            return (Criteria) this;
        }

        public Criteria andTriggerStatusLessThan(String value) {
            addCriterion("trigger_status <", value, "triggerStatus");
            return (Criteria) this;
        }

        public Criteria andTriggerStatusLessThanOrEqualTo(String value) {
            addCriterion("trigger_status <=", value, "triggerStatus");
            return (Criteria) this;
        }

        public Criteria andTriggerStatusLike(String value) {
            addCriterion("trigger_status like", value, "triggerStatus");
            return (Criteria) this;
        }

        public Criteria andTriggerStatusNotLike(String value) {
            addCriterion("trigger_status not like", value, "triggerStatus");
            return (Criteria) this;
        }

        public Criteria andTriggerStatusIn(List<String> values) {
            addCriterion("trigger_status in", values, "triggerStatus");
            return (Criteria) this;
        }

        public Criteria andTriggerStatusNotIn(List<String> values) {
            addCriterion("trigger_status not in", values, "triggerStatus");
            return (Criteria) this;
        }

        public Criteria andTriggerStatusBetween(String value1, String value2) {
            addCriterion("trigger_status between", value1, value2, "triggerStatus");
            return (Criteria) this;
        }

        public Criteria andTriggerStatusNotBetween(String value1, String value2) {
            addCriterion("trigger_status not between", value1, value2, "triggerStatus");
            return (Criteria) this;
        }

        public Criteria andCrateTimeIsNull() {
            addCriterion("crate_time is null");
            return (Criteria) this;
        }

        public Criteria andCrateTimeIsNotNull() {
            addCriterion("crate_time is not null");
            return (Criteria) this;
        }

        public Criteria andCrateTimeEqualTo(Date value) {
            addCriterion("crate_time =", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeNotEqualTo(Date value) {
            addCriterion("crate_time <>", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeGreaterThan(Date value) {
            addCriterion("crate_time >", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("crate_time >=", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeLessThan(Date value) {
            addCriterion("crate_time <", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeLessThanOrEqualTo(Date value) {
            addCriterion("crate_time <=", value, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeIn(List<Date> values) {
            addCriterion("crate_time in", values, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeNotIn(List<Date> values) {
            addCriterion("crate_time not in", values, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeBetween(Date value1, Date value2) {
            addCriterion("crate_time between", value1, value2, "crateTime");
            return (Criteria) this;
        }

        public Criteria andCrateTimeNotBetween(Date value1, Date value2) {
            addCriterion("crate_time not between", value1, value2, "crateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDescRiptIsNull() {
            addCriterion("desc_ript is null");
            return (Criteria) this;
        }

        public Criteria andDescRiptIsNotNull() {
            addCriterion("desc_ript is not null");
            return (Criteria) this;
        }

        public Criteria andDescRiptEqualTo(String value) {
            addCriterion("desc_ript =", value, "descRipt");
            return (Criteria) this;
        }

        public Criteria andDescRiptNotEqualTo(String value) {
            addCriterion("desc_ript <>", value, "descRipt");
            return (Criteria) this;
        }

        public Criteria andDescRiptGreaterThan(String value) {
            addCriterion("desc_ript >", value, "descRipt");
            return (Criteria) this;
        }

        public Criteria andDescRiptGreaterThanOrEqualTo(String value) {
            addCriterion("desc_ript >=", value, "descRipt");
            return (Criteria) this;
        }

        public Criteria andDescRiptLessThan(String value) {
            addCriterion("desc_ript <", value, "descRipt");
            return (Criteria) this;
        }

        public Criteria andDescRiptLessThanOrEqualTo(String value) {
            addCriterion("desc_ript <=", value, "descRipt");
            return (Criteria) this;
        }

        public Criteria andDescRiptLike(String value) {
            addCriterion("desc_ript like", value, "descRipt");
            return (Criteria) this;
        }

        public Criteria andDescRiptNotLike(String value) {
            addCriterion("desc_ript not like", value, "descRipt");
            return (Criteria) this;
        }

        public Criteria andDescRiptIn(List<String> values) {
            addCriterion("desc_ript in", values, "descRipt");
            return (Criteria) this;
        }

        public Criteria andDescRiptNotIn(List<String> values) {
            addCriterion("desc_ript not in", values, "descRipt");
            return (Criteria) this;
        }

        public Criteria andDescRiptBetween(String value1, String value2) {
            addCriterion("desc_ript between", value1, value2, "descRipt");
            return (Criteria) this;
        }

        public Criteria andDescRiptNotBetween(String value1, String value2) {
            addCriterion("desc_ript not between", value1, value2, "descRipt");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}