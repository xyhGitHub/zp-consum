package com.four.service;

import com.four.model.Notice;

import java.util.Map;

/**
 * Created by Administrator on 2018/5/20.
 */
public interface INoticeService {
    Map<String,Object> queryNoticeInfo(int page, int rows, Notice notice);

    void addNotice(Notice notice);

    int deleteSome(String idList);

    Notice queryNoticeById(String noticeId);

    void updateNoticeById(Notice notice);

//    List<Notice> queryNoticeType();
}
