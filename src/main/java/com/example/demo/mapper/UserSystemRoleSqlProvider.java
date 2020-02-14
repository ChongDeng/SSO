package com.example.demo.mapper;

import com.example.demo.entity.UserSystemRole;
import org.apache.ibatis.jdbc.SQL;

public class UserSystemRoleSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_system_role
     *
     * @mbg.generated Thu Feb 13 10:55:40 PST 2020
     */
    public String insertSelective(UserSystemRole record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user_system_role");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getUser_id() != null) {
            sql.VALUES("user_id", "#{user_id,jdbcType=BIGINT}");
        }
        
        if (record.getSystem_role_id() != null) {
            sql.VALUES("system_role_id", "#{system_role_id,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_system_role
     *
     * @mbg.generated Thu Feb 13 10:55:40 PST 2020
     */
    public String updateByPrimaryKeySelective(UserSystemRole record) {
        SQL sql = new SQL();
        sql.UPDATE("user_system_role");
        
        if (record.getUser_id() != null) {
            sql.SET("user_id = #{user_id,jdbcType=BIGINT}");
        }
        
        if (record.getSystem_role_id() != null) {
            sql.SET("system_role_id = #{system_role_id,jdbcType=BIGINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }


    /** 1 删。方法：
     *        第一步：从本文件的insertSelective方法中拷贝各个参数过来
     *        第二步：修改sql动词：DELETE_FROM("user_system_role");
     *        第三步： 将sql.VALUES换成WHERE；同时，将", "换成=
     * */
    //chong
    public String remove(UserSystemRole record) {
        return new SQL() {{
            DELETE_FROM("user_system_role");

            if (record.getId() != null) {
                WHERE("id=#{id,jdbcType=BIGINT}");
            }

            if (record.getUser_id() != null) {
                WHERE("user_id=#{user_id,jdbcType=BIGINT}");
            }

            if (record.getSystem_role_id() != null) {
                WHERE("system_role_id=#{system_role_id,jdbcType=BIGINT}");
            }
        }}.toString();
    }

    /** 2 改：
     *        (1) 有时，不适合在这个类中写。请直接在mapper类中写
     *        (2) 有时，适合在这个类中写，例如在UserSqlProvider类中实现updateByEmail(User record)方法那样
     *
     *        这个应用场景就是直接在mapper类中去写。
     * */

    /** 3 查。方法：
     *        第一步：从本文件的insertSelective方法中拷贝各个参数过来
     *        第二步：修改sql动词：
     *                      SELECT("*");
     *                      FROM("user_system_role");
     *        第三步： 将sql.VALUES换成WHERE；同时，将", "换成=
     * */
    public String getItems(UserSystemRole record) {

        return new SQL(){{
            SELECT("*");
            FROM("user_system_role");

            if (record.getId() != null) {
                WHERE("id = #{id}");
            }

            if (record.getUser_id() != null) {
                WHERE("user_id=#{user_id,jdbcType=BIGINT}");
            }

            if (record.getSystem_role_id() != null) {
                WHERE("system_role_id=#{system_role_id,jdbcType=BIGINT}");
            }
        }}.toString();

    }
}