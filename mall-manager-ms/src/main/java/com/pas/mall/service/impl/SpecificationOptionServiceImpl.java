package com.pas.mall.service.impl;

import com.pas.mall.mapper.TbSpecificationOptionMapper;
import com.pas.mall.pojo.TbSpecificationOption;
import com.pas.mall.service.SpecificationOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificationOptionServiceImpl implements SpecificationOptionService {

    @Autowired
    private TbSpecificationOptionMapper specificationOptionMapper;
    @Override
    public List<TbSpecificationOption> findAll() {
        return specificationOptionMapper.selectByExample(null);
    }

    @Override
    public void add(TbSpecificationOption specificationOption) {
        specificationOptionMapper.insert(specificationOption);
    }

    @Override
    public void update(TbSpecificationOption specificationOption) {
        specificationOptionMapper.updateByPrimaryKey(specificationOption);

    }

    @Override
    public TbSpecificationOption findOne(Long id) {
        return specificationOptionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids) {
            specificationOptionMapper.deleteByPrimaryKey(id);
        }

    }
}
