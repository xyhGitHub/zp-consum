package com.four.service;

import com.alibaba.fastjson.JSONObject;
import com.four.model.Role;
import com.four.model.User;

import java.util.List;

public interface IUserService {


	/** <pre>userlist(这里用一句话描述这个方法的作用)   
	 * 创建人：刘文圣
	 * 创建时间：2018年3月9日 下午10:38:52    
	 * 修改人：刘文圣
	 * 修改时间：2018年3月9日 下午10:38:52    
	 * 修改备注： 
	 * @param startIndex
	 * @param pageSize
	 * @param user
	 * @return</pre>    
	 */
	JSONObject queryUserList(int startIndex, int pageSize, User user) throws Exception;

	/** <pre>deleteUserByIds(这里用一句话描述这个方法的作用)   
	 * 创建人：刘文圣
	 * 创建时间：2018年3月10日 上午10:50:08    
	 * 修改人：刘文圣
	 * 修改时间：2018年3月10日 上午10:50:08    
	 * 修改备注： 
	 * @param str</pre>    
	 */
	void deleteUserByIds(String str) throws Exception;

	/** <pre>queryUserById(这里用一句话描述这个方法的作用)   
	 * 创建人：刘文圣
	 * 创建时间：2018年3月10日 下午11:23:19    
	 * 修改人：刘文圣
	 * 修改时间：2018年3月10日 下午11:23:19    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	User queryUserById(String id)throws Exception;

	/** <pre>addUser(这里用一句话描述这个方法的作用)   
	 * 创建人：刘文圣
	 * 创建时间：2018年3月11日 上午10:44:28    
	 * 修改人：刘文圣
	 * 修改时间：2018年3月11日 上午10:44:28    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void addUserData(User user)throws Exception;
	
	/** <pre>updateUserById(这里用一句话描述这个方法的作用)   
	 * 创建人：刘文圣
	 * 创建时间：2018年3月11日 上午11:12:16    
	 * 修改人：刘文圣
	 * 修改时间：2018年3月11日 上午11:12:16    
	 * 修改备注： 
	 * @param user</pre>    
	 */
	void updateUserById(User user)throws Exception;

	/** <pre>queryRoleByUserid(这里用一句话描述这个方法的作用)   
	 * 创建人：JavaScript  
	 * 创建时间：2018年3月13日 下午7:21:58    
	 * 修改人：JavaScript 
	 * 修改时间：2018年3月13日 下午7:21:58    
	 * 修改备注： 
	 * @param id 
	 * @return</pre>    
	 */
	List<User> queryRoleByUserid(Integer id)throws Exception;

	/** <pre>getRoleAll(这里用一句话描述这个方法的作用)   
	 * 创建人：JavaScript  
	 * 创建时间：2018年3月13日 下午7:58:22    
	 * 修改人：JavaScript 
	 * 修改时间：2018年3月13日 下午7:58:22    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Role> getRoleAll()throws Exception;

	/** <pre>saveRolesByUserId(这里用一句话描述这个方法的作用)   
	 * 创建人：JavaScript  
	 * 创建时间：2018年3月13日 下午8:55:31    
	 * 修改人：JavaScript 
	 * 修改时间：2018年3月13日 下午8:55:31    
	 * 修改备注： 
	 * @param userId
	 * @param roleId</pre>    
	 */
	void saveRolesByUserId(Integer userId, String roleId)throws Exception;

	/** <pre>queryUserResumeList(这里用一句话描述这个方法的作用)   
	 * 创建人：刘文圣
	 * 创建时间：2018年3月14日 下午8:52:04    
	 * 修改人：刘文圣
	 * 修改时间：2018年3月14日 下午8:52:04    
	 * 修改备注： 
	 * @param typeidcriteria
	 * @return</pre>    
	 */
	User queryUserResumeList(Integer typeidcriteria)throws Exception;

	/** <pre>lookCompany(这里用一句话描述这个方法的作用)   
	 * 创建人：刘文圣
	 * 创建时间：2018年3月16日 上午10:33:23    
	 * 修改人：刘文圣
	 * 修改时间：2018年3月16日 上午10:33:23    
	 * 修改备注： 
	 * @param u
	 * @return</pre>    
	 */
	User lookCompany(User u)throws Exception;

	/** <pre>querySeclect(这里用一句话描述这个方法的作用)   
	 * 创建人：刘文圣
	 * 创建时间：2018年3月16日 下午2:15:12    
	 * 修改人：刘文圣
	 * 修改时间：2018年3月16日 下午2:15:12    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<User> querySeclect()throws Exception;

	/** <pre>queryTypeListSelect(这里用一句话描述这个方法的作用)   
	 * 创建人：刘文圣
	 * 创建时间：2018年3月16日 下午3:29:28    
	 * 修改人：刘文圣
	 * 修改时间：2018年3月16日 下午3:29:28    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<User> queryTypeListSelect()throws Exception;




}
