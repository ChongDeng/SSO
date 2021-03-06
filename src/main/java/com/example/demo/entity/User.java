package com.example.demo.entity;

import java.util.Date;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.company_id
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private Long company_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.login_name
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private String login_name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.salt
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private String salt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.full_name
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private String full_name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.default_project_id
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private Long default_project_id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.time_zone
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private String time_zone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.language
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private String language;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.conx_chat_notification
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private Boolean conx_chat_notification;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.email_notification
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private Boolean email_notification;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.conx_cloud_user_name
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private String conx_cloud_user_name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.status
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.created_by
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private String created_by;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.created
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private Date created;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.modified_by
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private String modified_by;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.modified
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private Date modified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.is_cloud
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private Boolean is_cloud;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.email
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.avistar
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    private String avistar;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public User(Long id, Long company_id, String login_name, String password, String salt, String full_name, Long default_project_id, String time_zone, String language, Boolean conx_chat_notification, Boolean email_notification, String conx_cloud_user_name, Integer status, String created_by, Date created, String modified_by, Date modified, Boolean is_cloud, String email, String avistar) {
        this.id = id;
        this.company_id = company_id;
        this.login_name = login_name;
        this.password = password;
        this.salt = salt;
        this.full_name = full_name;
        this.default_project_id = default_project_id;
        this.time_zone = time_zone;
        this.language = language;
        this.conx_chat_notification = conx_chat_notification;
        this.email_notification = email_notification;
        this.conx_cloud_user_name = conx_cloud_user_name;
        this.status = status;
        this.created_by = created_by;
        this.created = created;
        this.modified_by = modified_by;
        this.modified = modified;
        this.is_cloud = is_cloud;
        this.email = email;
        this.avistar = avistar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public User() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.company_id
     *
     * @return the value of user.company_id
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public Long getCompany_id() {
        return company_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.company_id
     *
     * @param company_id the value for user.company_id
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.login_name
     *
     * @return the value of user.login_name
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public String getLogin_name() {
        return login_name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.login_name
     *
     * @param login_name the value for user.login_name
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.salt
     *
     * @return the value of user.salt
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.salt
     *
     * @param salt the value for user.salt
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.full_name
     *
     * @return the value of user.full_name
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public String getFull_name() {
        return full_name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.full_name
     *
     * @param full_name the value for user.full_name
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.default_project_id
     *
     * @return the value of user.default_project_id
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public Long getDefault_project_id() {
        return default_project_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.default_project_id
     *
     * @param default_project_id the value for user.default_project_id
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setDefault_project_id(Long default_project_id) {
        this.default_project_id = default_project_id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.time_zone
     *
     * @return the value of user.time_zone
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public String getTime_zone() {
        return time_zone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.time_zone
     *
     * @param time_zone the value for user.time_zone
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.language
     *
     * @return the value of user.language
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public String getLanguage() {
        return language;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.language
     *
     * @param language the value for user.language
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.conx_chat_notification
     *
     * @return the value of user.conx_chat_notification
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public Boolean getConx_chat_notification() {
        return conx_chat_notification;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.conx_chat_notification
     *
     * @param conx_chat_notification the value for user.conx_chat_notification
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setConx_chat_notification(Boolean conx_chat_notification) {
        this.conx_chat_notification = conx_chat_notification;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.email_notification
     *
     * @return the value of user.email_notification
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public Boolean getEmail_notification() {
        return email_notification;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.email_notification
     *
     * @param email_notification the value for user.email_notification
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setEmail_notification(Boolean email_notification) {
        this.email_notification = email_notification;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.conx_cloud_user_name
     *
     * @return the value of user.conx_cloud_user_name
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public String getConx_cloud_user_name() {
        return conx_cloud_user_name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.conx_cloud_user_name
     *
     * @param conx_cloud_user_name the value for user.conx_cloud_user_name
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setConx_cloud_user_name(String conx_cloud_user_name) {
        this.conx_cloud_user_name = conx_cloud_user_name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.status
     *
     * @return the value of user.status
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.status
     *
     * @param status the value for user.status
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.created_by
     *
     * @return the value of user.created_by
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public String getCreated_by() {
        return created_by;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.created_by
     *
     * @param created_by the value for user.created_by
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.created
     *
     * @return the value of user.created
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.created
     *
     * @param created the value for user.created
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.modified_by
     *
     * @return the value of user.modified_by
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public String getModified_by() {
        return modified_by;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.modified_by
     *
     * @param modified_by the value for user.modified_by
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.modified
     *
     * @return the value of user.modified
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public Date getModified() {
        return modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.modified
     *
     * @param modified the value for user.modified
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.is_cloud
     *
     * @return the value of user.is_cloud
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public Boolean getIs_cloud() {
        return is_cloud;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.is_cloud
     *
     * @param is_cloud the value for user.is_cloud
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setIs_cloud(Boolean is_cloud) {
        this.is_cloud = is_cloud;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.email
     *
     * @return the value of user.email
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.email
     *
     * @param email the value for user.email
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.avistar
     *
     * @return the value of user.avistar
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public String getAvistar() {
        return avistar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.avistar
     *
     * @param avistar the value for user.avistar
     *
     * @mbg.generated Tue Feb 04 22:07:11 PST 2020
     */
    public void setAvistar(String avistar) {
        this.avistar = avistar;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", company_id=" + company_id +
                ", login_name='" + login_name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", full_name='" + full_name + '\'' +
                ", default_project_id=" + default_project_id +
                ", time_zone='" + time_zone + '\'' +
                ", language='" + language + '\'' +
                ", conx_chat_notification=" + conx_chat_notification +
                ", email_notification=" + email_notification +
                ", conx_cloud_user_name='" + conx_cloud_user_name + '\'' +
                ", status=" + status +
                ", created_by='" + created_by + '\'' +
                ", created=" + created +
                ", modified_by='" + modified_by + '\'' +
                ", modified=" + modified +
                ", is_cloud=" + is_cloud +
                ", email='" + email + '\'' +
                ", avistar='" + avistar + '\'' +
                '}';
    }
}