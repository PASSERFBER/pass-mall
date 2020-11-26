package com.pas.mall.controller;


import com.pas.mall.pojo.TbGoods;
import com.pas.mall.pojo.TbItemCat;
import com.pas.mall.pojogroup.Goods;
import com.pas.mall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods-ms")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/findAll")
    public List<TbGoods> findAll(){
        return goodsService.findAll();
    }

    @PostMapping("/add")
    public void addGoods(@RequestBody Goods goods){
        goodsService.add(goods);
    }

    @GetMapping("/findByParentId/{parentId}")
    public List<TbItemCat> findByParentId(@PathVariable Long parentId){
        System.out.println(parentId);
        return goodsService.findByCateGoryId(parentId);
    }

    @GetMapping("/findTemplateId/{id}")
    public TbItemCat findTemplateId(@PathVariable Long id){
        return goodsService.findTemplateId(id);
    }

}
