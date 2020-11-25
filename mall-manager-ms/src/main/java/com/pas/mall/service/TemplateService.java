package com.pas.mall.service;

import com.pas.mall.pojo.TbTypeTemplate;

import java.util.List;

public interface TemplateService {
    public List<TbTypeTemplate> findAllTemplate();
    public void addTemplate(TbTypeTemplate tbTypeTemplate);
    public void updateTemplate(TbTypeTemplate tbTypeTemplate);
    public void deleteTemplate(Long[] ids);
    public TbTypeTemplate findOne(Long id);


}
