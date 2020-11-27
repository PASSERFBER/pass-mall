package com.pas.mall.controller;


import com.pas.mall.entity.RespBean;
import com.pas.mall.pojo.TbGoods;
import com.pas.mall.pojo.TbItemCat;
import com.pas.mall.pojogroup.Goods;
import com.pas.mall.service.GoodsService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("查询所有ItemCat")
    @GetMapping("/findItemCat")
    public List<TbItemCat> findItemCat(){
        return goodsService.findItemCat();
    }
    @ApiOperation("根据id删除商品")
    @GetMapping("/delete")
    public RespBean delete(Long[] ids){
        goodsService.delete(ids);
        return RespBean.ok("删除成功");
    }

}
