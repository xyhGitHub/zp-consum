/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ZhiweiController
 * Author:   Administrator
 * Date:     2018/5/21 11:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.four.controller;

import com.alibaba.fastjson.JSONObject;
import com.four.model.Zhiwei;
import com.four.model.ZhiweiGreat;
import com.four.model.ZhiweiLittle;
import com.four.service.ZhiweiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2018/5/21
 * @since 1.0.0
 */
@Controller
@RequestMapping("zhiweiController")
public class ZhiweiController {

    @Autowired
    private ZhiweiService zhiweiService;

    @RequestMapping("querygreatzw")
    @ResponseBody
    public Map<String ,Object>  querygreatzw(ZhiweiGreat zhiweiGreat){
        List<ZhiweiGreat> list =new ArrayList<ZhiweiGreat>();

        Map<String,Object> map =new HashMap<String,Object>();
        try {
            list=zhiweiService.querygreatzw();
            map.put("rows",list);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }
    @RequestMapping("querylittlezw")
    @ResponseBody
    public Map<String ,Object>  querylittlezw(ZhiweiGreat zhiweiGreat){
        List<ZhiweiLittle> list =new ArrayList<ZhiweiLittle>();

        Map<String,Object> map =new HashMap<String,Object>();
        try {
            list=zhiweiService.querylittlezw();
            map.put("rows",list);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("querycomtree")
    @ResponseBody
    public  List<ZhiweiGreat> querycomtree( ){
        JSONObject obj= new JSONObject();

        List<ZhiweiGreat> greatlist =zhiweiService.querygreatzw();

        obj.put("greatlist", greatlist.get(0)  );

        return greatlist;
    }

    @RequestMapping("querylittletree")
    @ResponseBody
    public  List<ZhiweiLittle> querylittletree( ){
        JSONObject obj= new JSONObject();
        List<ZhiweiLittle> littlelist =zhiweiService.querylittlezw();
        obj.put("littlelist", littlelist.get(0)  );
        return littlelist;
    }

    @RequestMapping("queryzhiweishow")
    @ResponseBody
    public  Map<String , Object > queryzhiweishow(){
        List<Zhiwei> list =new ArrayList<Zhiwei>();
        Map<String ,Object> map =new HashMap<String,  Object>();
        list=zhiweiService.queryzhiweishow();
        map.put("rows",list);
        return  map ;

    }

    @RequestMapping("queryzhiweishowlist")
    @ResponseBody
    public  List<Zhiwei> ddd(){

        List<Zhiwei> list =zhiweiService.queryzhiweishowlist();

        return  list;
    }





    @RequestMapping("savezhiwei")
    public String savezhiwei(Zhiwei zhiwei){

        zhiweiService.savezhiwei(zhiwei);

        return  "myhome";
    }




}