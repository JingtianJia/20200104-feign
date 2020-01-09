package com.jia.utils;

import java.util.Random;

public class FileNameUtil {
    /**
     * 所有文件名都必须是随机数+时间戳+id
     * @return
     */
    public static String getFileName(Long id) {
        long currentTimeMillis = System.currentTimeMillis();
        Random random = new Random();
        int randomNum = random.nextInt(999);
        String format = String.format("%03d", randomNum);
        return id+currentTimeMillis+format;
    }
}
