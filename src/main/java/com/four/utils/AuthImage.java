package com.four.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
  
public class AuthImage extends HttpServlet  {  
    static final long serialVersionUID = 1L;  
    
    //servlet的 doGet  doPost 等同于 service
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
       //设置头文件信息以及文本类型
    	response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        response.setContentType("image/jpeg");  
          
        //生成随机字串  
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);  
        //存入会话session  
        HttpSession session = request.getSession();  
        session.setAttribute("rand", verifyCode.toLowerCase());  
        //生成图片  
        int w = 100, h = 35;  
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);  
  
    }  
} 