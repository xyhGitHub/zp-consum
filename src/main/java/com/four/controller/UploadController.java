/**
 * Copyright (C), 2018-2018, jk有限公司
 * FileName: UploadController
 * Author:  常路通
 * Date:     2018/5/16 15:32
 * Description: 上传文件控制层
 * /**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: UploadController
 * Author:   chang
 * Date:     2018/5/16 15:32
 * Description: 上传文件控制层
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.four.controller;

import com.aliyun.oss.OSSClient;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br> 
 * 〈上传文件控制层〉
 *
 * @author chang
 * @create 2018/5/16
 * @since 1.0.0
 */
@Controller
@RequestMapping("uploadController")
public class UploadController {

    @RequestMapping("uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam("image")MultipartFile multiFile, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String newFileName = UUID.randomUUID().toString()
                + multiFile.getOriginalFilename().substring(multiFile.getOriginalFilename().lastIndexOf("."));
        System.out.println(newFileName);
        ServletContext sc = request.getSession().getServletContext();
        String dir = sc.getRealPath("/upload");//附件存放服务器的路径
        System.out.println(dir);
        CommonsMultipartFile cf= (CommonsMultipartFile)multiFile;
        DiskFileItem fi = (DiskFileItem)cf.getFileItem();
        File f = fi.getStoreLocation();
        // endpoint以杭州为例，其它region请按实际情况填写
        String endpoint = "http://oss-cn-qingdao.aliyuncs.com";
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录
        // https://ram.console.aliyun.com 创建
        String accessKeyId = "LTAIIovLWtlvaZb1";
        String accessKeySecret = "9a75CNmDE3W705XEREa9RCpXNdx91D";
        // 创建OSSClient实例
        // OSSClient是OSS服务的Java客户端，它为调用者提供了一系列的方法，用于和OSS服务进行交互。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        FileInputStream fis = new FileInputStream(f);
        ossClient.putObject("djh535212936", "img/" + newFileName, fis);
        Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000 * 24 * 9);
        URL url = ossClient.generatePresignedUrl("djh535212936", "img/" + newFileName, expiration);
        String fileUrl = url.toString();
        System.out.println("成功");
        System.out.println(fileUrl);
        return fileUrl;

    }
}