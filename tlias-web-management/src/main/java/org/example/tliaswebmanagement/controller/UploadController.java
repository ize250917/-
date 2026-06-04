package org.example.tliaswebmanagement.controller;

import org.example.tliaswebmanagement.pojo.Result;
import org.example.tliaswebmanagement.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    //注入工具类
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;

    /**
     * 上传文件至阿里云 OSS，并返回文件访问地址
     *
     * @param file 待上传的文件（支持图片、文档等）
     * @return 统一响应结果，包含文件可访问 URL
     * @throws Exception 上传失败时抛出异常
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
       log.info("文件上传开始{}",file.getOriginalFilename());
       //将文件交给OSS阿里云存储
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        return Result.success(url);
    }

}