package com.jia.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Repository
@FeignClient(value = "UPLOAD-PROVIDER")
public interface IUploadService {
    @PostMapping("/upload")
    String upload(@RequestParam("file") MultipartFile file);

    @ResponseBody
    @PostMapping("/uploadAjax")
    Map<String, Object> uploadAjax(@RequestParam("file") MultipartFile file);
}
