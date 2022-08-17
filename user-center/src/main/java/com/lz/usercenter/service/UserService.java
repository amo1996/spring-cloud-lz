package com.lz.usercenter.service;

import com.lz.usercenter.dao.user.UserMapper;
import com.lz.usercenter.domain.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;


    public User findById(Integer id){
        User user = userMapper.selectByPrimaryKey(id);

        return  user;
    }
}
