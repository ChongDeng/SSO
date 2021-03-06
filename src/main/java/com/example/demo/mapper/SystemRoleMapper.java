package com.example.demo.mapper;

import com.example.demo.entity.SystemRole;
import java.util.Date;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface SystemRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_role
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    @Delete({
        "delete from system_role",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_role
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    @Insert({
        "insert into system_role (id, name, ",
        "created_by, created, ",
        "modified_by, modified)",
        "values (#{id,jdbcType=BIGINT}, #{name,jdbcType=VARCHAR}, ",
        "#{created_by,jdbcType=VARCHAR}, #{created,jdbcType=TIMESTAMP}, ",
        "#{modified_by,jdbcType=VARCHAR}, #{modified,jdbcType=TIMESTAMP})"
    })
    int insert(SystemRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_role
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    @InsertProvider(type=SystemRoleSqlProvider.class, method="insertSelective")
    int insertSelective(SystemRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_role
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    @Select({
        "select",
        "id, name, created_by, created, modified_by, modified",
        "from system_role",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="created_by", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="created", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="modified_by", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="modified", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP)
    })
    SystemRole selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_role
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    @UpdateProvider(type=SystemRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_role
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    @Update({
        "update system_role",
        "set name = #{name,jdbcType=VARCHAR},",
          "created_by = #{created_by,jdbcType=VARCHAR},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "modified_by = #{modified_by,jdbcType=VARCHAR},",
          "modified = #{modified,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SystemRole record);


    @DeleteProvider(type=SystemRoleSqlProvider.class, method="remove")
    int remove(SystemRole record);
}