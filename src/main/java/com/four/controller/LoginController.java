/**
 * <pre>项目名称:four_group
 * 文件名称:LoginController.java
 * 包名:com.four.controller
 * 创建日期:2018年3月13日下午1:10:52
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre>
 */
package com.four.controller;

import com.four.model.LoginGs;
import com.four.model.LoginUser;
import com.four.model.TongJi;
import com.four.model.User;
import com.four.service.ILoginService;
import com.four.utils.HistoryTodayUtil;
import com.four.utils.util.sendsms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("loginController")
public class LoginController {

	@Autowired
	private ILoginService loginService;


	/**
	 * 前台注册用户和公司帐号
	 * @param laGouUser
	 * @return
	 */

	int mobile_code =123;
	@RequestMapping("setPhone")
	public void setPhone(String phone){

		mobile_code= sendsms.mobile(phone);
	}

	@RequestMapping("laGouReg")
	@ResponseBody
	public Integer laGouReg(LoginUser laGouUser) throws Exception{

		Integer regFlag = loginService.laGouReg(laGouUser);
		return regFlag;
	}

	/**
	 * 前台公司注册修改userid
	 */
	@RequestMapping("updateComIdByName")
	@ResponseBody
	public void queryComIdByName(String loginName){
		loginService.queryComIdByName(loginName);
	}


	/**
	 * 前台公司登录
	 * @param laGouUser
	 * @return
	 */
	@RequestMapping("laGouLoginGS")
	@ResponseBody
	public Integer laGouLoginGS(LoginUser laGouUser,HttpServletRequest req){
		Integer loginFlag = 0;
			if(mobile_code == Integer.parseInt(laGouUser.getCheckCode())) {
				Map<String, Object> map = loginService.laGouLoginGS(laGouUser);
				if (!map.isEmpty()) {
					loginFlag = (Integer) map.get("loginComFlag");
					LoginUser laGouUsers = (LoginUser) map.get("laGouCom");
					req.getSession().setAttribute("laGouComSession", laGouUsers);
					return loginFlag;
				} else {
					loginFlag = 3;
					return loginFlag;
				}
			}
			return loginFlag;
	}

	/**
	 * 前台公司注销
	 * @param req
	 */
	@RequestMapping("zhuXiaoGs")
	@ResponseBody
	public void zhuXiaoGs(HttpServletRequest req){
		req.getSession().removeAttribute("laGouComSession");
	}


	/**
	 * 前台注册修改userid
	 */
	@RequestMapping("updateUserIdByName")
	@ResponseBody
	public void queryIdByName(String loginName){
		loginService.queryIdByName(loginName);
	}

	/**
	 * 前台注册检测用户名
	 * @param laGouUser
	 * @return
	 */
	@RequestMapping("laGouRegCheck")
	@ResponseBody
	public Integer laGouRegCheck(LoginUser laGouUser){

		Integer regFlag = loginService.laGouRegCheck(laGouUser);
		return regFlag;
	}

	/**
	 * 前台用户登录
	 * @param laGouUser
	 * @return
	 */
	@RequestMapping("laGouLogin")
	@ResponseBody
	public Integer laGouLogin(LoginUser laGouUser,HttpServletRequest req){
		Integer loginFlag = 0;
		if(mobile_code == Integer.parseInt(laGouUser.getCheckCode())) {

			Map<String, Object> map = loginService.laGouLogin(laGouUser);
			if (!map.isEmpty()) {
				loginFlag = (Integer) map.get("loginFlag");
				LoginUser laGouUsers = (LoginUser) map.get("laGouUsers");
				req.getSession().setAttribute("laGouUserSession", laGouUsers);
				return loginFlag;
			}else{
				loginFlag = 3;

				return loginFlag;
			}
		}
		return loginFlag;
	}

	/**
	 * 前台用户注销
	 * @param req
	 */
	@RequestMapping("zhuXiao")
	@ResponseBody
	public void zhuXiao(HttpServletRequest req){
		req.getSession().removeAttribute("laGouUserSession");
	}

	//后台注销用户
	@RequestMapping("loginOut")
	public String loginOut(HttpServletRequest request){

		request.getSession().removeAttribute("user");

		return "outLogin";
	}
	//后台注册用户
	@RequestMapping("addUser")
	@ResponseBody
	public String addUser(User user){
		String lg = "";
		User us= loginService.checkLoginName(user);
		if(us!=null){
			lg = "该用户已经存在,请重新注册";
			return lg;
		}else{
				loginService.addUserLogin(user);
			lg = "注册成功";
			System.out.println(lg);
			return lg;
		}


		}

	//后台用户登录
	@RequestMapping("login")
	@ResponseBody
	public Integer login(User user,HttpServletRequest request){
		int flag=0;
		if(user.getLoginname() == null || user.getLoginname() == ""){
			flag=4;
			return flag;
		}
		if(user.getPwd() == null || user.getPwd() == ""){
			flag=5;
			return flag;
		}

		try {
			User login =loginService.login(user);

			if(login!=null){

				User userLogin = loginService.getResourcesRoleList(login);
				request.getSession().setAttribute("user", userLogin);
				return flag = 1;
			}else{
				flag=0;
				return flag;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
	}


	/**
	 * 统计注册用户
	 * @return
	 */
	@RequestMapping("tongJiRegNum")
	@ResponseBody
	public List<TongJi> tongJiRegNum(){

		List<TongJi> tongjiUser = loginService.tongJiRegNum();

		return tongjiUser;
	}

	/**
	 * 后台公司登录
	 * @param loginGs
	 * @return
	 */
	@RequestMapping("loginGS")
	@ResponseBody
	public Integer loginGS(LoginGs loginGs,HttpServletRequest req){
		Integer GsFlag = loginService.loginGS(loginGs);
		return GsFlag;
	}

	/**
	 * 后台公司注册
	 * @param loginGs
	 * @return
	 */
	@RequestMapping("regGS")
	@ResponseBody
	public Integer regGS(LoginGs loginGs){
		Integer GsFlag = loginService.addRegGS(loginGs);
		return GsFlag;
	}

	/**
	 * 获取历史上的今天
	 * @return
	 */
	@RequestMapping("getHistory")
	@ResponseBody
	public String getHistory(){

		Date date = new Date();
		int Months = date.getMonth() + 1;
		int day = date.getDate();
		String request1 = HistoryTodayUtil.getRequest1(Months, day);
		System.out.println(request1);
		return request1;
	}

}
