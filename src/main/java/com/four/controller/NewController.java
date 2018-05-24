/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: NewController
 * Author:   Administrator
 * Date:     2018/5/18 21:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.four.controller;

import com.four.model.NewTree;
import com.four.service.NewService;
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
 * @create 2018/5/18
 * @since 1.0.0
 */
@Controller
@RequestMapping("/newController")
public class NewController {

    @Autowired
    private NewService newService;

    @RequestMapping("querynews")
    @ResponseBody
    public Map<String ,Object> querynews(NewTree newTree, Integer offset, Integer limit){
        List<NewTree> list=new ArrayList<NewTree>();
        Map<String,Object> map =new HashMap<String,Object>();
        list=  newService.querynews(newTree,offset,limit);
        System.out.println(list);
        Long count =newService.quentCount(newTree);
        map.put("total",count);
        map.put("rows",list);
        return  map;
    }

    @RequestMapping("delnews")
    public  void delnews(Integer id){

        newService.delnews(id);

    }


}
