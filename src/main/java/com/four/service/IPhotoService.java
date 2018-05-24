/** 
 * <pre>项目名称:four_group 
 * 文件名称:IPhotoService.java 
 * 包名:com.four.service 
 * 创建日期:2018年3月12日下午9:10:01 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.four.service;

import com.four.model.Photo;

import java.util.List;

/** 
 * <pre>项目名称：four_group    
 * 类名称：IPhotoService    
 * 类描述：    
 * 创建人：薛怡衡  
 * 创建时间：2018年3月12日 下午9:10:01    
 * 修改人：薛怡衡    
 * 修改时间：2018年3月12日 下午9:10:01    
 * 修改备注：       
 * @version </pre>    
 */
public interface IPhotoService {

	/** <pre>queryPhotoList(这里用一句话描述这个方法的作用)   
	 * 创建人：薛怡衡
	 * 创建时间：2018年3月13日 下午12:00:17    
	 * 修改人:薛怡衡      
	 * 修改时间：2018年3月13日 下午12:00:17    
	 * 修改备注： 
	 * @return</pre>    
	 * @throws Exception 
	 */
	List<Photo> queryPhotoList() throws Exception;

	/** <pre>addPhoto(这里用一句话描述这个方法的作用)   
	 * 创建人：薛怡衡
	 * 创建时间：2018年3月13日 下午1:36:40    
	 * 修改人:薛怡衡      
	 * 修改时间：2018年3月13日 下午1:36:40    
	 * 修改备注： 
	 * @param photo</pre>    
	 * @throws Exception 
	 */
	void addPhoto(Photo photo) throws Exception;

	/** <pre>queryPhotoLists(这里用一句话描述这个方法的作用)   
	 * 创建人：薛怡衡
	 * 创建时间：2018年3月13日 下午4:17:33    
	 * 修改人:薛怡衡      
	 * 修改时间：2018年3月13日 下午4:17:33    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<Photo> queryPhotoLists() throws Exception;

	

}
