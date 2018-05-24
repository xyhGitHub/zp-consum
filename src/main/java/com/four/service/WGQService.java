/** 
 * <pre>项目名称:seven_group 
 * 文件名称:WGQService.java 
 * 包名:com.seven.service 
 * 创建日期:2018年3月14日下午4:10:26 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.four.service;

import com.four.model.CompanyAndPost;

import javax.servlet.http.HttpServletRequest;

/** 
 * <pre>项目名称：seven_group    
 * 类名称：WGQService    
 * 类描述：    
 * 创建人：JavaScript 
 * 创建时间：2018年3月14日 下午4:10:26    
 * 修改人：JavaScript  
 * 修改时间：2018年3月14日 下午4:10:26    
 * 修改备注：       
 * @version </pre>    
 */
public interface WGQService {

	/** <pre>queryCompanyAndPost(这里用一句话描述这个方法的作用)   
	 * 创建人：JavaScript  
	 * 创建时间：2018年3月14日 下午4:10:42    
	 * 修改人：JavaScript 
	 * 修改时间：2018年3月14日 下午4:10:42    
	 * 修改备注： 
	 * @param com 
	 * @param request 
	 * @return</pre>    
	 */
	Object queryCompanyAndPost(CompanyAndPost com, HttpServletRequest request);

	/** <pre>getCompanyAll(这里用一句话描述这个方法的作用)   
	 * 创建人：JavaScript  
	 * 创建时间：2018年3月14日 下午7:01:00    
	 * 修改人：JavaScript 
	 * 修改时间：2018年3月14日 下午7:01:00    
	 * 修改备注： 
	 * @return</pre>    
	 */
	Object getCompanyAll();

	/** <pre>getPostAll(这里用一句话描述这个方法的作用)   
	 * 创建人：JavaScript  
	 * 创建时间：2018年3月14日 下午7:01:08    
	 * 修改人：JavaScript 
	 * 修改时间：2018年3月14日 下午7:01:08    
	 * 修改备注： 
	 * @return</pre>    
	 */
	Object getPostAll();

	/** <pre>UserPutResume(这里用一句话描述这个方法的作用)   
	 * 创建人：JavaScript  
	 * 创建时间：2018年3月16日 上午10:56:42    
	 * 修改人：JavaScript 
	 * 修改时间：2018年3月16日 上午10:56:42    
	 * 修改备注： 
	 * @param postid
	 * @param request
	 * @return</pre>    
	 */
	Object UserPutResume(String postid, HttpServletRequest request);

	/** <pre>queryCompanyAndPostByuserid(这里用一句话描述这个方法的作用)   
	 * 创建人：JavaScript  
	 * 创建时间：2018年3月16日 下午2:49:11    
	 * 修改人：JavaScript 
	 * 修改时间：2018年3月16日 下午2:49:11    
	 * 修改备注： 
	 * @param offset
	 * @param limit
	 * @param request
	 * @return</pre>    
	 */
	Object queryCompanyAndPostByuserid(Integer offset, Integer limit, HttpServletRequest request);

	/** <pre>UpdateComPostResume(这里用一句话描述这个方法的作用)   
	 * 创建人：JavaScript  
	 * 创建时间：2018年3月16日 下午4:29:01    
	 * 修改人：JavaScript 
	 * 修改时间：2018年3月16日 下午4:29:01    
	 * 修改备注： 
	 * @param postid
	 * @param request
	 * @return</pre>    
	 */
	Object UpdateComPostResume(String postid, HttpServletRequest request);

}
