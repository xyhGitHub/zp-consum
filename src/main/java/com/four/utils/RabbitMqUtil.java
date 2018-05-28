package com.four.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMqUtil {
	
	public static Connection getConnection() throws IOException, TimeoutException{
		
		//定义连接工厂
		 ConnectionFactory factory = new ConnectionFactory();
		//设置服务地址
		 factory.setHost("127.0.0.1");
		//设置端口号
		 factory.setPort(5672);
		//设置账号信息,账号,密码,vhost
		 factory.setVirtualHost("/1710xyh");
		 factory.setUsername("xyh");
		 factory.setPassword("xyh");
		 //通过工程获取连接
		 Connection Connection = factory.newConnection();
		
		return Connection;
		
	}
}
