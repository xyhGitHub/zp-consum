/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ZhiweiLittle
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
public class ZhiweiLittle implements Serializable{

    private static final long serialVersionUID = -636964513266566633L;
    private Integer id;
    private Integer greatid;
    private  String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGreatid() {
        return greatid;
    }

    public void setGreatid(Integer greatid) {
        this.greatid = greatid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ZhiweiLittle{" +
                "id=" + id +
                ", greatid=" + greatid +
                ", name='" + name + '\'' +
                '}';
    }
}
