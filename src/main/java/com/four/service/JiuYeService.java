/** 
 * <pre>项目名称:four_group 
 * 文件名称:TongJiService.java 
 * 包名:com.four.service 
 * 创建日期:2018年3月16日上午9:51:06 
 * Copyright (c) 2018, 1103304339@qq.com All Rights Reserved.</pre> 
 */  
package com.four.service;

import com.alibaba.fastjson.JSONObject;
import com.four.model.JiuYe;

/** 
 * <pre>项目名称：four_group    
 * 类名称：TongJiService    
 * 类描述：    
 * 创建人：苑鹏飞  1103304339@qq.com   
 * 创建时间：2018年3月16日 上午9:51:06    
 * 修改人：苑鹏飞  1103304339@qq.com      
 * 修改时间：2018年3月16日 上午9:51:06    
 * 修改备注：       
 * @version </pre>    
 */
public interface JiuYeService {

	/** <pre>queryTongJi(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月16日 上午10:04:31    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月16日 上午10:04:31    
	 * 修改备注： 
	 * @param tongji
	 * @param rows
	 * @param page
	 * @return</pre>    
	 */
	JSONObject queryTongJi(JiuYe tongji, Integer rows, Integer page);
	/**
	 * <pre>updateQiuZhiCount(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月16日 上午10:27:42    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月16日 上午10:27:42    
	 * 修改备注： 注册成功  求职人员+1
	 * @return</pre>
	 */
	void updateQiuZhiCount();
	/**
	 * <pre>updateRuZhiCount(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月16日 上午10:28:01    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月16日 上午10:28:01    
	 * 修改备注： 面试通过  入职人员+1
	 * @return</pre>
	 */
	void updateRuZhiCount();
	/** <pre>insertJiuYe(这里用一句话描述这个方法的作用)   
	 * 创建人：苑鹏飞 1103304339@qq.com     
	 * 创建时间：2018年3月19日 下午6:39:09    
	 * 修改人：苑鹏飞  1103304339@qq.com   
	 * 修改人电话：17600552303
	 * 修改时间：2018年3月19日 下午6:39:09    
	 * 修改备注： </pre>    
	 */
	void insertJiuYe();

}
