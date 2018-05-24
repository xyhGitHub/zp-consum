/** 
0 * <pre>项目名称:four_group 
 * 文件名称:WGQController.java 
 * 包名:com.four.controller 
 * 创建日期:2018年3月14日下午4:00:08 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.four.controller;

import com.four.model.CompanyAndPost;
import com.four.service.WGQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/** 
 * <pre>项目名称：four_group    
 * 类名称：WGQController    
 * 类描述：    
 * 创建人：JavaScript 
 * 创建时间：2018年3月14日 下午4:00:08    
 * 修改人：JavaScript  
 * 修改时间：2018年3月14日 下午4:00:08    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("/WGQController")
public class WGQController {
	
	@Autowired
	private WGQService wgqService;
	
	@RequestMapping("/queryCompanyAndPost")
	@ResponseBody
	public Object queryCompanyAndPost(CompanyAndPost com,HttpServletRequest request){
		return wgqService.queryCompanyAndPost(com,request);
	}
	
	@RequestMapping("/getCompanyAll")
	@ResponseBody
	public Object getCompanyAll(){
		return wgqService.getCompanyAll();
	}
	
	@RequestMapping("/getPostAll")
	@ResponseBody
	public Object getPostAll(){
		return wgqService.getPostAll();
	}
	
	@RequestMapping("/UserPutResume")
	@ResponseBody
	public Object UserPutResume(String postid,HttpServletRequest request){
		return wgqService.UserPutResume(postid,request);
	}
	
	@RequestMapping("/queryCompanyAndPostByuserid")
	@ResponseBody
	public Object queryCompanyAndPostByuserid(Integer offset,Integer limit,HttpServletRequest request){
		return wgqService.queryCompanyAndPostByuserid(offset,limit,request);
	}
	
	@RequestMapping("/UpdateComPostResume")
	@ResponseBody
	public Object UpdateComPostResume(String postid,HttpServletRequest request){
		return wgqService.UpdateComPostResume(postid,request);
		
	}
}
