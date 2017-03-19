package com.zxk175.ssm.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.zxk175.ssm.pojo.TQuartz;
import com.zxk175.ssm.pojo.TQuartzCriteria.Criteria;
import com.zxk175.ssm.pojo.TQuartzCriteria.Criterion;
import com.zxk175.ssm.pojo.TQuartzCriteria;
import java.util.List;
import java.util.Map;

public class TQuartzSqlProvider {

    public String countByExample(TQuartzCriteria example) {
        BEGIN();
        SELECT("count(*)");
        FROM("t_quartz");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(TQuartzCriteria example) {
        BEGIN();
        DELETE_FROM("t_quartz");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(TQuartz record) {
        BEGIN();
        INSERT_INTO("t_quartz");
        
        if (record.getJobId() != null) {
            VALUES("job_id", "#{jobId,jdbcType=VARCHAR}");
        }
        
        if (record.getJobGroup() != null) {
            VALUES("job_group", "#{jobGroup,jdbcType=VARCHAR}");
        }
        
        if (record.getTriggerGroup() != null) {
            VALUES("trigger_group", "#{triggerGroup,jdbcType=VARCHAR}");
        }
        
        if (record.getJobName() != null) {
            VALUES("job_name", "#{jobName,jdbcType=VARCHAR}");
        }
        
        if (record.getTriggerName() != null) {
            VALUES("trigger_name", "#{triggerName,jdbcType=VARCHAR}");
        }
        
        if (record.getClassName() != null) {
            VALUES("class_name", "#{className,jdbcType=VARCHAR}");
        }
        
        if (record.getEnableStatus() != null) {
            VALUES("enable_status", "#{enableStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getTriggerCron() != null) {
            VALUES("trigger_cron", "#{triggerCron,jdbcType=VARCHAR}");
        }
        
        if (record.getTriggerStatus() != null) {
            VALUES("trigger_status", "#{triggerStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getCrateTime() != null) {
            VALUES("crate_time", "#{crateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescRipt() != null) {
            VALUES("desc_ript", "#{descRipt,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(TQuartzCriteria example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("job_id");
        } else {
            SELECT("job_id");
        }
        SELECT("job_group");
        SELECT("trigger_group");
        SELECT("job_name");
        SELECT("trigger_name");
        SELECT("class_name");
        SELECT("enable_status");
        SELECT("trigger_cron");
        SELECT("trigger_status");
        SELECT("crate_time");
        SELECT("update_time");
        SELECT("desc_ript");
        FROM("t_quartz");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TQuartz record = (TQuartz) parameter.get("record");
        TQuartzCriteria example = (TQuartzCriteria) parameter.get("example");
        
        BEGIN();
        UPDATE("t_quartz");
        
        if (record.getJobId() != null) {
            SET("job_id = #{record.jobId,jdbcType=VARCHAR}");
        }
        
        if (record.getJobGroup() != null) {
            SET("job_group = #{record.jobGroup,jdbcType=VARCHAR}");
        }
        
        if (record.getTriggerGroup() != null) {
            SET("trigger_group = #{record.triggerGroup,jdbcType=VARCHAR}");
        }
        
        if (record.getJobName() != null) {
            SET("job_name = #{record.jobName,jdbcType=VARCHAR}");
        }
        
        if (record.getTriggerName() != null) {
            SET("trigger_name = #{record.triggerName,jdbcType=VARCHAR}");
        }
        
        if (record.getClassName() != null) {
            SET("class_name = #{record.className,jdbcType=VARCHAR}");
        }
        
        if (record.getEnableStatus() != null) {
            SET("enable_status = #{record.enableStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getTriggerCron() != null) {
            SET("trigger_cron = #{record.triggerCron,jdbcType=VARCHAR}");
        }
        
        if (record.getTriggerStatus() != null) {
            SET("trigger_status = #{record.triggerStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getCrateTime() != null) {
            SET("crate_time = #{record.crateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescRipt() != null) {
            SET("desc_ript = #{record.descRipt,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_quartz");
        
        SET("job_id = #{record.jobId,jdbcType=VARCHAR}");
        SET("job_group = #{record.jobGroup,jdbcType=VARCHAR}");
        SET("trigger_group = #{record.triggerGroup,jdbcType=VARCHAR}");
        SET("job_name = #{record.jobName,jdbcType=VARCHAR}");
        SET("trigger_name = #{record.triggerName,jdbcType=VARCHAR}");
        SET("class_name = #{record.className,jdbcType=VARCHAR}");
        SET("enable_status = #{record.enableStatus,jdbcType=VARCHAR}");
        SET("trigger_cron = #{record.triggerCron,jdbcType=VARCHAR}");
        SET("trigger_status = #{record.triggerStatus,jdbcType=VARCHAR}");
        SET("crate_time = #{record.crateTime,jdbcType=TIMESTAMP}");
        SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("desc_ript = #{record.descRipt,jdbcType=VARCHAR}");
        
        TQuartzCriteria example = (TQuartzCriteria) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(TQuartz record) {
        BEGIN();
        UPDATE("t_quartz");
        
        if (record.getJobGroup() != null) {
            SET("job_group = #{jobGroup,jdbcType=VARCHAR}");
        }
        
        if (record.getTriggerGroup() != null) {
            SET("trigger_group = #{triggerGroup,jdbcType=VARCHAR}");
        }
        
        if (record.getJobName() != null) {
            SET("job_name = #{jobName,jdbcType=VARCHAR}");
        }
        
        if (record.getTriggerName() != null) {
            SET("trigger_name = #{triggerName,jdbcType=VARCHAR}");
        }
        
        if (record.getClassName() != null) {
            SET("class_name = #{className,jdbcType=VARCHAR}");
        }
        
        if (record.getEnableStatus() != null) {
            SET("enable_status = #{enableStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getTriggerCron() != null) {
            SET("trigger_cron = #{triggerCron,jdbcType=VARCHAR}");
        }
        
        if (record.getTriggerStatus() != null) {
            SET("trigger_status = #{triggerStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getCrateTime() != null) {
            SET("crate_time = #{crateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getDescRipt() != null) {
            SET("desc_ript = #{descRipt,jdbcType=VARCHAR}");
        }
        
        WHERE("job_id = #{jobId,jdbcType=VARCHAR}");
        
        return SQL();
    }

    protected void applyWhere(TQuartzCriteria example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}