/** 
 * <pre>项目名称:single_code 
 * 文件名称:UserController.java 
 * 包名:com.lws.controller 
 * 创建日期:2018年3月7日下午10:58:23 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */
package com.four.controller;

import com.alibaba.fastjson.JSONObject;
import com.four.model.Role;
import com.four.model.User;
import com.four.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

;
/**
 * <pre>
 * 项目名称：single_code    
 * 类名称：UserController    
 * 类描述：    
 * 创建人：刘文圣  
 * 创建时间：2018年3月7日 下午10:58:23    
 * 修改人：刘文圣
 * 修改时间：2018年3月7日 下午10:58:23    
 * 修改备注：       
 * &#64;version
 * </pre>
 */
@Controller
@RequestMapping("/userController")
public class UserController {

	@Autowired
	private IUserService userService;


	// 查询+分页+条件查询
	@RequestMapping("/queryUserList")
	@ResponseBody
	public JSONObject queryUserList(int page, int rows, User user) {
		JSONObject jobj = null;
		try {
			jobj = userService.queryUserList(page, rows, user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jobj;
	}

	// 删除
	@RequestMapping("/deleteUserByIds")
	@ResponseBody
	public String deleteUserByIds(String str) {
		try {
			userService.deleteUserByIds(str);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "delSuccess";
	}

	// 修改回显
	@RequestMapping("/queryUserById")
	public String queryUserById(String id, HttpServletRequest request) {
		try {

			User user = userService.queryUserById(id);

			request.setAttribute("user", user);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "updateUser";
	}

	// 修改保存
	@RequestMapping("/updateUserById")
	@ResponseBody
	public String updateUserById(User user) {
		try {
			
			userService.updateUserById(user);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "addUserSuccess";
	}

	// 增加
	@RequestMapping("/addUserData")
	@ResponseBody
	public String addUser(User user) {
		try {
			user.setCompanyid(3);
			user.setUserphone("456456");
			
			userService.addUserData(user);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "addUserSuccess";
	}

	// 跳转添加页面
	@RequestMapping("/toAddUser")
	public String toAddUser() {

		return "addUser";
	}

	/**
	 * 
	 * <pre>
	 * queryRoleByUserid(通过用户ID查询该用户的所有)   
	 * 创建人：JavaScript  
	 * 创建时间：2018年3月13日 下午7:20:03    
	 * 修改人：JavaScript 
	 * 修改时间：2018年3月13日 下午7:20:03    
	 * 修改备注： 
	 * &#64;param id
	 * &#64;return
	 * </pre>
	 */
	@RequestMapping("/queryRoleByUserid")
	public Object queryRoleByUserid(Integer id, Model m) {
		List<User> list = new ArrayList<User>();
		try {
			list = userService.queryRoleByUserid(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (list.size() == 0) {
			User u = new User();
			u.setUserid(id);
			list.add(u);
		}
		m.addAttribute("k", list.get(0));
		return "roleShow";
	}

	@RequestMapping("/getRoleAll")
	@ResponseBody
	public Object getRoleAll() {
		List<Role> list = new ArrayList<Role>();
		try {
			list = userService.getRoleAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	// saveRolesByUserId

	@RequestMapping("/saveRolesByUserId")
	@ResponseBody
	public Object saveRolesByUserId(Integer userId, String roleId) {

		try {
			userService.saveRolesByUserId(userId, roleId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "success";
	}

	@RequestMapping("/queryUserResumeList")
	public Object queryUserResumeList(Integer typeidcriteria,HttpServletRequest request) {
		
		User user=null;
		try {
			user = userService.queryUserResumeList(typeidcriteria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("user", user);
//		str = JSON.toJSONString(deptList);
		
		return "showResume";
	}
	
	
	@RequestMapping("/lookCompany")
	@ResponseBody
	public Object lookCompany(Integer userid) {
		User u = new User();
		u.setUserid(userid);
		try {
		 u = userService.lookCompany(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		str = JSON.toJSONString(deptList);
		
		return u;
	}
	@RequestMapping("/querySeclect")
	@ResponseBody
	public Object querySeclect() {
		List<User> list = new ArrayList<User>();
		try {
			list = userService.querySeclect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		str = JSON.toJSONString(deptList);
		
		return list;
	}
	@RequestMapping("/queryTypeListSelect")
	@ResponseBody
	public Object queryTypeListSelect() {
		List<User> list = new ArrayList<User>();
		try {
			list = userService.queryTypeListSelect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
