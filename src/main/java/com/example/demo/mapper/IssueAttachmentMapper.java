package com.example.demo.mapper;

import com.example.demo.entity.IssueAttachment;
import java.util.Date;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface IssueAttachmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table issue_attachment
     *
     * @mbg.generated Thu Feb 06 14:49:37 PST 2020
     */
    @Delete({
        "delete from issue_attachment",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @DeleteProvider(type=IssueAttachmentSqlProvider.class, method="remove")
    int remove(IssueAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table issue_attachment
     *
     * @mbg.generated Thu Feb 06 14:49:37 PST 2020
     */
    @Insert({
        "insert into issue_attachment (id, attachment_type, ",
        "issue_record_id, issue_id, ",
        "attachment_url, creator, ",
        "created_by, created, ",
        "modified_by, modified, ",
        "is_disabled)",
        "values (#{id,jdbcType=BIGINT}, #{attachment_type,jdbcType=INTEGER}, ",
        "#{issue_record_id,jdbcType=BIGINT}, #{issue_id,jdbcType=BIGINT}, ",
        "#{attachment_url,jdbcType=VARCHAR}, #{creator,jdbcType=BIGINT}, ",
        "#{created_by,jdbcType=VARCHAR}, #{created,jdbcType=TIMESTAMP}, ",
        "#{modified_by,jdbcType=VARCHAR}, #{modified,jdbcType=TIMESTAMP}, ",
        "#{is_disabled,jdbcType=BIT})"
    })
    int insert(IssueAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table issue_attachment
     *
     * @mbg.generated Thu Feb 06 14:49:37 PST 2020
     */
    @InsertProvider(type=IssueAttachmentSqlProvider.class, method="insertSelective")
    int insertSelective(IssueAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table issue_attachment
     *
     * @mbg.generated Thu Feb 06 14:49:37 PST 2020
     */
    @Select({
        "select",
        "id, attachment_type, issue_record_id, issue_id, attachment_url, creator, created_by, ",
        "created, modified_by, modified, is_disabled",
        "from issue_attachment",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ConstructorArgs({
        @Arg(column="id", javaType=Long.class, jdbcType=JdbcType.BIGINT, id=true),
        @Arg(column="attachment_type", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
        @Arg(column="issue_record_id", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="issue_id", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="attachment_url", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="creator", javaType=Long.class, jdbcType=JdbcType.BIGINT),
        @Arg(column="created_by", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="created", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="modified_by", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="modified", javaType=Date.class, jdbcType=JdbcType.TIMESTAMP),
        @Arg(column="is_disabled", javaType=Boolean.class, jdbcType=JdbcType.BIT)
    })
    IssueAttachment selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table issue_attachment
     *
     * @mbg.generated Thu Feb 06 14:49:37 PST 2020
     */
    @UpdateProvider(type=IssueAttachmentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(IssueAttachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table issue_attachment
     *
     * @mbg.generated Thu Feb 06 14:49:37 PST 2020
     */
    @Update({
        "update issue_attachment",
        "set attachment_type = #{attachment_type,jdbcType=INTEGER},",
          "issue_record_id = #{issue_record_id,jdbcType=BIGINT},",
          "issue_id = #{issue_id,jdbcType=BIGINT},",
          "attachment_url = #{attachment_url,jdbcType=VARCHAR},",
          "creator = #{creator,jdbcType=BIGINT},",
          "created_by = #{created_by,jdbcType=VARCHAR},",
          "created = #{created,jdbcType=TIMESTAMP},",
          "modified_by = #{modified_by,jdbcType=VARCHAR},",
          "modified = #{modified,jdbcType=TIMESTAMP},",
          "is_disabled = #{is_disabled,jdbcType=BIT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(IssueAttachment record);
}