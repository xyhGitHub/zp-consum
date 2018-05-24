package com.four.controller;

import com.alibaba.fastjson.JSONObject;
import com.four.model.Company;
import com.four.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("Company")
public class CompanyController {
	@Autowired
	private CompanyService CompanyService;
	
	@RequestMapping("queryCompany")
	@ResponseBody
	public  Object queryCompany(Company Company,Integer  page,Integer  rows) {
		JSONObject json = CompanyService.queryCompany(Company, rows, page);
		return json;
	}
	//新增
	@RequestMapping("insertCompany")
	@ResponseBody
	public  Object insertCompany(Company Company) {
		int n = CompanyService.insertCompany(Company);
		return n;
	}
	
	//删除
	@RequestMapping("deleteCompanyByIds")
	@ResponseBody
	public Integer deleteCompanyByIDs(String ids){
		return CompanyService.deleteCompanyByIDs(ids);
	}
	//审核
	@RequestMapping("updateCompanyById")
	@ResponseBody
	public Integer updateCompanyById(Integer companyid){
		return CompanyService.updateCompanyById(companyid);
	}
	
	@RequestMapping("toCompanyAdd")
	public  String toCompanyAdd() {
		return "CompanyAdd";
	}
	@RequestMapping("toCompanyList")
	public  String toCompanyList() {
		return "companyList";
	}
}
