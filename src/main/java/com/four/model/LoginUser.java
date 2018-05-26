package com.four.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/19.
 */
public class LoginUser implements Serializable{

    private static final long serialVersionUID = 7456506081120323373L;
    //登录表
    private Integer loginId;
    private String loginName;
    private String loginPwd;
    private Integer userType;
    private Integer userid;
    private Integer comid;
    private String createtime;
    //    @Transient
    private String checkCode;
    //    @Transient
    private Integer nums;
    //    @Transient
    private String names;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
    //    @Transient
    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }
    //    @Transient
    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "loginId=" + loginId +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", userType=" + userType +
                ", userid=" + userid +
                ", comid=" + comid +
                ", createtime='" + createtime + '\'' +
                ", checkCode='" + checkCode + '\'' +
                ", nums='" + nums + '\'' +
                ", names='" + names + '\'' +
                '}';
    }
}
