/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: BossController
 * Author:   Administrator
 * Date:     2018/5/18 20:08
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.four.controller;

import com.four.model.GongSi;
import com.four.model.GongSiBoos;
import com.four.service.BosssService;
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
@RequestMapping("bossController")
public class BosssController {

    @Autowired
    private BosssService bosssService;

    @RequestMapping("querybooss")
    @ResponseBody
    public Map<String,Object> query(GongSiBoos boss, Integer offset, Integer limit){

        List<GongSiBoos> list =new ArrayList<GongSiBoos>();

        Map<String,Object> map =new HashMap<String,Object>();
        try {
            list=bosssService.queryboss(boss,offset,limit);
            long count = bosssService.queryCount(boss);
            map.put("total", count);
            map.put("rows",list);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping("delboss")
    @ResponseBody
    public String delboss(Integer id){//单删
        bosssService.delboss(id);
        return "success";
    }
    @RequestMapping("updatatongguo")
    @ResponseBody
    public  void updatatongguo(){
        GongSi gongsi = new GongSi();
        gongsi.setComshenhe(2);
        bosssService.saveShenhe(gongsi);
    }
}
