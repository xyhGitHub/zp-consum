/** 
 * <pre>项目名称:Email 
 * 文件名称:Eml.java 
 * 包名:com.eml 
 * 创建日期:2018年3月16日下午7:41:36 
 * Copyright (c) 2018, 1103304339@qq.com All Rights Reserved.</pre> 
 */  
package com.four.utils;

import java.security.GeneralSecurityException;
/** 
 * <pre>项目名称：Email    
 * 类名称：Eml    
 * 类描述：    
 * 创建人：苑鹏飞  1103304339@qq.com   
 * 创建时间：2018年3月16日 下午7:41:36    
 * 修改人：苑鹏飞  1103304339@qq.com      
 * 修改时间：2018年3月16日 下午7:41:36    
 * 修改备注：       
 * @version </pre>    
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.sun.mail.util.MailSSLSocketFactory;

//import javax.activation.*;
 
public class SendEmail{
	
	public static void luquchenggong(String youxiang,String name) throws GeneralSecurityException{
		  // 收件人电子邮箱
        String to = youxiang;

        // 发件人电子邮箱
        String from = "1103304339@qq.com";

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
                return new PasswordAuthentication("1103304339@qq.com", "wztxnpnqbdkmgdce"); //发件人邮件用户名、密码
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
            message.setSubject("感谢您进入直聘网");

            // 设置消息体
            message.setText("尊敬的用户"+name+"您好,感谢您对本网的支持与鼓励,"
            		+ "现在我们公司已经录取了你,希望你能在24小时内来到本公司的人事部填写信息。");

            // 发送消息
            Transport.send(message);
            System.out.println("发送成功");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
	}
	public static void luqushibai(String youxiang,String name) throws GeneralSecurityException{
		// 收件人电子邮箱
		String to = youxiang;
		
		// 发件人电子邮箱
		String from = "1103304339@qq.com";
		
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
				return new PasswordAuthentication("1103304339@qq.com", "wztxnpnqbdkmgdce"); //发件人邮件用户名、密码
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
			message.setSubject("感谢您进入直聘网");
			
			// 设置消息体
			message.setText("尊敬的用户"+name+"您好,感谢您对本网的支持与鼓励,"
					+ "本网正式通知您,非常抱歉,您的审核未通过!!祝您好运！");
			
			// 发送消息
			Transport.send(message);
			System.out.println("发送成功");
		}catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
	public static void zhuCheChengGong(String youxiang,String name) throws GeneralSecurityException{
		  // 收件人电子邮箱
    String to = youxiang;

    // 发件人电子邮箱
    String from = "1103304339@qq.com";

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
            return new PasswordAuthentication("1103304339@qq.com", "wztxnpnqbdkmgdce"); //发件人邮件用户名、密码
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
        message.setSubject("感谢您进入直聘网");

        // 设置消息体
        message.setText("尊敬的用户"+name+"您好,现在您已成功在本网站注册,"
        		+ "您可以在本网站登录随意浏览,祝您能尽早找到一份理想的工作！！");

        // 发送消息
        Transport.send(message);
        System.out.println("成功");
    }catch (MessagingException mex) {
        mex.printStackTrace();
    }
	}
	
	
	public static void xiuGaiMiMa(String youxiang,String name,int yzm) throws GeneralSecurityException{
		  // 收件人电子邮箱
    String to = youxiang;

    // 发件人电子邮箱
    String from = "1103304339@qq.com";

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
            return new PasswordAuthentication("1103304339@qq.com", "wztxnpnqbdkmgdce"); //发件人邮件用户名、密码
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
        message.setSubject("感谢您进入直聘网");

        // 设置消息体
        message.setText("尊敬的用户:"+name+" 您好,您的验证码是,"
        		+yzm +"请保管好您的验证码。如非本人操作，请忽略该信息。");

        // 发送消息
        Transport.send(message);
        System.out.println("发送成功");
    }catch (MessagingException mex) {
        mex.printStackTrace();
    }
	}
	
}