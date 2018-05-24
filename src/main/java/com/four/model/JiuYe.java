package com.four.model;

import java.util.Date;

public class JiuYe {
    private Integer tjid;

    private Integer qiuzhicount;

    private Integer rizhicount;

    private Double jiuyelv;

    private Date starttime;

    private Date endtime;

    public Integer getTjid() {
        return tjid;
    }

    public void setTjid(Integer tjid) {
        this.tjid = tjid;
    }

    public Integer getQiuzhicount() {
        return qiuzhicount;
    }

    public void setQiuzhicount(Integer qiuzhicount) {
        this.qiuzhicount = qiuzhicount;
    }

    public Integer getRizhicount() {
        return rizhicount;
    }

    public void setRizhicount(Integer rizhicount) {
        this.rizhicount = rizhicount;
    }

    public Double getJiuyelv() {
        return jiuyelv;
    }

    public void setJiuyelv(Double jiuyelv) {
        this.jiuyelv = jiuyelv;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}