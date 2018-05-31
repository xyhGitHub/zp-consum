package com.four.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 张大大 on 2018/5/30.
 */
public class XiangQing implements Serializable {


    private static final long serialVersionUID = 4185009803373372107L;

    //用户id
    private Integer userid;

    //用户类型
    private Integer userTtpe;


    //用户帐号
    private String username;

    //用户性别,0男,1女
    private Integer usersex;

    //用户登录名字,
    private String loginname;

    //部门id,
    private Integer deptid;

    //用户类型,
    private Integer typeid;

    //用户名称
    private String typename;

    //所属部门名称
    private String deptname;

    //公司id
    private Integer companyid;

    //公司名称
    private String companyname;

    //联系电话
    private String userphone;

    //用户密码
    private String pwd;

    private List<Tree> listTree;

    //用于用户注册时的验证码
    private String checkcode;

    //用于用户注册时的手机验证码
    private Integer checkPhone;

    //用户邮箱,用于发送面试通知邮件
    private String  email;

    private String qiwangchengshi;
    private String qiwangzhiye;
    private String qiwangzhiwei;
    private String qiwangyuexin;
    private String gongzuogongsimingcheng;
    private String gongzuozhiweimingcheng;
    private String gongzuokaishinianfen;
    private String gongzuokaishiyuefen;
    private String gongzuojiesuyuefen;
    private String xiangmumingcheng;
    private String xiangmuzhiwu;
    private String xiangmukaishinianfen;
    private String xiangmukaishiyuefen;
    private String xiangmujiesunianfen;
    private String xiangmujiesuyuefen;
    private String xiangmumiaosu;
    private String xuexiaomingcheng;
    private String xueli;
    private String zhuanyemingcheng;
    private String xuexiaokaishinianfen;
    private String xuexiaojiesunianfen;
    private String ziwojieshao;
    private String xiangmulujing;
    private String zuopinshuoming;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserTtpe() {
        return userTtpe;
    }

