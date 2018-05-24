package com.four.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.four.model.Company;
import com.four.model.Post;
import com.four.model.User;
import com.four.service.PostService;


@Controller
@RequestMapping("Post")
public class PostController {
	@Autowired
	private PostService PostService;
	
	@RequestMapping("queryPost")
	@ResponseBody
	public  Object queryPost(Post Post,Integer  page,Integer  rows) {
		JSONObject json = PostService.queryPost(Post, rows, page);
		return json;
	}
	//新增
	@RequestMapping("insertPost")
	@ResponseBody
	public  Object insertPost(Post Post) {
		int n = PostService.insertPost(Post);
		return n;
	}
	@RequestMapping("querycompanys")
	@ResponseBody
	public  List<Company> querycompanys() {
		List<Company> list = PostService.querycompanys();
		return list;
	}
	
	//删除
	@RequestMapping("deletePostByIds")
	@ResponseBody
	public Integer deletePostByIDs(String ids){
		return PostService.deletePostByIDs(ids);
	}
	@RequestMapping("toPostAdd")
	public  String toPostAdd() {
		return "PostAdd";
	}
	@RequestMapping("toPostList")
	public  String toPostList() {
		return "postList";
	}
	
	
	
	
	
	@RequestMapping("toqueryusers")
	public  String query(int postid,HttpServletRequest request) {
		request.setAttribute("postid", postid);
		
		return "postuserlist";
	}
	@RequestMapping("queryusers")
	@ResponseBody
	public  List<User> queryusers(int postid) {
		List<User> list = PostService.queryusers(postid);

		return list;
		
	}
	/*public  Object queryRole(Role role,Integer  page,Integer  rows) {
		JSONObject json = roleService.queryRole(role, rows, page);
		return json;
	}*/
	
}
