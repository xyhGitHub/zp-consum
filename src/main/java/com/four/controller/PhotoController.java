/** 
 * <pre>项目名称:four_group 
 * 文件名称:PhotoController.java 
 * 包名:com.four.controller 
 * 创建日期:2018年3月12日下午9:04:16 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.four.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.four.model.Photo;
import com.four.service.IPhotoService;

/** 
 * <pre>项目名称：four_group    
 * 类名称：PhotoController    
 * 类描述：    
 * 创建人：薛怡衡  
 * 创建时间：2018年3月12日 下午9:04:16    
 * 修改人：薛怡衡    
 * 修改时间：2018年3月12日 下午9:04:16    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("photoController")
public class PhotoController {
	
	@Autowired
	private IPhotoService photoService;
	
	@RequestMapping("queryPhotoList")
	@ResponseBody
	public String queryPhotoList(){
		
		String str = "";
		
		List<Photo> list;
		try {
			list = photoService.queryPhotoList();
			str = JSON.toJSONString(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return str;
	}
	
	@RequestMapping("queryPhotoLists")
	@ResponseBody
	public String queryPhotoLists(){
		
		String str = "";
		
		List<Photo> list;
		try {
			list = photoService.queryPhotoLists();
			str = JSON.toJSONString(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return str;
	}
	
	@RequestMapping("addPhotoJsp") 
	 public String addPhotoJsp(String photoStatus,HttpServletRequest request){
		 request.setAttribute("photoStatus", photoStatus);
		  return "addPhoto";
	 }
	
	@RequestMapping("addPhoto")
	@ResponseBody
	public String addPhoto(Photo photo){
		
		try {
			photoService.addPhoto(photo);
//			System.out.println(photo.getPhotoname());
			String replace = photo.getPhotoname().replace("\"", "");
			photo.setPhotoname(replace);
//			System.out.println(photo.getPhotoname());
//			System.out.println(photo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	
}
