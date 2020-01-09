package com.jia.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * 使用ftp实现文件上传的工具类
 */
public class FtpUtil {
    public static boolean uploadFile(String host, Integer port, String username, String password, String basePath, String filePath, String fileName, InputStream inputStream){
        String tempPath = "";
        FTPClient ftp=new FTPClient();
        try {
            int reply;
            ftp.connect(host,port);
            ftp.login(username,password);
            //如果连接成功并且登录成功，返回的状态码为230(200-230)，如果失败，返回的状态码为503(500-600)
            reply = ftp.getReplyCode();
            if(!FTPReply.isPositiveCompletion(reply)){
                ftp.disconnect();
                return false;
            }
            //检测传入的目录是否存在
            if(!ftp.changeWorkingDirectory(basePath+filePath)){
                String[] filePathArray = filePath.split("/");
                tempPath = basePath;
                for (String dir : filePathArray) {
                    if (null == dir || "".equals(dir)) {
                        continue;
                    }
                    tempPath += "/" + dir;
                    if (!ftp.changeWorkingDirectory(tempPath)) {
                        if (!ftp.makeDirectory(tempPath)) {
                            return false;
                        } else {
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            if (!ftp.storeFile(fileName, inputStream)) {
                return false;
            }
            inputStream.close();
            ftp.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
