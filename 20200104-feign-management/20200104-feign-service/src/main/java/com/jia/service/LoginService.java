package com.jia.service;

import com.jia.mapper.UserMapper;
import com.jia.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 实现注册功能
     * @param user
     * @return
     */
    public Map<String,Object> doRegister(User user){
        Map<String,Object> resultMap=new HashMap<>();
        int insert = userMapper.insert(user);
        if(insert>0){
            resultMap.put("code","200");
            resultMap.put("msg","注册成功");
        }else {
            resultMap.put("code","500");
            resultMap.put("msg","注册失败");
        }
        return resultMap;
    }

    public Map<String,Object> doLogin(User user, HttpSession session){
        Map<String,Object> resultMap=new HashMap<>();
        User u = userMapper.selectUserByUsernameAndPassword(user);
        if(null!=u){
            u.setPassword(null);
            session.setAttribute("user",u);
            resultMap.put("code","200");
            resultMap.put("msg","登录成功");
        }else {
            resultMap.put("code","500");
            resultMap.put("msg","登录失败");
        }
        return resultMap;
    }
}
