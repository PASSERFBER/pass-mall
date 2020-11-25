package com.pas.mall.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pas.mall.entity.ResultPage;
import com.pas.mall.mapper.TbSpecificationMapper;
import com.pas.mall.mapper.TbSpecificationOptionMapper;
import com.pas.mall.pojo.Brand;
import com.pas.mall.pojo.TbSpecification;
import com.pas.mall.pojo.TbSpecificationOption;
import com.pas.mall.pojo.TbSpecificationOptionExample;
import com.pas.mall.pojogroup.Specification;
import com.pas.mall.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SpecificationServiceImpl implements SpecificationService {

    @Autowired
    private TbSpecificationMapper specificationMapper;

    @Autowired
    private TbSpecificationOptionMapper specificationOptionMapper;
    @Override
    public List<TbSpecification> findAll() {

        return specificationMapper.selectByExample(null);
    }

    @Override
    public void add(Specification specification) {

        specificationMapper.insert(specification.getSpecification());
        System.out.println("添加在这算不算啊"+specification.getSpecification());

        for (TbSpecificationOption specificationOption : specification.getSpecificationOptionList()) {
            specificationOption.setSpecId(specification.getSpecification().getId());
            System.out.println(specificationOption);

            specificationOptionMapper.insert(specificationOption);
        }

    }

    @Override
    public void update(Specification specification) {

        System.out.println("什么错误呢，搞不懂");
        specificationMapper.updateByPrimaryKey(specification.getSpecification());

        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(specification.getSpecification().getId());
        System.out.println("修改在这算不算啊"+specification.getSpecification());

        specificationOptionMapper.deleteByExample(example);

        for (TbSpecificationOption specificationOption:specification.getSpecificationOptionList()) {
            specificationOption.setSpecId(specification.getSpecification().getId());
            specificationOptionMapper.insert(specificationOption);
        }
    }

    @Override
    public Specification findOne(Long id) {
        Specification specification = new Specification();

        TbSpecification tbSpecification = specificationMapper.selectByPrimaryKey(id);
        System.out.println(tbSpecification);
        specification.setSpecification(tbSpecification);

        TbSpecificationOptionExample example = new TbSpecificationOptionExample();
        TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
        criteria.andSpecIdEqualTo(id);
        List<TbSpecificationOption> list = specificationOptionMapper.selectByExample(example);
        specification.setSpecificationOptionList(list);
        System.out.println(list);
        System.out.println(specification);
        return specification;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids) {
            specificationMapper.deleteByPrimaryKey(id);

            TbSpecificationOptionExample example = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
            criteria.andSpecIdEqualTo(id);
            specificationOptionMapper.deleteByExample(example);

        }

    }

    @Override
    public List<Map> selectOptionList() {
        return specificationMapper.selectOptionList();
    }


}
