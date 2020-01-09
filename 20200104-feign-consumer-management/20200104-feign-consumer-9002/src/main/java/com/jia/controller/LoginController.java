package com.jia.controller;

import com.jia.model.User;
import com.jia.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private ILoginService loginService;
    @GetMapping("/")
    public String turnRegisterPage(){
        return loginService.turnRegisterPage();
    }

    @PostMapping("/doRegister")
    public String doRegister(@RequestParam("username") String username,@RequestParam("password") String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return loginService.doRegister(user);
    }

    @PostMapping("/doLogin")
    public String doLogin(@RequestParam("username") String username,@RequestParam("password") String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return loginService.doLogin(user);
    }
}
