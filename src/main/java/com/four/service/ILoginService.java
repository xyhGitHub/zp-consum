/** 
 * <pre>项目名称:four_group 
 * 文件名称:ILoginService.java 
 * 包名:com.four.service 
 * 创建日期:2018年3月13日下午1:12:30 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.four.service;

import com.four.model.LoginGs;
import com.four.model.LoginUser;
import com.four.model.TongJi;
import com.four.model.User;

import java.util.List;
import java.util.Map;

/** 
 * <pre>项目名称：four_group    
 * 类名称：ILoginService    
 * 类描述：    
 * 创建人：孙梦娜  
 * 创建时间：2018年3月13日 下午1:12:30    
 * 修改人：孙梦娜    
 * 修改时间：2018年3月13日 下午1:12:30    
 * 修改备注：       
 * @version </pre>    
 */
public interface ILoginService {

	
	User login(User user)throws Exception;


	User getResourcesRoleList(User login)throws Exception;


	/** <pre>checkLoginName(这里用一句话描述这个方法的作用)   
	 * 创建人：张国彬 
	 * 创建时间：2018年3月13日 下午8:29:26    
	 * 修改人:张国彬       
	 * 修改时间：2018年3月13日 下午8:29:26    
	 * 修改备注： 
	 * @param user
	 * @return</pre>    
	 */
	User checkLoginName(User user);


	/** <pre>addUserLogin(这里用一句话描述这个方法的作用)   
	 * 创建人：张国彬 
	 * 创建时间：2018年3月14日 上午10:34:34    
	 * 修改人:张国彬       
	 * 修改时间：2018年3月14日 上午10:34:34    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void addUserLogin(User user);

	Integer laGouReg(LoginUser laGouUser);

	Integer laGouRegCheck(LoginUser laGouUser);

	Map<String,Object> laGouLogin(LoginUser laGouUser);

	List<TongJi> tongJiRegNum();

	Integer loginGS(LoginGs loginGs);

	Integer addRegGS(LoginGs loginGs);

    void queryIdByName(String loginName);

	void queryComIdByName(String loginName);

	Integer laGouRegGSCheck(LoginUser laGouUser);

	Map<String,Object> laGouLoginGS(LoginUser laGouUser);
}
