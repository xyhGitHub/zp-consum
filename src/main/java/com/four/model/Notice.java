package com.four.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/20.
 */
public class Notice implements Serializable {

    private static final long serialVersionUID = 7385722470199448171L;

    private Integer noticeId;
    private String noticeTitle;
    private String noticeContent;
    private String noticeType;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeContent=" + noticeContent +
                ", noticeType=" + noticeType +
                '}';
    }
}
