package com.example.demo.entity;

import java.util.Date;

public class SystemRole {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_role.id
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_role.name
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_role.created_by
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    private String created_by;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_role.created
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    private Date created;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_role.modified_by
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    private String modified_by;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column system_role.modified
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    private Date modified;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_role
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    public SystemRole(Long id, String name, String created_by, Date created, String modified_by, Date modified) {
        this.id = id;
        this.name = name;
        this.created_by = created_by;
        this.created = created;
        this.modified_by = modified_by;
        this.modified = modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table system_role
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    public SystemRole() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_role.id
     *
     * @return the value of system_role.id
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_role.id
     *
     * @param id the value for system_role.id
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_role.name
     *
     * @return the value of system_role.name
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_role.name
     *
     * @param name the value for system_role.name
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_role.created_by
     *
     * @return the value of system_role.created_by
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    public String getCreated_by() {
        return created_by;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_role.created_by
     *
     * @param created_by the value for system_role.created_by
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_role.created
     *
     * @return the value of system_role.created
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_role.created
     *
     * @param created the value for system_role.created
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_role.modified_by
     *
     * @return the value of system_role.modified_by
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    public String getModified_by() {
        return modified_by;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_role.modified_by
     *
     * @param modified_by the value for system_role.modified_by
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column system_role.modified
     *
     * @return the value of system_role.modified
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    public Date getModified() {
        return modified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column system_role.modified
     *
     * @param modified the value for system_role.modified
     *
     * @mbg.generated Thu Feb 13 10:49:27 PST 2020
     */
    public void setModified(Date modified) {
        this.modified = modified;
    }
}