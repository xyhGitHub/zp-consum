/** 
 * <pre>项目名称:four_group 
 * 文件名称:RoleService.java 
 * 包名:com.four.service 
 * 创建日期:2018年3月12日下午8:27:05 
 * Copyright (c) 2018, 1103304339@qq.com All Rights Reserved.</pre> 
 */  
package com.four.service;

import com.four.model.Role;

import java.util.Map;

/** 
 * <pre>项目名称：four_group    
 * 类名称：RoleService    
 * 类描述：    
 * 创建人：苑鹏飞  1103304339@qq.com   
 * 创建时间：2018年3月12日 下午8:27:05    
 * 修改人：苑鹏飞  1103304339@qq.com      
 * 修改时间：2018年3月12日 下午8:27:05    
 * 修改备注：       service接口层
 * @version </pre>    
 */
public interface RoleService {

	/** <pre>queryRole(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月12日 下午8:56:16    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月12日 下午8:56:16    
	 * 修改备注： 查询角色   -分页-条件
	 * @param role
	 * @param rows
	 * @param page
	 * @return</pre>    
	 */
	Map<String,Object> queryRole(Role role, Integer rows, Integer page);

	/** <pre>insertRole(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月12日 下午9:13:04    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月12日 下午9:13:04    
	 * 修改备注：  角色新增
	 * @param role
	 * @return</pre>    
	 */
	int insertRole(Role role);

	/** <pre>deleteRoleByIDs(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月12日 下午10:15:12    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月12日 下午10:15:12    
	 * 修改备注： 角色删除，批量删除
	 * @param ids
	 * @return</pre>    
	 */
	Integer deleteRoleByIDs(String ids);

	/** <pre>toRoleById(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月13日 上午11:23:50    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月13日 上午11:23:50    
	 * 修改备注：  角色修改的回显
	 * @param role
	 * @return</pre>    
	 */
	Role toRoleById(Role role);

	/** <pre>updateRoleById(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月13日 上午11:49:57    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月13日 上午11:49:57    
	 * 修改备注： 根据ID修改选择的角色信息
	 * @param role</pre>    
	 */
	void updateRoleById(Role role);


}
