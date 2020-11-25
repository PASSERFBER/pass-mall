package com.pas.mall.controller;


import com.pas.mall.pojo.TbGoods;
import com.pas.mall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
