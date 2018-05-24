/** 
 * <pre>项目名称:four_group 
 * 文件名称:IDeptService.java 
 * 包名:com.four.service 
 * 创建日期:2018年3月13日下午7:26:25 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.four.service;

import com.four.model.Dept;

import java.util.List;
import java.util.Map;

/** 
 * <pre>项目名称：four_group    
 * 类名称：IDeptService    
 * 类描述：    
 * 创建人：薛怡衡  
 * 创建时间：2018年3月13日 下午7:26:25    
 * 修改人：薛怡衡    
 * 修改时间：2018年3月13日 下午7:26:25    
 * 修改备注：       
 * @version </pre>    
 */
public interface IDeptService {


	/** <pre>queryDept(这里用一句话描述这个方法的作用)   
	 * 创建人：薛怡衡
	 * 创建时间：2018年3月13日 下午7:51:49    
	 * 修改人:薛怡衡      
	 * 修改时间：2018年3月13日 下午7:51:49    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @param dept
	 * @return</pre>    
	 * @throws Exception 
	 */
	Map<String, Object> queryDeptInfo(int page, int rows, Dept dept) throws Exception;

	/** <pre>addDept(这里用一句话描述这个方法的作用)   
	 * 创建人：薛怡衡
	 * 创建时间：2018年3月13日 下午8:10:06    
	 * 修改人:薛怡衡      
	 * 修改时间：2018年3月13日 下午8:10:06    
	 * 修改备注： 
	 * @param dept
	 * @return</pre>    
	 * @throws Exception 
	 */
	int addDept(Dept dept) throws Exception;

	/** <pre>deleteSome(这里用一句话描述这个方法的作用)   
	 * 创建人：薛怡衡
	 * 创建时间：2018年3月13日 下午8:21:10    
	 * 修改人:薛怡衡      
	 * 修改时间：2018年3月13日 下午8:21:10    
	 * 修改备注： 
	 * @param idList
	 * @return</pre>    
	 * @throws Exception 
	 */
	int deleteSome(String idList) throws Exception;

	/** <pre>queryDeptName(这里用一句话描述这个方法的作用)   
	 * 创建人：薛怡衡
	 * 创建时间：2018年3月14日 上午10:28:41    
	 * 修改人:薛怡衡      
	 * 修改时间：2018年3月14日 上午10:28:41    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Dept> queryDeptName();

	/** <pre>queryDeptNum(这里用一句话描述这个方法的作用)   
	 * 创建人：薛怡衡
	 * 创建时间：2018年3月16日 上午10:30:22    
	 * 修改人:薛怡衡      
	 * 修改时间：2018年3月16日 上午10:30:22    
	 * 修改备注： 
	 * @param deptid
	 * @return</pre>    
	 */
	List queryDeptNum(Integer deptid);

}
