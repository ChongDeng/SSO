package com.example.demo.mapper;

import com.example.demo.entity.UserSystemRole;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserSystemRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_system_role
     *
     * @mbg.generated Thu Feb 13 10:55:40 PST 2020
     */
    @Delete({
        "delete from user_system_role",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_system_role
     *
     * @mbg.generated Thu Feb 13 10:55:40 PST 2020
     */
    @Insert({
        "insert into user_system_role (id, user_id, ",
        "system_role_id)",
        "values (#{id,jdbcType=BIGINT}, #{user_id,jdbcType=BIGINT}, ",
        "#{system_role_id,jdbcType=BIGINT})"
    })
    int insert(UserSystemRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_system_role
     *
     * @mbg.generated Thu Feb 13 10:55:40 PST 2020
     */
    @InsertProvider(type=UserSystemRoleSqlProvider.class, method="insertSelective")
    int insertSelective(UserSystemRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_system_role
     *
     * @mbg.generated Thu Feb 13 10:55:40 PST 2020
     */
    @Select({
        "select",
        "id, user_id, system_role_id",
        "from user_system_role",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="user_id", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="system_role_id", javaType=Long.class, jdbcType=JdbcType.BIGINT)
    })
    UserSystemRole selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_system_role
     *
     * @mbg.generated Thu Feb 13 10:55:40 PST 2020
     */
    @UpdateProvider(type=UserSystemRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserSystemRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_system_role
     *
     * @mbg.generated Thu Feb 13 10:55:40 PST 2020
     */
    @Update({
        "update user_system_role",
        "set user_id = #{user_id,jdbcType=BIGINT},",
          "system_role_id = #{system_role_id,jdbcType=BIGINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(UserSystemRole record);


    //1 删
    @DeleteProvider(type=UserSystemRoleSqlProvider.class, method="remove")
    int remove(UserSystemRole record);

    //2 改
    @Update({
            "update user_system_role",
            "set system_role_id = #{new_role_id}",
            "where user_id = #{user_id} and system_role_id = #{system_role_id}"
    })
    int update(@Param("user_id") Long user_id, @Param("system_role_id") Long system_role_id, @Param("new_role_id") Long new_role_id);

    //3 查
    @SelectProvider(type=UserSystemRoleSqlProvider.class, method="getItems")
    List<UserSystemRole> getItems(UserSystemRole record);
}