package com.pas.mall.service.impl;

import com.alibaba.fastjson.JSON;
import com.pas.mall.mapper.TbItemCatMapper;
import com.pas.mall.mapper.TbSpecificationOptionMapper;
import com.pas.mall.mapper.TbTypeTemplateMapper;
import com.pas.mall.pojo.TbItemCat;
import com.pas.mall.pojo.TbSpecificationOption;
import com.pas.mall.pojo.TbSpecificationOptionExample;
import com.pas.mall.pojo.TbTypeTemplate;
import com.pas.mall.service.TemplateService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TbTypeTemplateMapper tbTypeTemplateMapper;

    @Autowired
    private TbSpecificationOptionMapper tbSpecificationOptionMapper;

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TbTypeTemplate> findAllTemplate() {
        return tbTypeTemplateMapper.selectByExample(null);
    }

    @Override
    public void addTemplate(TbTypeTemplate tbTypeTemplate) {
        tbTypeTemplateMapper.insert(tbTypeTemplate);
    }

    @Override
    public void updateTemplate(TbTypeTemplate tbTypeTemplate) {
        tbTypeTemplateMapper.updateByPrimaryKey(tbTypeTemplate);
    }

    @Override
    public void deleteTemplate(Long[] ids) {
        for (Long id:ids) {
            tbTypeTemplateMapper.deleteByPrimaryKey(id);
        }

    }

    @Override
    public TbTypeTemplate findOne(Long id) {
        return tbTypeTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Map> findSpecList(Long id) {
        TbTypeTemplate tbTypeTemplate = tbTypeTemplateMapper.selectByPrimaryKey(id);
        List<Map> list = JSON.parseArray(tbTypeTemplate.getSpecIds(),Map.class); //将json字符串转化为json对象
        for (Map map:list) {
            TbSpecificationOptionExample example = new TbSpecificationOptionExample();
            TbSpecificationOptionExample.Criteria criteria = example.createCriteria();
            criteria.andSpecIdEqualTo(new Long((Integer)map.get("id")));//{"id":27,"text":"网络"}

            List<TbSpecificationOption> specOptionList = tbSpecificationOptionMapper.selectByExample(example);

            map.put("options",specOptionList);
        }

        System.out.println(list);
        return list;
    }


}
