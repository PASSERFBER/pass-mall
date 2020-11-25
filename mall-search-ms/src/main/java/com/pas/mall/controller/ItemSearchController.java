package com.pas.mall.controller;

import com.pas.mall.service.ItemSearchService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/search-ms")
public class ItemSearchController {

    @Autowired
    private ItemSearchService itemSearchService;

    @PostMapping("/search")
    public Map search(@RequestBody Map searchMap){
        System.out.println(searchMap);
        return itemSearchService.search(searchMap);
    }


}
