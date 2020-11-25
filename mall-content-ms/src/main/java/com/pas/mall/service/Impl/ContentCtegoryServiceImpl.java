package com.pas.mall.service.Impl;

import com.pas.mall.mapper.TbContentCategoryMapper;
import com.pas.mall.pojo.TbContentCategory;
import com.pas.mall.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentCtegoryServiceImpl implements ContentCategoryService {

    @Autowired
    private TbContentCategoryMapper tbContentCategoryMapper;
    @Override
    public List<TbContentCategory> findAll() {
        return tbContentCategoryMapper.selectByExample(null);
    }
}
