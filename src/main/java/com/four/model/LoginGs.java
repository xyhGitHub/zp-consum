package com.four.model;

import org.springframework.data.annotation.Transient;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/23.
 */
public class LoginGs implements Serializable {
    private static final long serialVersionUID = 4125127317353765321L;

    private Integer loginId;
    private String loginTel;
    private String loginPwd;
    private String createtime;

    @Transient
    private String loginCode;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getLoginTel() {
        return loginTel;
    }

    public void setLoginTel(String loginTel) {
        this.loginTel = loginTel;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "LoginGs{" +
                "loginId=" + loginId +
                ", loginTel='" + loginTel + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", createtime='" + createtime + '\'' +
                ", loginCode='" + loginCode + '\'' +
                '}';
    }
}
