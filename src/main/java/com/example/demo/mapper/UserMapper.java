package com.example.demo.mapper;

import com.example.demo.common.PageParams;
import com.example.demo.entity.User;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    @Insert({
        "insert into user (id, company_id, ",
        "login_name, password, ",
        "salt, full_name, ",
        "default_project_id, time_zone, ",
        "language, conx_chat_notification, ",
        "email_notification, conx_cloud_user_name, ",
        "status, created_by, ",
        "created, modified_by, ",
        "modified, is_cloud, ",
        "email, avistar)",
        "values (#{id,jdbcType=BIGINT}, #{company_id,jdbcType=BIGINT}, ",
        "#{login_name,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{salt,jdbcType=VARCHAR}, #{full_name,jdbcType=VARCHAR}, ",
        "#{default_project_id,jdbcType=BIGINT}, #{time_zone,jdbcType=VARCHAR}, ",
        "#{language,jdbcType=VARCHAR}, #{conx_chat_notification,jdbcType=BIT}, ",
        "#{email_notification,jdbcType=BIT}, #{conx_cloud_user_name,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{created_by,jdbcType=VARCHAR}, ",
        "#{created,jdbcType=TIMESTAMP}, #{modified_by,jdbcType=VARCHAR}, ",
        "#{modified,jdbcType=TIMESTAMP}, #{is_cloud,jdbcType=BIT}, ",
        "#{email,jdbcType=VARCHAR}, #{avistar,jdbcType=VARCHAR})"
    })
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    @Select({
        "select",
        "id, company_id, login_name, password, salt, full_name, default_project_id, time_zone, ",
        "language, conx_chat_notification, email_notification, conx_cloud_user_name, ",
        "status, created_by, created, modified_by, modified, is_cloud, email, avistar",
        "from user",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="company_id", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="login_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="salt", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="full_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="default_project_id", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="time_zone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="language", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="conx_chat_notification", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="email_notification", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="conx_cloud_user_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="status", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="created_by", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="created", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="modified_by", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="modified", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="is_cloud", javaType=Boolean.class, jdbcType=JdbcType.BIT),
        @Arg(column="email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="avistar", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Long id);


    @SelectProvider(type=UserSqlProvider.class, method="getUsers")
    List<User> getUsers(User record);

    @SelectProvider(type=UserSqlProvider.class, method="getPageUsers")
    List<User> getPageUsers(User record, PageParams pageParams);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);


    @UpdateProvider(type=UserSqlProvider.class, method="updateByEmail")
    int updateByEmail(User record);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    @Update({
        "update user",
        "set company_id = #{company_id,jdbcType=BIGINT},",
          "login_name = #{login_name,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "salt = #{salt,jdbcType=VARCHAR},",
          "full_name = #{full_name,jdbcType=VARCHAR},",
          "default_project_id = #{default_project_id,jdbcType=BIGINT},",
          "time_zone = #{time_zone,jdbcType=VARCHAR},",
          "language = #{language,jdbcType=VARCHAR},",
          "conx_chat_notification = #{conx_chat_notification,jdbcType=BIT},",
          "email_notification = #{email_notification,jdbcType=BIT},",
          "conx_cloud_user_name = #{conx_cloud_user_name,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "created_by = #{created_by,jdbcType=VARCHAR},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "modified_by = #{modified_by,jdbcType=VARCHAR},",
          "modified = #{modified,jdbcType=TIMESTAMP},",
          "is_cloud = #{is_cloud,jdbcType=BIT},",
          "email = #{email,jdbcType=VARCHAR},",
          "avistar = #{avistar,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(User record);
}