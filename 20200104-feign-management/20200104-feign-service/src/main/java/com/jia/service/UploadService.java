package com.jia.service;

import com.jia.config.FtpProperties;
import com.jia.mapper.UserMapper;
import com.jia.model.User;
import com.jia.utils.FileNameUtil;
import com.jia.utils.FtpUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Service
public class UploadService {
    @Autowired
    private FtpProperties ftpProperties;
    @Autowired
    private UserMapper userMapper;
    public Map<String,Object> upload(MultipartFile file, HttpSession session) {
        Map<String, Object> resultMap = new HashMap<>();
        String originalFilename = file.getOriginalFilename();
        try {
            User user = (User) session.getAttribute("user");
            String newName = FileNameUtil.getFileName(user.getId());
            newName = newName + originalFilename.substring(originalFilename.lastIndexOf("."));
            String filePath = new DateTime().toString("yyyy/MM/dd");
            boolean ifSuccess = FtpUtil.uploadFile(ftpProperties.getIpAddr(), ftpProperties.getPort(), ftpProperties.getUsername(), ftpProperties.getPassword(), ftpProperties.getBasePath(), filePath, newName, file.getInputStream());
            if (ifSuccess) {
                User u = new User();
                u.setId(user.getId());
                String headPic = ftpProperties.getHttpPath() + "/" + filePath + "/" + newName;
                u.setHeadPic(headPic);
                u.setOriginalName(originalFilename);
                u.setNewName(newName);
                Integer updateResult = userMapper.updateHeadPicById(u);
                if (updateResult > 0) {
                    resultMap.put("code", "200");
                    resultMap.put("msg", "上传成功");
                    resultMap.put("data", headPic);
                } else {
                    resultMap.put("code", "500");
                    resultMap.put("msg", "图片路径更新失败");
                }
            } else {
                resultMap.put("code", "500");
                resultMap.put("msg", "上传失败");
            }
        } catch (IOException e) {
            resultMap.put("code", "500");
            resultMap.put("msg", "上传失败");
            e.printStackTrace();
        }
        return resultMap;
    }
}
