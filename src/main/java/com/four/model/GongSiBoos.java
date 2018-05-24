/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: GongSiBoos
 * Author:   Administrator
 * Date:     2018/5/18 20:02
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
 * @create 2018/5/18
 * @since 1.0.0
 */
public class GongSiBoos implements Serializable {


    private static final long serialVersionUID = 7160062034731468570L;

    private Integer id;
    private Integer comid;
    private String renname;
    private String renphoto;
    private String renzhiwei;
    private String renweibo;
    private String jianjie;
    private String comname;

    public String getComname() {
        return comname;
    }

    public void setComname(String comname) {
        this.comname = comname;
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

    public String getRenname() {
        return renname;
    }

    public void setRenname(String renname) {
        this.renname = renname;
    }

    public String getRenphoto() {
        return renphoto;
    }

    public void setRenphoto(String renphoto) {
        this.renphoto = renphoto;
    }

    public String getRenzhiwei() {
        return renzhiwei;
    }

    public void setRenzhiwei(String renzhiwei) {
        this.renzhiwei = renzhiwei;
    }

    public String getRenweibo() {
        return renweibo;
    }

    public void setRenweibo(String renweibo) {
        this.renweibo = renweibo;
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    @Override
    public String toString() {
        return "GongSiBoos{" +
                "id=" + id +
                ", comid=" + comid +
                ", renname='" + renname + '\'' +
                ", renphoto='" + renphoto + '\'' +
                ", renzhiwei='" + renzhiwei + '\'' +
                ", renweibo='" + renweibo + '\'' +
                ", jianjie='" + jianjie + '\'' +
                ", comname='" + comname + '\'' +
                '}';
    }
}
