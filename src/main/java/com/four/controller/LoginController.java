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
import com.four.service.JiuYeService;
import com.four.utils.CheckImgUtil;
import com.four.utils.ValidateCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("loginController")
public class LoginController {
	
	@Autowired
	private ILoginService loginService;
	@Autowired
	private JiuYeService jiuYeService;
	
	int mobile_code ;


	/**
	 * 刷新验证码
	 * @param request
	 * @param response
	 */
	@RequestMapping("checkImg")
	public void checkImg(HttpServletRequest request,HttpServletResponse response){
		try {
			CheckImgUtil.checkImg(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 前台注销
	 */
	public void LaGouOut(HttpServletRequest req){
		String sessionUserid = (String) req.getSession().getAttribute("sessionUserid");
		String sessionComid = (String) req.getSession().getAttribute("sessionComid");
		req.getSession().removeAttribute("sessionUserid");
		req.getSession().removeAttribute("sessionComid");
		Jedis jedis = new Jedis("192.168.116.129",6379);
		jedis.del("sessionUserid");
		jedis.del("sessionComid");
		jedis.close();
	}


	/**
	 * 前台注册
	 * @param laGouUser
	 * @return
	 */
	@RequestMapping("laGouReg")
	@ResponseBody
	public Integer laGouReg(LoginUser laGouUser){

		Integer regFlag = loginService.laGouReg(laGouUser);
		return regFlag;
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
	 * 前台登录
	 * @param laGouUser
	 * @return
	 */
	@RequestMapping("laGouLogin")
	@ResponseBody
	public Integer laGouLogin(LoginUser laGouUser,HttpServletRequest req){

		Integer loginFlag = loginService.laGouLogin(laGouUser);

		Jedis jedis = new Jedis("192.168.116.129",6379);
		//这里肯定是都能取到的
		String userid = jedis.get(laGouUser.getUserid().toString());
			req.getSession().setAttribute("sessionUserid",userid);

		String comid = jedis.get(laGouUser.getComid().toString());
			req.getSession().setAttribute("sessionComid",comid);

			jedis.close();

		return loginFlag;
	}

//	@RequestMapping("setPhone")
//	public void setPhone(String phone){
//
//		mobile_code=sendsms.mobile(phone);
//	}
	
	//注销用户
	@RequestMapping("loginOut")
	public String loginOut(HttpServletRequest request){
		
		request.getSession().removeAttribute("user");

		return "outLogin";
	}
	//注册用户
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

	//用户登录
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
//				//判断登录的用户类型
//				if(login.getTypeid() == 1){
//					//求职者
//					return flag = 1;
//				}else if(login.getTypeid() == 0){
//					//招聘者
//				}
				return flag = 1;
			}else{
				flag=0;
				return flag;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
//				return flag;
	}

	
	
	/** 
	 * 响应验证码页面 
	 * @return 
	 */  
	/*@RequestMapping(value="/login")  
	public String login(HttpServletRequest request,HttpServletResponse response) throws Exception{  
		String resultStr = "login";
		String code = request.getParameter("code");  
		HttpSession session = request.getSession();  
		String sessionCode = (String) session.getAttribute("code");  
		if (!StringUtils.equalsIgnoreCase(code, sessionCode)) {  //忽略验证码大小写  
			model.addAttribute("validateFlag", 2);
			resultStr = "login";
//		    throw new RuntimeException("验证码对应不上code=" + code + "  sessionCode=" + sessionCode);  
		} else {
			model.addAttribute("validateFlag", 1);
			resultStr = "index";
		}
		return resultStr;
	}*/
	
	
	
	
	//手机验证
/*	@RequestMapping("yanzheng")
	public void yz(String shoujihao,HttpServletRequest request,HttpServletResponse response){
		 HttpSession session = request.getSession();
		//		NEW出他的接口
		sendsms sen=new sendsms();
//		调用他的验证码类
//		cc是那边返回的验证码
		int cc = sen.aa(shoujihao);
		session.setAttribute("cc", cc);
		System.out.println(cc+"---------");
//		给前台返回

	}
	
	
	
	
	*/
	//验证码
	@RequestMapping("/validateCode")
	public void validateCode(HttpServletRequest request,HttpServletResponse response){
		// 设置响应的类型格式为图片格式  
	    response.setContentType("image/jpeg");  
	    //禁止图像缓存。  
	    response.setHeader("Pragma", "no-cache");  
	    response.setHeader("Cache-Control", "no-cache");  
	    response.setDateHeader("Expires", 0);  
	    
	    //获取session对象
	    HttpSession session = request.getSession();
	    
	    //获取验证码图片以及验证码code值
	    ValidateCodeUtil vCode = new ValidateCodeUtil(120,40,4,50);
	    System.out.println(vCode.getCode());
	    //将验证码code值存入session当中
	    session.setAttribute("code", vCode.getCode());
	    
	    try {
	    	//将验证码图片写入到jsp页面
			vCode.write(response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
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
	public Integer loginGS(LoginGs loginGs){
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



}
