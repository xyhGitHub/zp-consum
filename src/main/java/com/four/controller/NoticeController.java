package com.four.controller;

import com.alibaba.fastjson.JSON;
import com.four.model.Notice;
import com.four.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/20.
 */
@Controller
@RequestMapping("noticeController")
public class NoticeController {

    @Autowired
    private INoticeService noticeService;


    @RequestMapping("queryNoticeInfo")
    @ResponseBody
    public Map<String, Object> querynoticeInfo(int page, int rows, Notice notice){

        Map<String, Object> list = null;

        try {
            list = noticeService.queryNoticeInfo(page,rows,notice);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 加载下拉框
     * @return
     */
//    @RequestMapping("queryNoticeType")
//    @ResponseBody
//    public List<Notice> queryNoticeType(){
//
//        List<Notice> list = noticeService.queryNoticeType();
//        return list;
//    }


    /**
     * 跳转新增页面
     * @param
     */
    @RequestMapping("toAddNotice")
    public String toAddNotice(){
        return "xyh/addNotice";
    }

    /**
     * 新增
     * @param notice
     */
    @RequestMapping("addNotice")
    @ResponseBody
    public void addnotice(Notice notice){

        try {
            noticeService.addNotice(notice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("deleteSome")
    @ResponseBody
    public void deleteSome(String idList ){

        try {
            noticeService.deleteSome(idList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 跳转修改页面
     * @param noticeId
     * @param
     * @return
     */
    @RequestMapping("toUpdateNoticeJsp")
    public String toUpdateNoticeJsp(String noticeId,HttpServletRequest req) {

        req.getSession().setAttribute("noticeId",noticeId);

        return "xyh/updateNotice";
    }

    // 修改回显
    @RequestMapping("queryNoticeById")
    @ResponseBody
    public String queryNoticeById(String noticeId, HttpServletRequest request) {
        String notices = "";
        try {
            Notice notice = noticeService.queryNoticeById(noticeId);

            notices = JSON.toJSONString(notice);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return notices;
    }

    // 修改保存
    @RequestMapping("updateNoticeById")
    @ResponseBody
    public void updateNoticeById(Notice notice) {
        try {
            noticeService.updateNoticeById(notice);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
