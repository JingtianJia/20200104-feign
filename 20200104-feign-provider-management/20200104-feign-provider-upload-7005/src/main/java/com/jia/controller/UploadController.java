package com.jia.controller;

import com.jia.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;
    @Autowired
    private HttpSession session;
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file){
        Map<String, Object> resultMap = uploadService.upload(file, session);
        if ("200".equals(resultMap.get("code"))) {
            String headPic =(String) resultMap.get("data");
            return "success";
        }
        return "404";
    }
    @ResponseBody
    @PostMapping("/uploadAjax")
    public Map<String, Object> uploadAjax(@RequestParam("file") MultipartFile file){
        return uploadService.upload(file, session);
    }
}
