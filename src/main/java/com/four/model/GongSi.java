/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: GongSi
 * Author:   Administrator
 * Date:     2018/5/16 14:22
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
 * @create 2018/5/16
 * @since 1.0.0
 */
public class GongSi implements Serializable {

    private static final long serialVersionUID = -1985082901643432098L;
    private  Integer comid;
    private  String comname;
    private  String  comphoto;
    private  String  comjieshao;
    private  Integer  comshenhe;
    private  String comaddress;
    private  String comguimo;

    public Integer getComid() {
        return comid;
    }

    public void setComid(Integer comid) {
        this.comid = comid;
    }

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
    }

    public String getComphoto() {
        return comphoto;
    }

    public void setComphoto(String comphoto) {
        this.comphoto = comphoto;
    }

    public String getComjieshao() {
        return comjieshao;
    }

    public void setComjieshao(String comjieshao) {
        this.comjieshao = comjieshao;
    }

    public Integer getComshenhe() {
        return comshenhe;
    }

    public void setComshenhe(Integer comshenhe) {
        this.comshenhe = comshenhe;
    }

    public String getComaddress() {
        return comaddress;
    }

    public void setComaddress(String comaddress) {
        this.comaddress = comaddress;
    }

    public String getComguimo() {
        return comguimo;
    }

    public void setComguimo(String comguimo) {
        this.comguimo = comguimo;
    }

    @Override
    public String toString() {
        return "GongSi{" +
                "comid=" + comid +
                ", comname='" + comname + '\'' +
                ", comphoto='" + comphoto + '\'' +
                ", comjieshao='" + comjieshao + '\'' +
                ", comshenhe=" + comshenhe +
                ", comaddress='" + comaddress + '\'' +
                ", comguimo='" + comguimo + '\'' +
                '}';
    }
}
