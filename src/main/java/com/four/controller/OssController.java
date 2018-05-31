package com.four.controller;

import com.four.service.IOssService;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/17.
 */
@Controller
@RequestMapping("ossController")
public class OssController {

    @Autowired
    private IOssService ossService;

    @RequestMapping("saveFile")
    @ResponseBody
    public Map<String, Object> saveFile(HttpServletRequest request,@RequestParam(value = "files")MultipartFile file) throws Exception {
        Map<String, Object> value = new HashMap<String, Object>();
        value.put("success", true);
        value.put("errorCode", 0);
        value.put("errorMsg", "");
        try {
            String head = ossService.saveFile(file);//此处是调用上传服务接口，4是需要更新的userId 测试数据。
            value.put("data", head);
        } catch (IOException e) {
            e.printStackTrace();
            value.put("success", false);
            value.put("errorCode", 200);
            value.put("errorMsg", "图片上传失败");
        }
        return value;
    }








}
