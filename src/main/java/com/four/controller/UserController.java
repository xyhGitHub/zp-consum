/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UserController
 * Author:   Administrator
 * Date:     2018/5/10 11:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.four.controller;

import com.four.model.User;
import com.four.service.UserService;
import com.four.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2018/5/10
 * @since 1.0.0
 */
@Controller
@RequestMapping("userController")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("queryUserInfo")
    @ResponseBody
    public String  queryUserInfo(){
        List<User> list = userService.queryUserInfo();

        return JSONUtil.toJson(list);
    }


}
