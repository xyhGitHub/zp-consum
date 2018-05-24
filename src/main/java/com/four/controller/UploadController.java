package com.four.controller;

import com.four.utils.UploadFileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/uploadController")
public class UploadController {
	
	
	@RequestMapping("uploadFile")
	@ResponseBody
	public String uploadFile(@RequestParam(value="file")CommonsMultipartFile filedata
			,HttpServletRequest request) throws Exception{
	
		String upload = UploadFileUtil.upload(filedata, request);
		
		return upload;
	}
	
	

}
