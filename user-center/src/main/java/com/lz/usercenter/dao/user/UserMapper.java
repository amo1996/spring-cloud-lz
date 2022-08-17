package com.lz.usercenter.dao.user;

import com.lz.usercenter.domain.entity.user.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface UserMapper extends Mapper<User> {
}