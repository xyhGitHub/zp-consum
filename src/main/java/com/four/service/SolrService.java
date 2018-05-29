/** 
 * <pre>项目名称:ssmsolrdemo 
 * 文件名称:SolrService.java 
 * 包名:com.jk.service 
 * 创建日期:2018年5月10日下午7:18:57 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.four.service;

import com.four.model.PageModel;
import com.four.model.Zhiwei;

/** 
 * <pre>项目名称：ssmsolrdemo    
 * 类名称：SolrService    
 * 类描述：    
 * 创建人：周录军     
 * 创建时间：2018年5月10日 下午7:18:57    
 * 修改人：周录军 
 * 修改时间：2018年5月10日 下午7:18:57    
 * 修改备注：       
 * @version </pre>    
 */
public interface SolrService {

	/** <pre>getSolrList(这里用一句话描述这个方法的作用)   
	 * 创建人：周录军     
	 * 创建时间：2018年5月10日 下午7:19:02    
	 * 修改人：周录军 
	 * 修改时间：2018年5月10日 下午7:19:02    
	 * 修改备注： 
	 * @param zhiweiLittle 
	 * @param pageModel 
	 * @return</pre>    
	 */
	PageModel<Zhiwei> getSolrList(PageModel pageModel, Zhiwei zhiweiLittle) throws Exception;

	/** <pre>deletesolr(这里用一句话描述这个方法的作用)   
	 * 创建人：周录军     
	 * 创建时间：2018年5月10日 下午9:10:51    
	 * 修改人：周录军 
	 * 修改时间：2018年5月10日 下午9:10:51    
	 * 修改备注： 
	 * @param id</pre>    
	 */
	void deletesolr(String id);

	/** <pre>addsolr(这里用一句话描述这个方法的作用)   
	 * 创建人：周录军     
	 * 创建时间：2018年5月10日 下午9:26:46    
	 * 修改人：周录军 
	 * 修改时间：2018年5月10日 下午9:26:46    
	 * 修改备注： 
	 * @param zhiweiLittle</pre>    
	 */
	void addsolr(Zhiwei zhiweiLittle);

}
