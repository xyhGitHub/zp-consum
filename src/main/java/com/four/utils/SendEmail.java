/** 
 * <pre>项目名称:Email 
 * 文件名称:Eml.java 
 * 包名:com.eml 
 * 创建日期:2018年3月16日下午7:41:36 
 * Copyright (c) 2018, 839174810@qq.com All Rights Reserved.</pre> 
 */  
package com.four.utils;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

//import javax.activation.*;
 
public class SendEmail{
	
	//注册成功邮件
    public static void zhuCheChengGong(String youxiang,String name) throws GeneralSecurityException{
		  // 收件人电子邮箱
    String to = youxiang;

    // 发件人电子邮箱
    String from = "839174810@qq.com";

    // 指定发送邮件的主机为 smtp.qq.com
    String host = "smtp.qq.com";  //QQ 邮件服务器

    // 获取系统属性
    Properties properties = System.getProperties();

    // 设置邮件服务器
    properties.setProperty("mail.smtp.host", host);

    properties.put("mail.smtp.auth", "true");
    MailSSLSocketFactory sf = new MailSSLSocketFactory();
    sf.setTrustAllHosts(true);
    properties.put("mail.smtp.ssl.enable", "true");
    properties.put("mail.smtp.ssl.socketFactory", sf);
    // 获取默认session对象
    Session session = Session.getDefaultInstance(properties,new Authenticator(){
        public PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication("839174810@qq.com", "wztxnpnqbdkmgdce"); //发件人邮件用户名、密码
        }
    });

    try{
        // 创建默认的 MimeMessage 对象
        MimeMessage message = new MimeMessage(session);

        // Set From: 头部头字段
        message.setFrom(new InternetAddress(from));

        // Set To: 头部头字段
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        // Set Subject: 头部头字段
        message.setSubject("感谢您注册拉勾网");

        // 设置消息体
        message.setText("尊敬的用户"+name+"您好,现在您已成功在本网站注册,"
        		+ "您可以在本网站登录随意浏览,祝您能尽早找到一份理想的工作！！");

        // 发送消息
        Transport.send(message);
        System.out.println("注册邮件发送成功");
    }catch (MessagingException mex) {
        mex.printStackTrace();
    }
	}
	
	
	
	//获取邮箱验证码
	public static void getCheckCode(String youxiang,String name,int yzm) throws GeneralSecurityException{
		  // 收件人电子邮箱
    String to = youxiang;

    // 发件人电子邮箱
    String from = "839174810@qq.com";

    // 指定发送邮件的主机为 smtp.qq.com
    String host = "smtp.qq.com";  //QQ 邮件服务器

    // 获取系统属性
    Properties properties = System.getProperties();

    // 设置邮件服务器
    properties.setProperty("mail.smtp.host", host);

    properties.put("mail.smtp.auth", "true");
    MailSSLSocketFactory sf = new MailSSLSocketFactory();
    sf.setTrustAllHosts(true);
    properties.put("mail.smtp.ssl.enable", "true");
    properties.put("mail.smtp.ssl.socketFactory", sf);
    // 获取默认session对象
    Session session = Session.getDefaultInstance(properties,new Authenticator(){
        public PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication("839174810@qq.com", "wztxnpnqbdkmgdce"); //发件人邮件用户名、密码
        }
    });

    try{
        // 创建默认的 MimeMessage 对象
        MimeMessage message = new MimeMessage(session);

        // Set From: 头部头字段
        message.setFrom(new InternetAddress(from));

        // Set To: 头部头字段
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        // Set Subject: 头部头字段
        message.setSubject("感谢您进入拉勾网");
        String checkCode = VerifyCodeUtils.generateVerifyCode(4);
        System.out.println(checkCode);
        // 设置消息体
        message.setText("尊敬的用户:"+name+" 您好,您的验证码是,"
        		+checkCode +"请保管好您的验证码。如非本人操作，请忽略该信息。");

        // 发送消息
        Transport.send(message);
        System.out.println("获取验证码成功");
    }catch (MessagingException mex) {
        mex.printStackTrace();
    }
	}
	
}