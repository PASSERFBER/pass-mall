package com.pas.mall.service;


import com.pas.mall.pojo.TbSpecification;
import com.pas.mall.pojogroup.Specification;

import java.util.List;
import java.util.Map;


public interface SpecificationService {

    public List<TbSpecification> findAll();
    public void add(Specification specification);
    public void update(Specification specification);
    public Specification findOne(Long id);
    public void delete(Long[] ids);
    public List<Map> selectOptionList();
}
