/** 
 * <pre>项目名称:four_group 
 * 文件名称:DeptController.java 
 * 包名:com.four.controller 
 * 创建日期:2018年3月13日下午7:20:53 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.four.controller;

import com.alibaba.fastjson.JSON;
import com.four.model.Dept;
import com.four.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/** 
 * <pre>项目名称：four_group    
 * 类名称：DeptController    
 * 类描述：    
 * 创建人：薛怡衡  
 * 创建时间：2018年3月13日 下午7:20:53    
 * 修改人：薛怡衡    
 * 修改时间：2018年3月13日 下午7:20:53    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("deptController")
public class DeptController {
	
	@Autowired
	private IDeptService deptService;

	/**
	 * <pre>queryDeptInfo(分页和条件查询)   
	 * 创建人：薛怡衡
	 * 创建时间：2018年3月13日 下午8:06:52    
	 * 修改人:薛怡衡      
	 * 修改时间：2018年3月13日 下午8:06:52    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @param dept
	 * @return</pre>
	 */
	@RequestMapping("queryDeptInfo")
	@ResponseBody
	public Map<String, Object> queryDeptInfo(int page,int rows,Dept dept){
		
		Map<String, Object> list = null;
		
		try {
			list = deptService.queryDeptInfo(page,rows,dept);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * <pre>toAddDept(跳转到新增员工页面)   
	 * 创建人：薛怡衡
	 * 创建时间：2018年3月13日 下午8:06:36    
	 * 修改人:薛怡衡      
	 * 修改时间：2018年3月13日 下午8:06:36    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("toAddDept")
	  public String toAddDept(){
 	   return "addDept";
	  }
	
	/**
	 * <pre>toDeptNum(跳转员工信息)   
	 * 创建人：薛怡衡
	 * 创建时间：2018年3月16日 上午10:24:46    
	 * 修改人:薛怡衡      
	 * 修改时间：2018年3月16日 上午10:24:46    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("toDeptNum")
	public String toDeptNum(Integer deptid,HttpServletRequest req){
		
		req.getSession().setAttribute("deptid", deptid);
		return "deptNum";
	}
	
	/**
	 * <pre>addDept(新增部门)   
	 * 创建人：薛怡衡
	 * 创建时间：2018年3月13日 下午8:10:25    
	 * 修改人:薛怡衡      
	 * 修改时间：2018年3月13日 下午8:10:25    
	 * 修改备注： 
	 * @param dept
	 * @return</pre>
	 */
	@RequestMapping("addDept")
	@ResponseBody
	public String addDept(Dept dept){
		
		String aa = "";
		
		try {
			int a = deptService.addDept(dept);
			 aa = JSON.toJSONString(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aa;
	}
	
	/**
	 * <pre>deleteSome(批量删除部门信息)   
	 * 创建人：薛怡衡
	 * 创建时间：2018年3月13日 下午8:20:43    
	 * 修改人:薛怡衡      
	 * 修改时间：2018年3月13日 下午8:20:43    
	 * 修改备注： 
	 * @param idList
	 * @return</pre>
	 */
	@RequestMapping("deleteSome")
	@ResponseBody
	public String deleteSome(String idList ){
		
		String aa = "";
		
		try {
			int a = deptService.deleteSome(idList);
			 aa = JSON.toJSONString(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return aa;
	}
	
	/**
	 * <pre>queryDeptName(加载下拉框)   
	 * 创建人：薛怡衡
	 * 创建时间：2018年3月14日 上午10:26:25    
	 * 修改人:薛怡衡      
	 * 修改时间：2018年3月14日 上午10:26:25    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("queryDeptName")
	@ResponseBody
	public String queryDeptName(){
		
		String str = "";
		
		List<Dept> deptList = deptService.queryDeptName();
		
		str = JSON.toJSONString(deptList);
		
		return str;
		
	}
	
	/**
	 * <pre>queryDeptNum(查询各部门信息)   
	 * 创建人：薛怡衡
	 * 创建时间：2018年3月16日 上午10:25:58    
	 * 修改人:薛怡衡      
	 * 修改时间：2018年3月16日 上午10:25:58    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("queryDeptNum")
	@ResponseBody
	public List  queryDeptNum(Integer deptid){
		
		List deptList = deptService.queryDeptNum(deptid);
		
		return deptList;
		
	}
		  
}
