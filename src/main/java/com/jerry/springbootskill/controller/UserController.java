package com.jerry.springbootskill.controller;

import com.jerry.springbootskill.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/3/22
 * Time: 16:44
 * Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setName("谭浩然");
        user.setPassword("123456");
        user.setBirthday(new Date());
        user.setAge(29);
        user.setDesc("详细描述");
        return user;
    }
}
