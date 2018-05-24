package com.four.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUtil {
	
	private static final String url = "upload";
	
	/**
	 * �ϴ��ļ�����
	 * @param file �ϴ����ļ�
	 * @param request request����
	 * @return
	 */
	public static String FileUpload(CommonsMultipartFile file, HttpServletRequest request){
		//�����ļ���Ŀ��Ŀ¼
		String savePath = request.getSession().getServletContext().getRealPath(url);
//		String savePath = request.getSession().getServletContext().getRealPath(url);
		
		//��ȡԴ�ļ���׺���
		//12345.jpg
		int suffixIndex = file.getOriginalFilename().lastIndexOf(".");
		//  .jpg
		String suffixName = file.getOriginalFilename().substring(suffixIndex);
		
		//����µ��ļ���ƣ�ԭ�򣺷�ֹ�ļ����һ������ϴ����ļ��Ḳ��ǰ���ϴ����ļ���ǰ�����ļ���Ʊ���һ��������һ��Ŀ¼�£�
		//����µ��ļ���ƣ���֤�ļ����Ψһ�����ַ�����
		// 	  1.ͨ��UUIDʵ���ļ����Ψһ ��UUID�����32λ��ĸ+����Ψһ��һ���ַ�
		//	  2.ͨ��ʱ������ļ����Ψһ  ��ʱ����Ǻ��뼶ʱ�� ʱ���һֱ���ϼӣ����13λ���֣�ע��ֻ��java���13λ ��������10λ����oracle��mysql��php
		//  ��ȡʱ���
		//long currentTimeMillis = System.currentTimeMillis();
		//System.out.println(currentTimeMillis);
		
		String newFileName = UUID.randomUUID().toString().replace("-", "") + suffixName;
		
		//���Ŀ��Ŀ¼�Ƿ����
		File targetFile = new File(savePath, newFileName);
		if(!targetFile.exists()){
			//����Ŀ��Ŀ¼
			targetFile.mkdirs();
		}
		
		try {
			// ʹ��transferTo��dest���������ϴ��ļ�д����������ָ�����ļ���
			file.transferTo(targetFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newFileName;
	}
	
	/**
	 * �ļ����ط���
	 * @param fileName �ļ����
	 * @param request request����
	 * @return
	 */
	public static ResponseEntity<byte[]> FileDownload(String fileName, HttpServletRequest request){

		ResponseEntity<byte[]> entity = null;
		
		//��ȡԴ�ļ���ַ
		String sourceUrl = request.getSession().getServletContext().getRealPath(fileName);
		
		//��ȡԴ�ļ�
		File sourceFile = new File(sourceUrl);
		
		//����ͷ����Ϣ���ļ���Ϣ�����ļ���ƺ������ļ����ͣ�
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", fileName.substring(7));
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		
		//�ļ�����
		try {
			entity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(sourceFile), headers, HttpStatus.CREATED);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return entity;
	}

}
