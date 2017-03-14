package com.zxk175.ssm.pojo;

import java.util.Date;

public class TUser {
    private Long id;

    private String userName;

    private String userPhone;

    private String userEmail;

    private String userPwd;

    private Short userSex;

    private Date createTime;

    private Date modifyTime;

    private Short state;

    public TUser(Long id, String userName, String userPhone, String userEmail, String userPwd, Short userSex, Date createTime, Date modifyTime, Short state) {
        this.id = id;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userPwd = userPwd;
        this.userSex = userSex;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.state = state;
    }

    public TUser() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public Short getUserSex() {
        return userSex;
    }

    public void setUserSex(Short userSex) {
        this.userSex = userSex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Short getState() {
        return state;
    }

    public void setState(Short state) {
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", userPwd=").append(userPwd);
        sb.append(", userSex=").append(userSex);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }
}