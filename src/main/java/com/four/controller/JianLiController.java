package com.four.controller;

import com.four.model.JianLi;
import com.four.service.JianLiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/JianLiController")
public class JianLiController {

    @Autowired
    private JianLiService jianLiService;

    @RequestMapping("addJianLi")
    public void addJianLI(JianLi jianLi){

        jianLi.setJid(1);
        if(jianLi.getQiwangchengshi()!=""){
            jianLiService.addJianLi1(jianLi);
        }
        if(jianLi.getXiangmumingcheng()!=""){
            jianLiService.addJianLi3(jianLi);
        }
        if(jianLi.getXuexiaomingcheng()!=""){
            jianLiService.addJianLi4(jianLi);
        }
        if(jianLi.getZiwojieshao()!=""){
            jianLiService.addJianLi5(jianLi);
        }
        if(jianLi.getZuopinshuoming()!=""){
            jianLiService.addJianLi6(jianLi);
        }
        if(jianLi.getGongzuogongsimingcheng()!=""){
            jianLiService.addJianLi2(jianLi);
        }

    }

    @RequestMapping("delnews")
    public  void delnews(Integer id){



    }
}

