/** 
 * <pre>项目名称:four_group 
 * 文件名称:TongJiController.java 
 * 包名:com.four.controller 
 * 创建日期:2018年3月16日上午9:50:51 
 * Copyright (c) 2018, 1103304339@qq.com All Rights Reserved.</pre> 
 */  
package com.four.controller;

import com.alibaba.fastjson.JSONObject;
import com.four.model.JiuYe;
import com.four.service.JiuYeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
 * <pre>项目名称：four_group    
 * 类名称：TongJiController    
 * 类描述：    
 * 创建人：苑鹏飞  1103304339@qq.com   
 * 创建时间：2018年3月16日 上午9:50:51    
 * 修改人：苑鹏飞  1103304339@qq.com      
 * 修改时间：2018年3月16日 上午9:50:51    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("JiuYe")
public class JiuYeController {
	@Autowired
	private JiuYeService tongJiService;
	
	/**
	 * <pre>toTonngJi(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月16日 上午9:55:30    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月16日 上午9:55:30    
	 * 修改备注： 跳到统计页面
	 * @return</pre>
	 */
	@RequestMapping("toJiuYe")
	public  String toJiuYe() {
		return "jiuYeiLvList";
	}
	/**
	 * <pre>queryTongJi(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月16日 上午10:00:43    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月16日 上午10:00:43    
	 * 修改备注： 查询统计人数
	 * @param
	 * @param page
	 * @param rows
	 * @return</pre>
	 */
	@RequestMapping("queryTongJi")
	@ResponseBody
	public  Object queryTongJi(JiuYe tongji,Integer  page,Integer  rows) {
		JSONObject json = tongJiService.queryTongJi(tongji, rows, page);
		return json;
	}
	@RequestMapping("insertJiuYe")
	@ResponseBody
	public  void insertJiuYe() {
		tongJiService.insertJiuYe();
	}
}
