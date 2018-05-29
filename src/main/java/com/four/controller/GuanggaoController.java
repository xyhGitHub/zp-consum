package com.four.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.four.model.GuangGao;
import com.four.service.GuanggaoService;
import com.four.utils.ExportExcel;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value="/guanggaoController")
public class GuanggaoController {

	@Autowired
	private GuanggaoService guanggaoService;

	//查询广告方法
	@RequestMapping("queryGuangGao")
	@ResponseBody
	public String queryGuangGao(Integer offset, Integer limit) throws Exception {
		JSONObject json = guanggaoService.queryGuangGao(offset, limit);
		System.out.println(json);
		return JSON.toJSONString(json);
	}

	//查询前台显示广告方法
	@RequestMapping("queryGuangGaoQianTai")
	@ResponseBody
	public String queryGuangGaoQianTai() throws Exception {
		List<GuangGao> list = guanggaoService.queryGuangGaoQianTai();

		return JSON.toJSONString(list);
	}

	//测试网络是否可用
	@RequestMapping("testGuangGaoAddress")
	@ResponseBody
	public String testGuangGaoAddress(String guangGaoAddess) throws IOException {
		int i = 0;
		System.out.println(guangGaoAddess);
		String trim = guangGaoAddess.trim();
		HttpClient httpClient = new HttpClient();
		GetMethod getMethod = new GetMethod(trim);
		i = httpClient.executeMethod(getMethod);
		if (i == 200) {
			return JSON.toJSONString(i);
		} else {
			return null;
		}
	}

	//跳转修改的页面
	@RequestMapping("toupdateGuanggao")
	public String toupdateGuanggao(Integer id, HttpServletRequest request) {
		GuangGao guangGao = new GuangGao();
		guangGao.setGuangGaoId(id);
		GuangGao guangGao1 = guanggaoService.queryGuangGaoById(guangGao);
		request.setAttribute("guanggao", guangGao1);
		return "updateGuangGao";
	}


	//oss阿里云文件上传
	@RequestMapping("saveGuangGaoPhotoByModel")
	@ResponseBody
	public Object uploadFile(@RequestParam(value = "guangGaoPhotoOss", required = false) MultipartFile guangGaoPhotoOss,
							 HttpServletRequest request) throws IOException {
//		JSON json = new JSONObject();
		String filename = guangGaoPhotoOss.getOriginalFilename();
		System.out.println(filename);
		//通过UUID给前台传过来的文件名重命名
		String newFileName = UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
		// endpoint以杭州为例，其它region请按实际情况填写
		String endpoint = "http://oss-cn-beijing.aliyuncs.com";
		// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
		String accessKeyId = "LTAIjOIBklvwvdMy";
		String accessKeySecret = "8669ZS7Z5sA4VuH5PYzzdK1cmQ0aut";
		// 创建OSSClient实例
		//OSSClient是OSS服务的Java客户端，它为调用者提供了一系列的方法，用于和OSS服务进行交互。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		File f = null;
		try {
			f = File.createTempFile("tmp", null);
			guangGaoPhotoOss.transferTo(f);
			//网上的请求完毕删除缓冲区
			f.deleteOnExit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		FileInputStream fis = new FileInputStream(f);
		ossClient.putObject("lwsoss", "img/" + newFileName, fis);
		//过期时间
		Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000 * 24 * 15);
		URL url = ossClient.generatePresignedUrl("lwsoss", "img/" + newFileName, expiration);
		String fileUrl = url.toString();
		System.out.println(fileUrl);
		ossClient.shutdown();
		fis.close();
		//删除缓冲区
		f.delete();
		return JSON.toJSONString(fileUrl);
	}

