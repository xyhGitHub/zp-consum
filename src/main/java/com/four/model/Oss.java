package com.four.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/17.
 */
public class Oss implements Serializable {

    private static final long serialVersionUID = -636806058155793751L;
    private Integer id;
    private String photo;

    @Override
    public String toString() {
        return "Oss{" +
                "id=" + id +
                ", photo='" + photo + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
