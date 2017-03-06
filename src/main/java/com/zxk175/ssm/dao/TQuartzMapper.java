package com.zxk175.ssm.dao;

import com.zxk175.ssm.pojo.TQuartz;
import com.zxk175.ssm.pojo.TQuartzExample;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TQuartzMapper {
    @SelectProvider(type=TQuartzSqlProvider.class, method="countByExample")
    int countByExample(TQuartzExample example);

    @DeleteProvider(type=TQuartzSqlProvider.class, method="deleteByExample")
    int deleteByExample(TQuartzExample example);

    @Delete({
        "delete from t_quartz",
        "where job_id = #{jobId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String jobId);

    @Insert({
        "insert into t_quartz (job_id, job_group, ",
        "trigger_group, job_name, ",
        "trigger_name, class_name, ",
        "enable_status, trigger_cron, ",
        "trigger_status, crate_time, ",
        "update_time, desc_ript)",
        "values (#{jobId,jdbcType=VARCHAR}, #{jobGroup,jdbcType=VARCHAR}, ",
        "#{triggerGroup,jdbcType=VARCHAR}, #{jobName,jdbcType=VARCHAR}, ",
        "#{triggerName,jdbcType=VARCHAR}, #{className,jdbcType=VARCHAR}, ",
        "#{enableStatus,jdbcType=VARCHAR}, #{triggerCron,jdbcType=VARCHAR}, ",
        "#{triggerStatus,jdbcType=VARCHAR}, #{crateTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{descRipt,jdbcType=VARCHAR})"
    })
    int insert(TQuartz record);

    @InsertProvider(type=TQuartzSqlProvider.class, method="insertSelective")
    int insertSelective(TQuartz record);

    @SelectProvider(type=TQuartzSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="job_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="job_group", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="trigger_group", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="job_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="trigger_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="class_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="enable_status", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="trigger_cron", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="trigger_status", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="crate_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="desc_ript", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    List<TQuartz> selectByExample(TQuartzExample example);

    @Select({
        "select",
        "job_id, job_group, trigger_group, job_name, trigger_name, class_name, enable_status, ",
        "trigger_cron, trigger_status, crate_time, update_time, desc_ript",
        "from t_quartz",
        "where job_id = #{jobId,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="job_id", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="job_group", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="trigger_group", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="job_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="trigger_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="class_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="enable_status", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="trigger_cron", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="trigger_status", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="crate_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="update_time", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="desc_ript", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    TQuartz selectByPrimaryKey(String jobId);

    @UpdateProvider(type=TQuartzSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TQuartz record, @Param("example") TQuartzExample example);

    @UpdateProvider(type=TQuartzSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TQuartz record, @Param("example") TQuartzExample example);

    @UpdateProvider(type=TQuartzSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TQuartz record);

    @Update({
        "update t_quartz",
        "set job_group = #{jobGroup,jdbcType=VARCHAR},",
          "trigger_group = #{triggerGroup,jdbcType=VARCHAR},",
          "job_name = #{jobName,jdbcType=VARCHAR},",
          "trigger_name = #{triggerName,jdbcType=VARCHAR},",
          "class_name = #{className,jdbcType=VARCHAR},",
          "enable_status = #{enableStatus,jdbcType=VARCHAR},",
          "trigger_cron = #{triggerCron,jdbcType=VARCHAR},",
          "trigger_status = #{triggerStatus,jdbcType=VARCHAR},",
          "crate_time = #{crateTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "desc_ript = #{descRipt,jdbcType=VARCHAR}",
        "where job_id = #{jobId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TQuartz record);
}