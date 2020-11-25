package com.pas.mall.controller;

import com.pas.mall.entity.RespBean;
import com.pas.mall.pojo.TbContent;
import com.pas.mall.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //相当于Responsebody
@RequestMapping("/content-ms")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @GetMapping("/findAll")
    public List<TbContent> findAll(){
        return contentService.findAll();
    }

    @GetMapping("/findOne/{id}")
    public TbContent findOne(@PathVariable Long id){
        return contentService.findOne(id);
    }

    @PostMapping("/add")
    public RespBean add(@RequestBody TbContent tbContent){
        contentService.add(tbContent);
        return RespBean.ok("添加成功");
    }

    @PostMapping("/update")
    public RespBean update(@RequestBody TbContent tbContent){
        contentService.update(tbContent);
        return RespBean.ok("修改成功");
    }

    @GetMapping("/delete")
    public RespBean deleteContent(Long[] ids){
        contentService.delete(ids);
        return RespBean.ok("删除成功");
    }

    @GetMapping("/findCategoryById/{categoryId}")
    public List<TbContent> findCategoryById(@PathVariable Long categoryId){
        return contentService.findCategoryById(categoryId);
    }
}
