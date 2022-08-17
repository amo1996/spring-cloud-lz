package com.lz.contentcenter.service;


import com.lz.contentcenter.domain.dto.user.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
@FeignClient(name="user-center",path="users")
public interface UserService {


    @RequestMapping ("/{id}")
    public UserDTO findById(@PathVariable(name = "id")Integer id) ;


    @RequestMapping ("/test/{id}")
    public String findTest(@PathVariable(name = "id") Integer id) ;


}
