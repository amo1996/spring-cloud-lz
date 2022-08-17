package com.lz.contentcenter.service;

import com.lz.contentcenter.dao.content.ShareMapper;
import com.lz.contentcenter.domain.dto.content.ShareDTO;
import com.lz.contentcenter.domain.dto.user.UserDTO;
import com.lz.contentcenter.domain.entity.content.Share;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
@Slf4j
public class ShareService {

    @Autowired
    private ShareMapper shareMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;


    public ShareDTO findById(Integer id) {
        Share share = shareMapper.selectByPrimaryKey(id);


        Integer userId = share.getUserId();
        UserDTO userDTO = userService.findById(userId);
        // UserDTO userDTO = restTemplate.getForObject("http://user-center/users/{id}", UserDTO.class, userId);
        log.info("test slf4j log:{}",userDTO);
        ShareDTO shareDTO = new ShareDTO();
        BeanUtils.copyProperties(share,shareDTO);
        shareDTO.setWxNickName(userDTO.getWxNickname());
        return shareDTO;
    }

    public String findTest(Integer id) {
      return   userService.findTest(1);

    }
}
