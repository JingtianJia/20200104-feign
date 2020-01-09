package com.jia.controller;

import com.jia.service.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class UploadController {
    @Autowired
    private IUploadService uploadService;
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file){
        return uploadService.upload(file);
    }
    @ResponseBody
    @PostMapping("/uploadAjax")
    public Map<String, Object> uploadAjax(@RequestParam("file") MultipartFile file){

        return uploadService.uploadAjax(file);
    }
}
