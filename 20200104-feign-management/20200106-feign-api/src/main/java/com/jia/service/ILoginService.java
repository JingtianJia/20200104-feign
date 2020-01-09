package com.jia.service;

import com.jia.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
@FeignClient(value = "LOGIN-PROVIDER")
public interface ILoginService {
    @GetMapping("/")
    String turnRegisterPage();

    /**
     * 执行注册操作
     * @param user
     * @return
     */
    @PostMapping("/doRegister")
    String doRegister(@RequestBody User user);
    /**
     * 执行登录操作
     * @param user
     * @return
     */
    @PostMapping("/doLogin")
    String doLogin(@RequestBody User user);
}
