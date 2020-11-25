package com.pas.mall.service;

import com.pas.mall.entity.ResultPage;
import com.pas.mall.pojo.TbContent;

import java.util.List;

public interface ContentService {
    public List<TbContent> findAll();
    public void update(TbContent tbContent);
    public void add(TbContent tbContent);
    public TbContent findOne(Long id);
    public void delete(Long[] ids);
    public ResultPage findPage(int pageNum, int pageSize);
    public List<TbContent> findCategoryById(Long categoryId);
}
