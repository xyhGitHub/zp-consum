package com.four.service;

import com.four.model.User;

import java.util.List;

/**
 * Created by Administrator on 2018/5/10.
 */
public interface UserService {
    List<User> queryUserInfo();

 /*   JSONObject userlist(@Param("page")int page, @Param("rows")int rows, @Param("user")User user)throws Exception;*/

}
