package com.pas.mall.service.impl;

import com.pas.mall.mapper.TbTypeTemplateMapper;
import com.pas.mall.pojo.TbTypeTemplate;
import com.pas.mall.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TbTypeTemplateMapper tbTypeTemplateMapper;

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
}
