package com.four.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Administrator on 2018/5/17.
 */
public interface IOssService {
    String saveFile(MultipartFile file) throws Exception;
}
