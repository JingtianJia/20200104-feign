package com.jia.controller;

import com.jia.model.User;
import com.jia.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private HttpSession session;
    @GetMapping("/")
    public String turnRegisterPage(){
        return "register";
    }

    /**
     * 执行注册操作
     * @param user
     * @return
     */
    @PostMapping("/doRegister")
    public String doRegister(User user){
        Map<String, Object> resultMap = loginService.doRegister(user);
        if("200".equals(resultMap.get("code"))){
            return "login";
        }else {
            return "404";
        }
    }

    /**
     * 执行登录操作
     * @param user
     * @return
     */
    @PostMapping("/doLogin")
    public String doLogin(User user){
        Map<String, Object> resultMap = loginService.doLogin(user, session);
        if("200".equals(resultMap.get("code"))){
            return "pic";
        }else {
            return "404";
        }
    }
}
