package com.lz.usercenter.controller;


import com.lz.usercenter.service.UserService;
import com.lz.usercenter.dao.user.UserMapper;
import com.lz.usercenter.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/users")
public class TestController {


    @Value("${server.port}")
    private int port;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public User testInsert() {
        User user = new User();
        user.setAvatarUrl("xxx");
        user.setBonus(100);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        // insert into
        userMapper.insert(user);
        return user;
    }


    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        System.out.println("port:"+port);

        return userService.findById(id);
    }

    @RequestMapping ("/test/{id}")
    public String findTest(@PathVariable Integer id){
        return "test";
    }

}
