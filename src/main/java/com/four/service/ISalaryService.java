package com.four.service;

import com.alibaba.fastjson.JSONObject;
import com.four.model.Salary;
import com.four.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISalaryService {

	/** <pre>salarylist(薪资查询有分业)   
	 * 创建人：孙梦娜  
	 * 创建时间：2018年3月13日 下午7:46:02    
	 * 修改人:孙梦娜        
	 * 修改时间：2018年3月13日 下午7:46:02    
	 * 修改备注： 
	 * @param page
	 * @param rows
	 * @param salary
	 * @return</pre>    
	 * @throws Exception 
	 */
	JSONObject salarylist(@Param("page") int page, @Param("rows") int rows, @Param("salary") Salary salary) throws Exception;

	/** <pre>addsalary(这里用一句话描述这个方法的作用)   
	 * 创建人：孙梦娜  
	 * 创建时间：2018年3月13日 下午9:49:14    
	 * 修改人:孙梦娜        
	 * 修改时间：2018年3月13日 下午9:49:14    
	 * 修改备注： 
	 * @param salary
	 * @return</pre>    
	 */
	int addsalary(Salary salary)throws Exception;

	/** <pre>deleteByPrimaryKey(这里用一句话描述这个方法的作用)   
	 * 创建人：孙梦娜  
	 * 创建时间：2018年3月14日 上午10:03:32    
	 * 修改人:孙梦娜        
	 * 修改时间：2018年3月14日 上午10:03:32    
	 * 修改备注： 
	 * @param salaryid</pre>    
	 */
	void deleteByPrimaryKey(String salaryid)throws Exception;

	/** <pre>selectByPrimaryKey(修改之查询)   
	 * 创建人：孙梦娜  
	 * 创建时间：2018年3月14日 上午10:29:08    
	 * 修改人:孙梦娜        
	 * 修改时间：2018年3月14日 上午10:29:08    
	 * 修改备注： 
	 * @param salaryid
	 * @return</pre>    
	 */
	Salary selectByPrimaryKey(String salaryid)throws Exception;

	/** <pre>updateByPrimaryKey(这里用一句话描述这个方法的作用)   
	 * 创建人：孙梦娜  
	 * 创建时间：2018年3月14日 上午10:49:06    
	 * 修改人:孙梦娜        
	 * 修改时间：2018年3月14日 上午10:49:06    
	 * 修改备注： 
	 * @param salary</pre>    
	 */
	void updateByPrimaryKey(Salary salary);

	/** <pre>selectuser(这里用一句话描述这个方法的作用)   
	 * 创建人：孙梦娜  
	 * 创建时间：2018年3月16日 上午10:18:23    
	 * 修改人:孙梦娜        
	 * 修改时间：2018年3月16日 上午10:18:23    
	 * 修改备注： 
	 * @param salarysum
	 * @param salarysum2 
	 * @return</pre>    
	 */
	List<User> selectuser(@Param("salarysum") Integer salarysum, @Param("salarysum2") Integer salarysum2);

}
