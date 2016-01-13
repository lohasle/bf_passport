package com.sz.weizy.passport.dao.entities;

import java.util.Date;

public class SnsUser {
    private Integer id;

    private String name;

    private String pwdHash;

    private String userName;

    private String phone;

    private String avatar;

    private String email;

    private String ucCode;

    private String salt;

    private Integer state;

    private Date createTime;

    private Date modifyTime;

    private String ucToken;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwdHash() {
        return pwdHash;
    }

    public void setPwdHash(String pwdHash) {
        this.pwdHash = pwdHash == null ? null : pwdHash.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getUcCode() {
        return ucCode;
    }

    public void setUcCode(String ucCode) {
        this.ucCode = ucCode == null ? null : ucCode.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public String getUcToken() {
        return ucToken;
    }

    public void setUcToken(String ucToken) {
        this.ucToken = ucToken == null ? null : ucToken.trim();
    }

    @Override
    public String toString() {
        return "SnsUser{" +
                "ucToken='" + ucToken + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", pwdHash='" + pwdHash + '\'' +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", ucCode='" + ucCode + '\'' +
                ", salt='" + salt + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                '}';
    }


}