    public void setUserTtpe(Integer userTtpe) {
        this.userTtpe = userTtpe;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUsersex() {
        return usersex;
    }

    public void setUsersex(Integer usersex) {
        this.usersex = usersex;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Integer getCompanyid() {
        return companyid;
    }

    public void setCompanyid(Integer companyid) {
        this.companyid = companyid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public List<Tree> getListTree() {
        return listTree;
    }

    public void setListTree(List<Tree> listTree) {
        this.listTree = listTree;
    }

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    public Integer getCheckPhone() {
        return checkPhone;
    }

    public void setCheckPhone(Integer checkPhone) {
        this.checkPhone = checkPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQiwangchengshi() {
        return qiwangchengshi;
    }

    public void setQiwangchengshi(String qiwangchengshi) {
        this.qiwangchengshi = qiwangchengshi;
    }

    public String getQiwangzhiye() {
        return qiwangzhiye;
    }

    public void setQiwangzhiye(String qiwangzhiye) {
        this.qiwangzhiye = qiwangzhiye;
    }

    public String getQiwangzhiwei() {
        return qiwangzhiwei;
    }

    public void setQiwangzhiwei(String qiwangzhiwei) {
        this.qiwangzhiwei = qiwangzhiwei;
    }

    public String getQiwangyuexin() {
        return qiwangyuexin;
    }

    public void setQiwangyuexin(String qiwangyuexin) {
        this.qiwangyuexin = qiwangyuexin;
    }

    public String getGongzuogongsimingcheng() {
        return gongzuogongsimingcheng;
    }

    public void setGongzuogongsimingcheng(String gongzuogongsimingcheng) {
        this.gongzuogongsimingcheng = gongzuogongsimingcheng;
    }

    public String getGongzuozhiweimingcheng() {
        return gongzuozhiweimingcheng;
    }

    public void setGongzuozhiweimingcheng(String gongzuozhiweimingcheng) {
        this.gongzuozhiweimingcheng = gongzuozhiweimingcheng;
    }

    public String getGongzuokaishinianfen() {
        return gongzuokaishinianfen;
    }

    public void setGongzuokaishinianfen(String gongzuokaishinianfen) {
        this.gongzuokaishinianfen = gongzuokaishinianfen;
    }

    public String getGongzuokaishiyuefen() {
        return gongzuokaishiyuefen;
    }

    public void setGongzuokaishiyuefen(String gongzuokaishiyuefen) {
        this.gongzuokaishiyuefen = gongzuokaishiyuefen;
    }

    public String getGongzuojiesuyuefen() {
        return gongzuojiesuyuefen;
    }

    public void setGongzuojiesuyuefen(String gongzuojiesuyuefen) {
        this.gongzuojiesuyuefen = gongzuojiesuyuefen;
    }

    public String getXiangmumingcheng() {
        return xiangmumingcheng;
    }

    public void setXiangmumingcheng(String xiangmumingcheng) {
        this.xiangmumingcheng = xiangmumingcheng;
    }

    public String getXiangmuzhiwu() {
        return xiangmuzhiwu;
    }

    public void setXiangmuzhiwu(String xiangmuzhiwu) {
        this.xiangmuzhiwu = xiangmuzhiwu;
    }

    public String getXiangmukaishinianfen() {
        return xiangmukaishinianfen;
    }

    public void setXiangmukaishinianfen(String xiangmukaishinianfen) {
        this.xiangmukaishinianfen = xiangmukaishinianfen;
    }

    public String getXiangmukaishiyuefen() {
        return xiangmukaishiyuefen;
    }

    public void setXiangmukaishiyuefen(String xiangmukaishiyuefen) {
        this.xiangmukaishiyuefen = xiangmukaishiyuefen;
    }

    public String getXiangmujiesunianfen() {
        return xiangmujiesunianfen;
    }

    public void setXiangmujiesunianfen(String xiangmujiesunianfen) {
        this.xiangmujiesunianfen = xiangmujiesunianfen;
    }

    public String getXiangmujiesuyuefen() {
        return xiangmujiesuyuefen;
    }

    public void setXiangmujiesuyuefen(String xiangmujiesuyuefen) {
        this.xiangmujiesuyuefen = xiangmujiesuyuefen;
    }

    public String getXiangmumiaosu() {
        return xiangmumiaosu;
    }

    public void setXiangmumiaosu(String xiangmumiaosu) {
        this.xiangmumiaosu = xiangmumiaosu;
    }

    public String getXuexiaomingcheng() {
        return xuexiaomingcheng;
    }

    public void setXuexiaomingcheng(String xuexiaomingcheng) {
        this.xuexiaomingcheng = xuexiaomingcheng;
    }

    public String getXueli() {
        return xueli;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli;
    }

    public String getZhuanyemingcheng() {
        return zhuanyemingcheng;
    }

    public void setZhuanyemingcheng(String zhuanyemingcheng) {
        this.zhuanyemingcheng = zhuanyemingcheng;
    }

    public String getXuexiaokaishinianfen() {
        return xuexiaokaishinianfen;
    }

    public void setXuexiaokaishinianfen(String xuexiaokaishinianfen) {
        this.xuexiaokaishinianfen = xuexiaokaishinianfen;
    }

    public String getXuexiaojiesunianfen() {
        return xuexiaojiesunianfen;
    }

    public void setXuexiaojiesunianfen(String xuexiaojiesunianfen) {
        this.xuexiaojiesunianfen = xuexiaojiesunianfen;
    }

    public String getZiwojieshao() {
        return ziwojieshao;
    }

    public void setZiwojieshao(String ziwojieshao) {
        this.ziwojieshao = ziwojieshao;
    }

    public String getXiangmulujing() {
        return xiangmulujing;
    }

    public void setXiangmulujing(String xiangmulujing) {
        this.xiangmulujing = xiangmulujing;
    }

    public String getZuopinshuoming() {
        return zuopinshuoming;
    }

    public void setZuopinshuoming(String zuopinshuoming) {
        this.zuopinshuoming = zuopinshuoming;
    }

    @Override
    public String toString() {
        return "XiangQing{" +
                "userid=" + userid +
                ", userTtpe=" + userTtpe +
                ", username='" + username + '\'' +
                ", usersex=" + usersex +
                ", loginname='" + loginname + '\'' +
                ", deptid=" + deptid +
                ", typeid=" + typeid +
                ", typename='" + typename + '\'' +
                ", deptname='" + deptname + '\'' +
                ", companyid=" + companyid +
                ", companyname='" + companyname + '\'' +
                ", userphone='" + userphone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", listTree=" + listTree +
                ", checkcode='" + checkcode + '\'' +
                ", checkPhone=" + checkPhone +
                ", email='" + email + '\'' +
                ", qiwangchengshi='" + qiwangchengshi + '\'' +
                ", qiwangzhiye='" + qiwangzhiye + '\'' +
                ", qiwangzhiwei='" + qiwangzhiwei + '\'' +
                ", qiwangyuexin='" + qiwangyuexin + '\'' +
                ", gongzuogongsimingcheng='" + gongzuogongsimingcheng + '\'' +
                ", gongzuozhiweimingcheng='" + gongzuozhiweimingcheng + '\'' +
                ", gongzuokaishinianfen='" + gongzuokaishinianfen + '\'' +
                ", gongzuokaishiyuefen='" + gongzuokaishiyuefen + '\'' +
                ", gongzuojiesuyuefen='" + gongzuojiesuyuefen + '\'' +
                ", xiangmumingcheng='" + xiangmumingcheng + '\'' +
                ", xiangmuzhiwu='" + xiangmuzhiwu + '\'' +
                ", xiangmukaishinianfen='" + xiangmukaishinianfen + '\'' +
                ", xiangmukaishiyuefen='" + xiangmukaishiyuefen + '\'' +
                ", xiangmujiesunianfen='" + xiangmujiesunianfen + '\'' +
                ", xiangmujiesuyuefen='" + xiangmujiesuyuefen + '\'' +
                ", xiangmumiaosu='" + xiangmumiaosu + '\'' +
                ", xuexiaomingcheng='" + xuexiaomingcheng + '\'' +
                ", xueli='" + xueli + '\'' +
                ", zhuanyemingcheng='" + zhuanyemingcheng + '\'' +
                ", xuexiaokaishinianfen='" + xuexiaokaishinianfen + '\'' +
                ", xuexiaojiesunianfen='" + xuexiaojiesunianfen + '\'' +
                ", ziwojieshao='" + ziwojieshao + '\'' +
                ", xiangmulujing='" + xiangmulujing + '\'' +
                ", zuopinshuoming='" + zuopinshuoming + '\'' +
                '}';
    }
}
