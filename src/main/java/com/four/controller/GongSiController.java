/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: LoginController
 * Author:   Administrator
 * Date:     2018/5/14 19:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.four.controller;

import com.four.model.GongSi;
import com.four.model.GongSiBoos;
import com.four.model.LoginUser;
import com.four.service.GongsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2018/5/14
 * @since 1.0.0
 */
@Controller
@RequestMapping("gongsiController")
public class GongSiController {

        @Autowired
        private GongsiService gongsiService;

        @RequestMapping("gongsilist")
        @ResponseBody
        public GongSi selectgongshilist(HttpServletRequest request){

            LoginUser laGouUsers = (LoginUser) request.getSession().getAttribute("laGouComSession");
            GongSi gongSi = gongsiService.selectgongsi(Integer.valueOf(laGouUsers.getComid()));
         if (gongSi.getComshenhe() ==1 )  {
             gongSi.setComshenhename("没通过审核");

         }else {
             gongSi.setComshenhename("通过审核");
         }
           request.getSession().setAttribute("gongSi",gongSi);


            return gongSi;
        }

    @RequestMapping("selectBossById")
    @ResponseBody
    public GongSiBoos selectBossById(HttpServletRequest request){

        LoginUser laGouUsers = (LoginUser) request.getSession().getAttribute("laGouComSession");
        GongSiBoos gongSiBoos  = gongsiService.selectBossById(Integer.valueOf(laGouUsers.getComid()));
        request.getSession().setAttribute("boss",gongSiBoos);

        return gongSiBoos;
    }

    @RequestMapping("gongsilistu")
    @ResponseBody
    public Map<String,Object> query(GongSi gongsi,Integer offset,Integer limit){

        List<GongSi> list =new ArrayList<GongSi>();

        Map<String,Object> map =new HashMap<String,Object>();
        try {
            list=gongsiService.querygongsi(gongsi,offset,limit);
            long count = gongsiService.queryCount(gongsi);
            map.put("total", count);
            map.put("rows",list);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return map;
    }


    @RequestMapping("delgongsi")
    @ResponseBody
    public String delgongsi(Integer comid){//单删
        gongsiService.delgongsi(comid);

        return "success";
    }

    @RequestMapping("selectall")
    public String toupdate(Integer comid,HttpServletRequest request){
        request.setAttribute("comid", comid);
        return "bossshow";
    }
    @RequestMapping("queryall")
    public Map<String,Object> queryall(Integer id){

        List<GongSiBoos> list =gongsiService.queryall(id);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("rows",list);
        return map;

    }

    @RequestMapping("updatatongguo")
    public  String updatatongguo(Integer id){

        gongsiService.updatatongguo(id);

        return "2";
    }

    /**
     * 修改公司页面的name
     * @param gongSi
     * @param comid
     * @return
     */
    @RequestMapping("editgongshiname")
    public String editgongshiname(GongSi gongSi,Integer comid){

        gongsiService.editgongshiname(gongSi);

        return  "gongsi";
    }


    @RequestMapping("gongsieditphoto")
    @ResponseBody
    public String  gongsieditphoto(Integer comid,String photo){

        gongsiService.gongsieditphoto(comid,photo);
        return "1";
    }


    @RequestMapping("querysshowbyidzhiwei")
    @ResponseBody
    public List<GongSi> querysshowbyidzhiwei(){

        List<GongSi> list =gongsiService.querysshowbyidzhiwei();

        return list;
    }


    @RequestMapping("savebiaoqian")
    @ResponseBody
    public  String   savebiaoqian(GongSi gongSi){

        gongsiService.savebiaoqian(gongSi);


        return  "myhome";
    }




}
