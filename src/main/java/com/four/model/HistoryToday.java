package com.four.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/27.
 */
public class HistoryToday implements Serializable{
    private static final long serialVersionUID = -162022337210963704L;

    private String title;
    private String pic;
    private String des;
    private String lunar;

    @Override
    public String toString() {
        return "HistoryToday{" +
                "title='" + title + '\'' +
                ", pic='" + pic + '\'' +
                ", des='" + des + '\'' +
                ", lunar='" + lunar + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getLunar() {
        return lunar;
    }

    public void setLunar(String lunar) {
        this.lunar = lunar;
    }
}
