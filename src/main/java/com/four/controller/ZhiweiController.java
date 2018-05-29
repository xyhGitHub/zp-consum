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
import com.four.model.User;
import com.four.model.Zhiwei;
import com.four.model.ZhiweiGreat;
import com.four.model.ZhiweiLittle;
import com.four.service.SolrService;
import com.four.service.ZhiweiService;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
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


    @Autowired
    private SolrService solrService;

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
    public void savezhiwei(Zhiwei zhiwei){

        zhiweiService.savezhiwei(zhiwei);

        //因此处表设计错误,无法新增索引,遂手动更新
//        solrService.addsolr();

    }

    @RequestMapping("quaryTouDilist")
    @ResponseBody
    public void quaryFollowlist(Integer comid) throws IOException, TemplateException {
        List<User> list=  zhiweiService.quaryTouDilist(comid);

        Configuration configuration = new Configuration();
        configuration.setDirectoryForTemplateLoading(new File("F:\\idea-workspace\\zp-consum\\src\\main\\webapp\\templates"));
        configuration.setDefaultEncoding("UTF-8");
        freemarker.template.Template template =configuration.getTemplate("HRZhiWei.ftl");
        template.setEncoding("UTF-8");
        Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("F:\\idea-workspace\\zp-consum\\src\\main\\webapp\\HRsmnZhiWei.html"), "UTF-8"));

        Map root=new  HashMap();
        root.put("list", list);

        template.process(root, out);
        out.flush();
        out.close();
    }


}