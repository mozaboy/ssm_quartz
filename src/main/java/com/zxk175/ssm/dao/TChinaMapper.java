package com.zxk175.ssm.dao;

import com.zxk175.ssm.pojo.TChina;
import com.zxk175.ssm.pojo.TChinaCriteria;
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

public interface TChinaMapper {
    @SelectProvider(type=TChinaSqlProvider.class, method="countByExample")
    int countByExample(TChinaCriteria example);

    @DeleteProvider(type=TChinaSqlProvider.class, method="deleteByExample")
    int deleteByExample(TChinaCriteria example);

    @Delete({
        "delete from t_china",
        "where city_id = #{cityId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer cityId);

    @Insert({
        "insert into t_china (city_id, city_name, ",
        "parent_id)",
        "values (#{cityId,jdbcType=INTEGER}, #{cityName,jdbcType=VARCHAR}, ",
        "#{parentId,jdbcType=INTEGER})"
    })
    int insert(TChina record);

    @InsertProvider(type=TChinaSqlProvider.class, method="insertSelective")
    int insertSelective(TChina record);

    @SelectProvider(type=TChinaSqlProvider.class, method="selectByExample")
    @ConstructorArgs({
        @Arg(column="city_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="city_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="parent_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    List<TChina> selectByExample(TChinaCriteria example);

    @Select({
        "select",
        "city_id, city_name, parent_id",
        "from t_china",
        "where city_id = #{cityId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="city_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="city_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="parent_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER)
    })
    TChina selectByPrimaryKey(Integer cityId);

    @UpdateProvider(type=TChinaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TChina record, @Param("example") TChinaCriteria example);

    @UpdateProvider(type=TChinaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TChina record, @Param("example") TChinaCriteria example);

    @UpdateProvider(type=TChinaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TChina record);

    @Update({
        "update t_china",
        "set city_name = #{cityName,jdbcType=VARCHAR},",
          "parent_id = #{parentId,jdbcType=INTEGER}",
        "where city_id = #{cityId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TChina record);
}