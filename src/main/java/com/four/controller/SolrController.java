/** 
 * <pre>项目名称:ssmsolrdemo 
 * 文件名称:SolrController.java 
 * 包名:com.four.controller 
 * 创建日期:2018年5月10日下午7:16:38 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.four.controller;

import com.four.model.ZhiweiLittle;
import com.four.service.SolrService;
import com.four.utils.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
 * <pre>项目名称：ssmsolrdemo    
 * 类名称：SolrController    
 * 类描述：    
 * 创建人：周录军     
 * 创建时间：2018年5月10日 下午7:16:38    
 * 修改人：周录军 
 * 修改时间：2018年5月10日 下午7:16:38    
 * 修改备注：       
 * @version </pre>    
 */
@RequestMapping("solr")
@Controller
public class SolrController {

	@Autowired
	private SolrService solrService;
	
	@RequestMapping("getsolrList")
	@ResponseBody
	public PageModel<ZhiweiLittle> getSolrList(String searchName,Integer pageNow,PageModel pageModel) throws Exception {

		ZhiweiLittle zhiweiLittle = new ZhiweiLittle();
		if(pageNow ==null) {
			pageNow=1;
		}
		zhiweiLittle.setName(searchName);

		PageModel<ZhiweiLittle> solrlist=	solrService.getSolrList(pageModel,zhiweiLittle);
		
	   return  solrlist; 
	   
	}
	@RequestMapping("delete")
	public void deletesolr(String id ) {
		
		solrService.deletesolr(id);
	}
	@RequestMapping("addsolr")
	public void addsolr(String id ) {
		ZhiweiLittle productAndCate = new ZhiweiLittle();
		productAndCate.setId(3);
//		productAndCate.setP_specifications("周录军111111");
//		productAndCate.setP_statues("合格");
//		productAndCate.setP_unit("sss");
//		productAndCate.setPid(4);
//		productAndCate.setProduct_category("帅哥");
//		productAndCate.setProduct_name("天路");
//		productAndCate.setProduct_price(888.88F);
//		productAndCate.setRemarks("hkahkahd");
		solrService.addsolr(productAndCate);
		
		 
	}
}
