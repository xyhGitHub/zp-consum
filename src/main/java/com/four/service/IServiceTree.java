/** 
 * <pre>项目名称:ssm-beans 
 * 文件名称:IServiceTree.java 
 * 包名:com.smn.service 
 * 创建日期:2018年3月6日下午8:29:36 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.four.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.four.model.Tree;
import com.four.model.User;


/** 
 * <pre>项目名称：ssm-beans    
 * 类名称：IServiceTree    
 * 类描述：    
 * 创建人：孙梦娜  
 * 创建时间：2018年3月6日 下午8:29:36    
 * 修改人：孙梦娜    
 * 修改时间：2018年3月6日 下午8:29:36    
 * 修改备注：       
 * @version </pre>    
 */
public interface IServiceTree {

	/** <pre>treelist(这里用一句话描述这个方法的作用)   
	 * 创建人：孙梦娜  
	 * 创建时间：2018年3月6日 下午8:39:48    
	 * 修改人:孙梦娜        
	 * 修改时间：2018年3月6日 下午8:39:48    
	 * 修改备注： 
	 * @param tree
	 * @return</pre>    
	 */
	List<Tree> treelist() throws Exception;

	/** <pre>insertSelective(这里用一句话描述这个方法的作用)   
	 * 创建人：孙梦娜  
	 * 创建时间：2018年3月8日 下午7:24:08    
	 * 修改人:孙梦娜        
	 * 修改时间：2018年3月8日 下午7:24:08    
	 * 修改备注： 
	 * @param tree
	 * @return</pre>    
	 */
	int insertSelective(Tree tree);

	/** <pre>deleteByPrimaryKey(这里用一句话描述这个方法的作用)   
	 * 创建人：孙梦娜  
	 * 创建时间：2018年3月8日 下午8:41:21    
	 * 修改人:孙梦娜        
	 * 修改时间：2018年3月8日 下午8:41:21    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	void deleteByPrimaryKey(Integer id);

	/** <pre>selectByPrimaryKey(这里用一句话描述这个方法的作用)   
	 * 创建人：孙梦娜  
	 * 创建时间：2018年3月9日 上午8:50:24    
	 * 修改人:孙梦娜        
	 * 修改时间：2018年3月9日 上午8:50:24    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	Tree selectByPrimaryKey(Integer id);

	/** <pre>updateByPrimaryKey(这里用一句话描述这个方法的作用)   
	 * 创建人：孙梦娜  
	 * 创建时间：2018年3月9日 上午9:14:44    
	 * 修改人:孙梦娜        
	 * 修改时间：2018年3月9日 上午9:14:44    
	 * 修改备注： 
	 * @param tree
	 * @return</pre>    
	 */
	void updateByPrimaryKey(Tree tree);

	/** <pre>queryRoleTree(这里用一句话描述这个方法的作用)   
	 * 创建人：孙梦娜  
	 * 创建时间：2018年3月9日 下午9:31:19    
	 * 修改人:孙梦娜        
	 * 修改时间：2018年3月9日 下午9:31:19    
	 * 修改备注： 
	 * @param roleId
	 * @return</pre>    
	 */
	List<Tree> queryRoleTree(int roleId);

	/** <pre>selectTreeList(这里用一句话描述这个方法的作用)   
	 * 创建人：孙梦娜  
	 * 创建时间：2018年3月9日 下午9:31:21    
	 * 修改人:孙梦娜        
	 * 修改时间：2018年3月9日 下午9:31:21    
	 * 修改备注： 
	 * @param tre
	 * @return</pre>    
	 */
	List<Tree> selectTreeList(Tree tre);

	/** <pre>addTreeRoleRelation(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月13日 下午7:11:50    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月13日 下午7:11:50    
	 * 修改备注： 
	 * @param ids
	 * @param roleId</pre>    
	 */
	void addTreeRoleRelation(String ids, String roleId);

	/** <pre>getRoleTreeList(这里用一句话描述这个方法的作用)   
	 * 创建人：孙梦娜  
	 * 创建时间：2018年3月20日 下午4:35:40    
	 * 修改人:孙梦娜        
	 * 修改时间：2018年3月20日 下午4:35:40    
	 * 修改备注： 
	 * @param user
	 * @return</pre>    
	 */
	Set<Map<String, Object>> getRoleTreeList(User user);

	

}
