/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: User
 * Author:   Administrator
 * Date:     2018/5/7 11:28
 * Description: User
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.four.model;

import java.io.Serializable;

/**
 * 〈一句话功能简述〉<br> 
 * 〈User〉
 *
 * @author Administrator
 * @create 2018/5/7
 * @since 1.0.0
 */
public class Users implements Serializable {

    private static final long serialVersionUID = 922773424889959836L;
    private  Integer  id;
    private  String   name;
    private  Integer   age ;

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
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
