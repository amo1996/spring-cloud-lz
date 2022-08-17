package com.lz.contentcenter.controller;


import com.lz.contentcenter.dao.content.ShareMapper;
import com.lz.contentcenter.domain.entity.content.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class TestController {


    @Autowired
    ShareMapper  mapper;
    @GetMapping("/test")
    public List<Share> testInsert() {
    //1. 做插入
        Share share = new Share();
        share.setCreateTime(new Date());
        share.setUpdateTime(new Date());
        share.setTitle("xxx");
        share.setCover("xxx");
        share.setAuthor("lz");
        share.setBuyCount(1);
        mapper.insertSelective(share);

        // 2. 做查询  查询当前数据库所有的share
        List<Share> shares = mapper.selectAll();
        return shares;

    }


}
