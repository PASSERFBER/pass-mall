package com.pas.mall.service.impl;

import com.pas.mall.mapper.BrandMapper;
import com.pas.mall.pojo.Brand;
import com.pas.mall.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAllBrand(){
        return brandMapper.selectByExample(null);
    }

    @Override
    public Brand findBrandId(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void addBrand(Brand brand) {
        brandMapper.insert(brand);

    }

    @Override
    public void updateBrand(Brand brand) {
        brandMapper.updateByPrimaryKey(brand);

    }

    @Override
    public void deleteBrand(int[] ids) {
        for (int id:ids) {
            brandMapper.deleteByPrimaryKey((long) id);
        }
    }

    @Override
    public List<Map> selectOptionList() {
        return brandMapper.selectOptionList();
    }


}
