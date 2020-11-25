package com.pas.mall.service;

import com.pas.mall.pojo.TbSpecificationOption;

import java.util.List;

public interface SpecificationOptionService {
    public List<TbSpecificationOption> findAll();
    public void add(TbSpecificationOption specificationOption);
    public void update(TbSpecificationOption specificationOption);
    public TbSpecificationOption findOne(Long id);
    public void delete(Long[] ids);
}