	//oss文件下载  需要将oss完整的路径传过来
	@RequestMapping("downFile")
	public void downFile(String fileUrl, HttpServletResponse response) throws IOException {
		// endpoint以为例，其它region请按实际情况填写
		String endpoint = "http://oss-cn-beijing.aliyuncs.com";
		// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
		String accessKeyId = "LTAIjOIBklvwvdMy";
		String accessKeySecret = "8669ZS7Z5sA4VuH5PYzzdK1cmQ0aut";
		// 创建OSSClient实例
		//OSSClient是OSS服务的Java客户端，它为调用者提供了一系列的方法，用于和OSS服务进行交互。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
		String url = fileUrl.substring(fileUrl.lastIndexOf("img"));
		int i = url.indexOf("?");
		String keyname = url.substring(0, i);
		OSSObject ossObject = ossClient.getObject("lwsoss", keyname);
		//以流的方式读取存储空间里的文件
		BufferedInputStream in = new BufferedInputStream(ossObject.getObjectContent());
//		HttpServletResponse response = ServletActionContext.getResponse();
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		// 设置response参数，可以打开下载页面
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(keyname, "utf-8"));
		byte[] car = new byte[1024];
		int L = 0;
		while ((L = in.read(car)) != -1) {
			out.write(car, 0, L);
		}
		if (out != null) {
			out.flush();
			out.close();
		}
		if (in != null) {
			in.close();
		}
		ossClient.shutdown();
	}

	//修改的保存
	@RequestMapping("updateGuangGaoById")
	@ResponseBody
	public void updateGuangGaoById(GuangGao guangGao) throws Exception {
		guanggaoService.updateGuangGaoById(guangGao);
	}

	//广告的保存
	@RequestMapping("saveGuangGaoByModel")
	@ResponseBody
	public String saveGuangGaoByModel(GuangGao guangGao) {
//		GuangGao guangGao = new GuangGao();
//		guangGao.setGuangGaoId(1);
//		guangGao.setGuangGaoName("大头");
//		guangGao.setGuangGaoShuoMing("还是敲代码的收获多");
		guanggaoService.saveGuangGaoByModel(guangGao);
		return "addDataSuccess";
	}

	//删除广告
	@RequestMapping("deleteGuangGao")
	@ResponseBody
	public String deleteGuangGao(String guangGao) throws Exception {
//		String guangGao = "1,2";

		guanggaoService.deleteGuangGao(guangGao);
		return "deleteDataSuccess";

	}


	//导出excel
	@RequestMapping("ExceportExcel")
	@ResponseBody
	public void ExceportExcel( HttpServletResponse response) {

		String title = "广告POI导出";

		String[] rowName = {"ID", "广告名称", "广告说明", "广告开始时间", "广告结束时间","广告图片","广告价格", "广告位序号", "广告官网", "广告长度", "广告宽度", "广告上架状态"};
		List<Object[]> dataList = new ArrayList<Object[]>();
		List<GuangGao> roleManager = guanggaoService.guangGaoManager();
		System.out.println(roleManager);
		Object []  obj= null;
		System.out.println(roleManager.size());
		for (int i = 0; i < roleManager.size(); i++) {
			obj = new Object[rowName.length];
			obj[0] = roleManager.get(i).getGuangGaoId();
			obj[1] = roleManager.get(i).getGuangGaoName();
			obj[2] = roleManager.get(i).getGuangGaoShuoMing();
			obj[3] = roleManager.get(i).getGuangGaoStart();
			obj[4] = roleManager.get(i).getGuangGaoEnd();
			obj[5] = roleManager.get(i).getGuangGaoPhoto();
			obj[6] = roleManager.get(i).getGuangGaoprice();
			obj[7] = roleManager.get(i).getGuangGaoNum();
			obj[8] = roleManager.get(i).getGuangGaoGuanWang();
			obj[9] = roleManager.get(i).getGuangGaoWidth();
			obj[10] = roleManager.get(i).getGuangGaoHeight();
			obj[11] = roleManager.get(i).getGuangGaoStatus();
			dataList.add(obj);
		}
		ExportExcel exportExcel = new ExportExcel(title, rowName, dataList);
		try {
			exportExcel.export(response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
