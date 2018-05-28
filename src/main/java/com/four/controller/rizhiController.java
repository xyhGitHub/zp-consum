/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: rizhiController
 * Author:   Administrator
 * Date:     2018/5/25 14:00
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.four.controller;

import com.four.model.Logs;
import com.four.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2018/5/25
 * @since 1.0.0
 */
@Controller
@RequestMapping("logs")
public class rizhiController {

    @Autowired
    private LogService logService;

    //报表
        @RequestMapping("/smnbaobiao")
        @ResponseBody
        public List  selecttongji() {
            List list = logService.selecttongji();

            return list;
        }


    //查询
    @RequestMapping("querylogs")
    @ResponseBody
    public Map<String,Object> queryBookList(Integer page,Integer rows){

        Map<String,Object> map = new HashMap<String, Object>();

        List<Logs> list=logService.querylogs();
        map.put("rows", list);

        return map;
    }

//        @RequestMapping("toRiZhiList")
//        public  String toRiZhiList() {
//            return "showRiZhi";
//        }
//
//        @Autowired
//        private MongoTemplate mongoTemplate;
//        //查询
//        @RequestMapping("queryRiZhi")
//        @ResponseBody
////
//        public Map<String,Object> queryBookList(Integer page,Integer rows){
//
//            Map<String,Object> map = new HashMap<String, Object>();
//
//            Query query = new Query();
//            query.skip(page).limit(rows);
//            List<Logs> list = mongoTemplate.find(query, Logs.class,"logs");
//            long count = mongoTemplate.count(query,Logs.class,"logs");
//
//            map.put("total", count);
//            map.put("rows", list);
//
//            return map;
//        }

}
