package com.example.demo.mapper;

import com.example.demo.common.PageParams;
import com.example.demo.entity.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("user");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getCompany_id() != null) {
            sql.VALUES("company_id", "#{company_id,jdbcType=BIGINT}");
        }
        
        if (record.getLogin_name() != null) {
            sql.VALUES("login_name", "#{login_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getSalt() != null) {
            sql.VALUES("salt", "#{salt,jdbcType=VARCHAR}");
        }
        
        if (record.getFull_name() != null) {
            sql.VALUES("full_name", "#{full_name,jdbcType=VARCHAR}");
        }
        
        if (record.getDefault_project_id() != null) {
            sql.VALUES("default_project_id", "#{default_project_id,jdbcType=BIGINT}");
        }
        
        if (record.getTime_zone() != null) {
            sql.VALUES("time_zone", "#{time_zone,jdbcType=VARCHAR}");
        }
        
        if (record.getLanguage() != null) {
            sql.VALUES("language", "#{language,jdbcType=VARCHAR}");
        }
        
        if (record.getConx_chat_notification() != null) {
            sql.VALUES("conx_chat_notification", "#{conx_chat_notification,jdbcType=BIT}");
        }
        
        if (record.getEmail_notification() != null) {
            sql.VALUES("email_notification", "#{email_notification,jdbcType=BIT}");
        }
        
        if (record.getConx_cloud_user_name() != null) {
            sql.VALUES("conx_cloud_user_name", "#{conx_cloud_user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
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
        
        if (record.getIs_cloud() != null) {
            sql.VALUES("is_cloud", "#{is_cloud,jdbcType=BIT}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getAvistar() != null) {
            sql.VALUES("avistar", "#{avistar,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("user");
        
        if (record.getCompany_id() != null) {
            sql.SET("company_id = #{company_id,jdbcType=BIGINT}");
        }
        
        if (record.getLogin_name() != null) {
            sql.SET("login_name = #{login_name,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getSalt() != null) {
            sql.SET("salt = #{salt,jdbcType=VARCHAR}");
        }
        
        if (record.getFull_name() != null) {
            sql.SET("full_name = #{full_name,jdbcType=VARCHAR}");
        }
        
        if (record.getDefault_project_id() != null) {
            sql.SET("default_project_id = #{default_project_id,jdbcType=BIGINT}");
        }
        
        if (record.getTime_zone() != null) {
            sql.SET("time_zone = #{time_zone,jdbcType=VARCHAR}");
        }
        
        if (record.getLanguage() != null) {
            sql.SET("language = #{language,jdbcType=VARCHAR}");
        }
        
        if (record.getConx_chat_notification() != null) {
            sql.SET("conx_chat_notification = #{conx_chat_notification,jdbcType=BIT}");
        }
        
        if (record.getEmail_notification() != null) {
            sql.SET("email_notification = #{email_notification,jdbcType=BIT}");
        }
        
        if (record.getConx_cloud_user_name() != null) {
            sql.SET("conx_cloud_user_name = #{conx_cloud_user_name,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
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
        
        if (record.getIs_cloud() != null) {
            sql.SET("is_cloud = #{is_cloud,jdbcType=BIT}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getAvistar() != null) {
            sql.SET("avistar = #{avistar,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=BIGINT}");
        
        return sql.toString();
    }

    public String updateByEmail(User record) {
        SQL sql = new SQL();
        sql.UPDATE("user");

        if (record.getCompany_id() != null) {
            sql.SET("company_id = #{company_id,jdbcType=BIGINT}");
        }

        if (record.getLogin_name() != null) {
            sql.SET("login_name = #{login_name,jdbcType=VARCHAR}");
        }

        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }

        if (record.getSalt() != null) {
            sql.SET("salt = #{salt,jdbcType=VARCHAR}");
        }

        if (record.getFull_name() != null) {
            sql.SET("full_name = #{full_name,jdbcType=VARCHAR}");
        }

        if (record.getDefault_project_id() != null) {
            sql.SET("default_project_id = #{default_project_id,jdbcType=BIGINT}");
        }

        if (record.getTime_zone() != null) {
            sql.SET("time_zone = #{time_zone,jdbcType=VARCHAR}");
        }

        if (record.getLanguage() != null) {
            sql.SET("language = #{language,jdbcType=VARCHAR}");
        }

        if (record.getConx_chat_notification() != null) {
            sql.SET("conx_chat_notification = #{conx_chat_notification,jdbcType=BIT}");
        }

        if (record.getEmail_notification() != null) {
            sql.SET("email_notification = #{email_notification,jdbcType=BIT}");
        }

        if (record.getConx_cloud_user_name() != null) {
            sql.SET("conx_cloud_user_name = #{conx_cloud_user_name,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
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

        if (record.getIs_cloud() != null) {
            sql.SET("is_cloud = #{is_cloud,jdbcType=BIT}");
        }

        if (record.getAvistar() != null) {
            sql.SET("avistar = #{avistar,jdbcType=VARCHAR}");
        }

        sql.WHERE("email = #{email,jdbcType=VARCHAR}");

        return sql.toString();
    }

    public String getUsers(User record) {

        String sql= new SQL(){{
            SELECT("*");
            FROM("user");

            if (record.getId() != null) {
                WHERE("id = #{id}");
            }

            if (record.getCompany_id() != null) {
                WHERE("company_id = #{company_id}");
            }

            if (record.getLogin_name() != null) {
                WHERE("login_name = #{login_name}");
            }

            if (record.getPassword() != null) {
                WHERE("password = #{password}");
            }

            if (record.getFull_name() != null) {
                WHERE("full_name = #{full_name}");
            }

            if (record.getDefault_project_id() != null) {
                WHERE("default_project_id = #{default_project_id}");
            }

            if (record.getTime_zone() != null) {
                WHERE("time_zone = #{time_zone}");
            }

            if (record.getLanguage() != null) {
                WHERE("language = #{language}");
            }

            if (record.getConx_chat_notification() != null) {
                WHERE("conx_chat_notification = #{conx_chat_notification}");
            }

            if (record.getEmail_notification() != null) {
                WHERE("email_notification = #{email_notification}");
            }

            if (record.getConx_cloud_user_name() != null) {
                WHERE("conx_cloud_user_name = #{conx_cloud_user_name}");
            }

            if (record.getStatus() != null) {
                WHERE("status = #{status}");
            }

            if (record.getCreated_by() != null) {
                WHERE("created_by = #{created_by}");
            }

            if (record.getCreated() != null) {
                WHERE("created = #{created}");
            }

            if (record.getModified_by() != null) {
                WHERE("modified_by = #{modified_by}");
            }

            if (record.getModified() != null) {
                WHERE("modified = #{modified}");
            }

            if (record.getIs_cloud() != null) {
                WHERE("is_cloud = #{is_cloud}");
            }

            if (record.getEmail() != null) {
                WHERE("email = #{email}");
            }

            if (record.getAvistar() != null) {
                WHERE("avistar = #{avistar}");
            }
        }}.toString();

        return sql;
    }

    public String getPageUsers(User record, PageParams pageParams) {

        String sql= new SQL(){{
            SELECT("*");
            FROM("user");

            if (record.getId() != null) {
                WHERE("id = #{id}");
            }

            if (record.getCompany_id() != null) {
                WHERE("company_id = #{company_id}");
            }

            if (record.getLogin_name() != null) {
                WHERE("login_name = #{login_name}");
            }

            if (record.getPassword() != null) {
                WHERE("password = #{password}");
            }

            if (record.getFull_name() != null) {
                WHERE("full_name = #{full_name}");
            }

            if (record.getDefault_project_id() != null) {
                WHERE("default_project_id = #{default_project_id}");
            }

            if (record.getTime_zone() != null) {
                WHERE("time_zone = #{time_zone}");
            }

            if (record.getLanguage() != null) {
                WHERE("language = #{language}");
            }

            if (record.getConx_chat_notification() != null) {
                WHERE("conx_chat_notification = #{conx_chat_notification}");
            }

            if (record.getEmail_notification() != null) {
                WHERE("email_notification = #{email_notification}");
            }

            if (record.getConx_cloud_user_name() != null) {
                WHERE("conx_cloud_user_name = #{conx_cloud_user_name}");
            }

            if (record.getStatus() != null) {
                WHERE("status = #{status}");
            }

            if (record.getCreated_by() != null) {
                WHERE("created_by = #{created_by}");
            }

            if (record.getCreated() != null) {
                WHERE("created = #{created}");
            }

            if (record.getModified_by() != null) {
                WHERE("modified_by = #{modified_by}");
            }

            if (record.getModified() != null) {
                WHERE("modified = #{modified}");
            }

            if (record.getIs_cloud() != null) {
                WHERE("is_cloud = #{is_cloud}");
            }

            if (record.getEmail() != null) {
                WHERE("email = #{email}");
            }

            if (record.getAvistar() != null) {
                WHERE("avistar = #{avistar}");
            }

        }}.toString();


        sql += " order by id desc";

        if(pageParams != null){
            Integer OffSet = pageParams.getOffset();
            Integer Limit = pageParams.getLimit();

            if(OffSet != null &&  Limit != null){
                sql += " limit " + OffSet + "," + Limit;
            }

            if(OffSet == null &&  Limit != null){
                sql += " limit " + Limit;
            }
        }

        return sql;
    }

}