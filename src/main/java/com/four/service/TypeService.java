/** 
 * <pre>项目名称:four_group 
 * 文件名称:TypeService.java 
 * 包名:com.four.service 
 * 创建日期:2018年3月14日上午11:26:09 
 * Copyright (c) 2018, 1103304339@qq.com All Rights Reserved.</pre> 
 */  
package com.four.service;

import com.four.model.Type;

import java.util.List;

;

/** 
 * <pre>项目名称：four_group    
 * 类名称：TypeService    
 * 类描述：    账户类型接口
 * 创建人：苑鹏飞  1103304339@qq.com   
 * 创建时间：2018年3月14日 上午11:26:09    
 * 修改人：苑鹏飞  1103304339@qq.com      
 * 修改时间：2018年3月14日 上午11:26:09    
 * 修改备注：       
 * @version </pre>    
 */
public interface TypeService {
	/**
	 * <pre>queryType(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月14日 上午11:31:17    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月14日 上午11:31:17    
	 * 修改备注： 查询类型    注意点，type别倒错包了,包挺多的，用到的时候来我这粘
	 * 注意点    没有Controller层    目前只有接口   需要调用就行
	 * @return</pre>
	 */
	List<Type> queryType();
	
	
	
}
