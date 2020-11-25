package com.pas.mall.service;

import com.pas.mall.pojo.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {
    public List<Brand> findAllBrand();
    public Brand findBrandId(Long id);
    public void addBrand(Brand brand);
    public void updateBrand(Brand brand);
    public void deleteBrand(int[] ids);
    public List<Map> selectOptionList();
}
