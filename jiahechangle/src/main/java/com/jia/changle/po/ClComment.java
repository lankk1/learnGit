package com.jia.changle.po;

import java.util.Date;

public class ClComment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cl_comment.comment_id
     *
     * @mbggenerated
     */
    private Integer commentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cl_comment.comment_user
     *
     * @mbggenerated
     */
    private String commentUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cl_comment.comment_email
     *
     * @mbggenerated
     */
    private String commentEmail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cl_comment.comment_address
     *
     * @mbggenerated
     */
    private String commentAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cl_comment.comment_tel
     *
     * @mbggenerated
     */
    private String commentTel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cl_comment.status
     *
     * @mbggenerated
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cl_comment.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cl_comment.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cl_comment.comment_content
     *
     * @mbggenerated
     */
    private String commentContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cl_comment.comment_id
     *
     * @return the value of cl_comment.comment_id
     *
     * @mbggenerated
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cl_comment.comment_id
     *
     * @param commentId the value for cl_comment.comment_id
     *
     * @mbggenerated
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cl_comment.comment_user
     *
     * @return the value of cl_comment.comment_user
     *
     * @mbggenerated
     */
    public String getCommentUser() {
        return commentUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cl_comment.comment_user
     *
     * @param commentUser the value for cl_comment.comment_user
     *
     * @mbggenerated
     */
    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser == null ? null : commentUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cl_comment.comment_email
     *
     * @return the value of cl_comment.comment_email
     *
     * @mbggenerated
     */
    public String getCommentEmail() {
        return commentEmail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cl_comment.comment_email
     *
     * @param commentEmail the value for cl_comment.comment_email
     *
     * @mbggenerated
     */
    public void setCommentEmail(String commentEmail) {
        this.commentEmail = commentEmail == null ? null : commentEmail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cl_comment.comment_address
     *
     * @return the value of cl_comment.comment_address
     *
     * @mbggenerated
     */
    public String getCommentAddress() {
        return commentAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cl_comment.comment_address
     *
     * @param commentAddress the value for cl_comment.comment_address
     *
     * @mbggenerated
     */
    public void setCommentAddress(String commentAddress) {
        this.commentAddress = commentAddress == null ? null : commentAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cl_comment.comment_tel
     *
     * @return the value of cl_comment.comment_tel
     *
     * @mbggenerated
     */
    public String getCommentTel() {
        return commentTel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cl_comment.comment_tel
     *
     * @param commentTel the value for cl_comment.comment_tel
     *
     * @mbggenerated
     */
    public void setCommentTel(String commentTel) {
        this.commentTel = commentTel == null ? null : commentTel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cl_comment.status
     *
     * @return the value of cl_comment.status
     *
     * @mbggenerated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cl_comment.status
     *
     * @param status the value for cl_comment.status
     *
     * @mbggenerated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cl_comment.update_time
     *
     * @return the value of cl_comment.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cl_comment.update_time
     *
     * @param updateTime the value for cl_comment.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cl_comment.create_time
     *
     * @return the value of cl_comment.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cl_comment.create_time
     *
     * @param createTime the value for cl_comment.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cl_comment.comment_content
     *
     * @return the value of cl_comment.comment_content
     *
     * @mbggenerated
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cl_comment.comment_content
     *
     * @param commentContent the value for cl_comment.comment_content
     *
     * @mbggenerated
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }
}