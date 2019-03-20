package com.fate.login.controller;

import com.fate.login.bean.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: fate
 * @Date: 2019/3/19 22:17
 * @Version 1.0
 */
@RestController
@RequestMapping("my")
public class LoginController {

    @RequestMapping("login")
    public String login(@RequestBody User user) {
        System.out.println("hello--------------" + user);
        return "login";
    }
}
