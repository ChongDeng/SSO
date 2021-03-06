package com.example.demo.mapper;

import com.example.demo.entity.SystemRole;
import org.apache.ibatis.jdbc.SQL;

public class SystemRoleSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_role
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    public String insertSelective(SystemRole record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("system_role");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCreated_by() != null) {
            sql.VALUES("created_by", "#{created_by,jdbcType=VARCHAR}");
        }
        
        if (record.getCreated() != null) {
            sql.VALUES("created", "#{created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModified_by() != null) {
            sql.VALUES("modified_by", "#{modified_by,jdbcType=VARCHAR}");
        }
        
        if (record.getModified() != null) {
            sql.VALUES("modified", "#{modified,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_role
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    public String updateByPrimaryKeySelective(SystemRole record) {
        SQL sql = new SQL();
        sql.UPDATE("system_role");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCreated_by() != null) {
            sql.SET("created_by = #{created_by,jdbcType=VARCHAR}");
        }
        
        if (record.getCreated() != null) {
            sql.SET("created = #{created,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModified_by() != null) {
            sql.SET("modified_by = #{modified_by,jdbcType=VARCHAR}");
        }
        
        if (record.getModified() != null) {
            sql.SET("modified = #{modified,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }


    //chong
    public String remove(SystemRole record) {
        return new SQL() {{
            DELETE_FROM("system_role");

            if (record.getId() != null) {
                WHERE("id=#{id,jdbcType=BIGINT}");
            }

            if (record.getCreated() != null) {
                WHERE("created = #{created,jdbcType=TIMESTAMP}");
            }

            if (record.getCreated_by() != null) {
                WHERE("created_by = #{created_by,jdbcType=VARCHAR}");
            }

            if (record.getModified() != null) {
                WHERE("modified = #{modified,jdbcType=TIMESTAMP}");
            }

            if (record.getModified_by() != null) {
                WHERE("modified_by = #{modified_by,jdbcType=VARCHAR}");
            }

            if (record.getName() != null) {
                WHERE("name = #{name,jdbcType=VARCHAR}");
            }
        }}.toString();
    }
}