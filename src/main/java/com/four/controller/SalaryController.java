package com.four.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.four.model.Salary;
import com.four.model.User;
import com.four.service.ISalaryService;

@Controller
@RequestMapping("salaryController")
public class SalaryController {

	@Autowired
	private ISalaryService salaryservice;
	
	/**
	 * <pre>treelist(薪资查询有分页)   
	 * 创建人：孙梦娜  
	 * 创建时间：2018年3月13日 下午7:45:39    
	 * 修改人:孙梦娜        
	 * 修改时间：2018年3月13日 下午7:45:39    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @param salary
	 * @return</pre>
	 */
	@RequestMapping("salarylist")
	@ResponseBody
	public JSONObject salarylist(int page,int rows,Salary salary){
		JSONObject salarylist= null;
		try {
			salarylist=salaryservice.salarylist(page,rows,salary);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
			return salarylist;
		}

	
	@RequestMapping("toSalary")
	public String  toSalary(){
		
		return "addsalary";
	}
	
	@RequestMapping("addsalary")
	@ResponseBody
	public String addsalary(Salary salary){
		String  str="";
		
		try {
		int	a = salaryservice.addsalary(salary);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "str";
	}
	
	
	@RequestMapping("deleteSalary")
	@ResponseBody
	public String deleteSalary(String salaryid ){
		
		try {
			salaryservice.deleteByPrimaryKey(salaryid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "success";
	}
	
	@RequestMapping("toUpdateSalary")
	public String toUpdateSalary(String salaryid ,HttpServletRequest servletRequest){
		
		Salary salary;
		try {
			salary = salaryservice.selectByPrimaryKey(salaryid);
			servletRequest.setAttribute("salary", salary);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "uapateSalary";
	}
	@RequestMapping("updateSalary")
	@ResponseBody
	public String updateSalary(Salary salary){
		salaryservice.updateByPrimaryKey(salary);
		
		return "success";
	}
	/**
	 * <pre>selectuser(超过多少钱的人的信息)   
	 * 创建人：孙梦娜  
	 * 创建时间：2018年3月16日 上午11:37:59    
	 * 修改人:孙梦娜        
	 * 修改时间：2018年3月16日 上午11:37:59    
	 * 修改备注： 
	 * @param userid
	 * @return</pre>
	 */
	@RequestMapping("selectuser")
	@ResponseBody
	public List<User> selectuser(Integer  salarysum,Integer salarysum2){
		
		List<User> usetlistsum=salaryservice.selectuser(salarysum,salarysum2);
		
		
		return usetlistsum;
	}
	@RequestMapping("toselectuser")
	public String  selectuser(Integer salarysum,Integer maxSalary,HttpServletRequest request){
		
		request.setAttribute("salarysum", salarysum);
		request.setAttribute("salarysum2", maxSalary);
		
		return "selectUuserSum";
	}
	
}

