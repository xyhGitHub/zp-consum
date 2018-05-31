/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: Zhiwei
 * Author:   Administrator
 * Date:     2018/5/21 10:49
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.four.model;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2018/5/21
 * @since 1.0.0
 */
public class Zhiwei  implements Serializable{

    private static final long serialVersionUID = 3249773949331623106L;
    private  Integer id;
    private  Integer comid;
    private  Integer daid;
    private  Integer xiaoid;
    private  String zhiweiname;    //职位名字
    private  Integer zhiweigreatid;
    private  String xingzhi;
    private  String xinzi;
    private  String city;
    private  String jingyan;
    private  String xueli;
    private  String youhuo;
    private  String name;
    private String  comname;
    private String  daname;
    private  String xiaoname;

    public String getDaname() {

        return daname;
    }

    public void setDaname(String daname) {
        this.daname = daname;
    }

    public String getXiaoname() {
        return xiaoname;
    }

    public void setXiaoname(String xiaoname) {
        this.xiaoname = xiaoname;
    }

    public Integer getDaid() {
        return daid;
    }

    public void setDaid(Integer daid) {
        this.daid = daid;
    }

    public Integer getXiaoid() {
        return xiaoid;
    }

    public void setXiaoid(Integer xiaoid) {
        this.xiaoid = xiaoid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public String getZhiweiname() {
        return zhiweiname;
    }

    public void setZhiweiname(String zhiweiname) {
        this.zhiweiname = zhiweiname;
    }

    public Integer getZhiweigreatid() {
        return zhiweigreatid;
    }

    public void setZhiweigreatid(Integer zhiweigreatid) {
        this.zhiweigreatid = zhiweigreatid;
    }

    public String getXingzhi() {
        return xingzhi;
    }

    public void setXingzhi(String xingzhi) {
        this.xingzhi = xingzhi;
    }

    public String getXinzi() {
        return xinzi;
    }

    public void setXinzi(String xinzi) {
        this.xinzi = xinzi;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getJingyan() {
        return jingyan;
    }

    public void setJingyan(String jingyan) {
        this.jingyan = jingyan;
    }

    public String getXueli() {
        return xueli;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli;
    }

    public String getYouhuo() {
        return youhuo;
    }

    public void setYouhuo(String youhuo) {
        this.youhuo = youhuo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    @Override
    public String toString() {
        return "Zhiwei{" +
                "id=" + id +
                ", comid=" + comid +
                ", daid=" + daid +
                ", xiaoid=" + xiaoid +
                ", zhiweiname='" + zhiweiname + '\'' +
                ", zhiweigreatid=" + zhiweigreatid +
                ", xingzhi='" + xingzhi + '\'' +
                ", xinzi='" + xinzi + '\'' +
                ", city='" + city + '\'' +
                ", jingyan='" + jingyan + '\'' +
                ", xueli='" + xueli + '\'' +
                ", youhuo='" + youhuo + '\'' +
                ", name='" + name + '\'' +
                ", comname='" + comname + '\'' +
                ", daname='" + daname + '\'' +
                ", xiaoname='" + xiaoname + '\'' +
                '}';
    }
}
