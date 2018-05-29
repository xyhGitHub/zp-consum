package com.four.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/22.
 */
public class TongJi implements Serializable {

    private static final long serialVersionUID = 6772603962573605099L;

//    @Transient
    private Integer nums;

//    @Transient
    private String names;

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "TongJi{" +
                "nums=" + nums +
                ", names='" + names + '\'' +
                '}';
    }
}
