package com.four.service;

import com.alibaba.fastjson.JSONObject;
import com.four.model.Company;


public interface CompanyService {

	
	JSONObject queryCompany(Company Company, Integer rows, Integer page);

	
	int insertCompany(Company Company);


	Integer deleteCompanyByIDs(String ids);


	Integer updateCompanyById(Integer companyid);


}
