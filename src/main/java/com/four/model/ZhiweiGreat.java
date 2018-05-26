/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ZhiweiGreat
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
public class
ZhiweiGreat implements Serializable {

    private static final long serialVersionUID = -1521846746072971811L;
    private Integer id;
    private Integer comid;
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "ZhiweiGreat{" +
                "id=" + id +
                ", comid=" + comid +
                ", name='" + name + '\'' +
                ", comname='" + comname + '\'' +
                '}';
    }
}
