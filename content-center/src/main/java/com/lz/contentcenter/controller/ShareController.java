package com.lz.contentcenter.controller;


import com.lz.contentcenter.domain.dto.content.ShareDTO;
import com.lz.contentcenter.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shares")
public class ShareController {

    @Autowired
    private ShareService shareService;


    @GetMapping("/{id}")
    public ShareDTO findById(@PathVariable Integer id){
       return  shareService.findById(id);
    }

    @GetMapping("/test/{id}")
    public String findTest(@PathVariable Integer id){
        return  shareService.findTest(id);
    }


}
