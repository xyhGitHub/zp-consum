/** 
 * <pre>项目名称:four_group 
 * 文件名称:RoleController.java 
 * 包名:com.four.controller 
 * 创建日期:2018年3月12日下午8:27:28 
 * Copyright (c) 2018, 1103304339@qq.com All Rights Reserved.</pre> 
 */  
package com.four.controller;

import com.four.model.Role;
import com.four.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/** 
 * <pre>项目名称：four_group    
 * 类名称：RoleController    
 * 类描述：    
 * 创建人：苑鹏飞  1103304339@qq.com   
 * 创建时间：2018年3月12日 下午8:27:28    
 * 修改人：苑鹏飞  1103304339@qq.com      
 * 修改时间：2018年3月12日 下午8:27:28    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	
	/**
	 * <pre>updateRoleById(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月13日 下午3:36:48    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月13日 下午3:36:48    
	 * 修改备注： 根据ID修改
	 * @param response
	 * @param role</pre>
	 */
	@RequestMapping("updateRoleById")
	public void updateRoleById(HttpServletResponse response,Role role){
		
		roleService.updateRoleById(role);
		
	}
	
	
	/**
	 * <pre>toRoleById(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月13日 上午11:21:45    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月13日 上午11:21:45    
	 * 修改备注： 修改的回显
	 * @param model
	 * @param role
	 * @return</pre>
	 */
	@RequestMapping("toRoleById")
	public String toRoleById(Model model,Role role){
		Role e = roleService.toRoleById(role);
		model.addAttribute("role", e);
		return "updateRole";
	}
	/**
	 * <pre>toRoleTreeById(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月13日 下午3:37:07    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月13日 下午3:37:07    
	 * 修改备注： 分配权限前,去根据ID查询当前角色的权限
	 * @param
	 * @param
	 * @return</pre>
	 * 
	 */
	@RequestMapping("toRoleTreeById")
	public String toRoleTreeById(HttpServletRequest request,Integer roleId){
		request.setAttribute("roleId", roleId);
		  return "roleTree";
	}
	/**
	 * <pre>queryRole(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月12日 下午9:11:45    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月12日 下午9:11:45    
	 * 修改备注： 查询角色   -分页-条件
	 * @param role
	 * @param page
	 * @param rows
	 * @return</pre>
	 */
	@RequestMapping("queryRole")
	@ResponseBody
	public  Map<String,Object> queryRole(Role role,Integer  page,Integer  rows) {
		Map<String,Object> json = roleService.queryRole(role, rows, page);
		return json;
	}
	/**
	 * <pre>insertRole(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月12日 下午9:12:35    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月12日 下午9:12:35    
	 * 修改备注： 角色新增
	 * @param role
	 * @return</pre>
	 */
	@RequestMapping("insertRole")
	@ResponseBody
	public  Object insertRole(Role role) {
		int n = roleService.insertRole(role);
		return n;
	}
	/**
	 * <pre>insertRole(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月12日 下午10:12:49    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月12日 下午10:12:49    
	 * 修改备注： 删除角色
	 * @param
	 * @return</pre>
	 */
	@RequestMapping("deleteRoleByIds")
	@ResponseBody
	public Integer deleteRoleByIDs(String ids){
		return roleService.deleteRoleByIDs(ids);
	}
	/**
	 * <pre>toRoleAdd(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月12日 下午9:12:17    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月12日 下午9:12:17    
	 * 修改备注： 调到新增的页面
	 * @return</pre>
	 */
	@RequestMapping("toRoleAdd")
	public  String toRoleAdd() {
		return "roleAdd";
	}
	/**
	 * <pre>toRoleList(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月13日 上午11:20:34    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月13日 上午11:20:34    
	 * 修改备注： 跟树的URL对应，跳到查询页面，页面加载查询
	 * @return</pre>
	 */
	@RequestMapping("toRoleList")
	public  String toRoleList() {
		return "roleList";
	}
}
