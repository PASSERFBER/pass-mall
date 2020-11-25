package com.pas.mall.controller;

import com.pas.mall.pojo.TbContentCategory;
import com.pas.mall.service.ContentCategoryService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content-ms")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @GetMapping("/findAllCategory")
    public List<TbContentCategory> findAll(){
        System.out.println("所有类别在这里呢"+contentCategoryService.findAll());
        return contentCategoryService.findAll();
    }
}
