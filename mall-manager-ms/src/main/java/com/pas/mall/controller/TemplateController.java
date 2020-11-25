package com.pas.mall.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pas.mall.entity.RespBean;
import com.pas.mall.entity.ResultPage;
import com.pas.mall.pojo.TbTypeTemplate;
import com.pas.mall.service.TemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "TemplateController",description = "模板后端管理")
@RestController
@RequestMapping("/Template-Ms")
public class TemplateController {
    @Autowired
    private TemplateService templateService;

    @ApiOperation("查询所有的模板")
    @GetMapping("/findAll")
    public List<TbTypeTemplate> findAllTemplate(){
        System.out.println("查询成功");
        return templateService.findAllTemplate();
    }

    @ApiOperation("根据id查询模板")
    @GetMapping("/findOne/{id}")
    public TbTypeTemplate findOneTemplate(@PathVariable Long id){
        System.out.println("根据id查询成功");
        return templateService.findOne(id);
    }

    @ApiOperation("添加模板")
    @PostMapping("/add")
    public RespBean addTemplate(@RequestBody TbTypeTemplate tbTypeTemplate){
        System.out.println("添加成功");
        templateService.addTemplate(tbTypeTemplate);
        return RespBean.ok("添加成功");
    }

    @ApiOperation("根据id修改模板")
    @PostMapping("/update")
    public RespBean updateTemplate(@RequestBody TbTypeTemplate tbTypeTemplate){
        System.out.println("修改成功");
        templateService.updateTemplate(tbTypeTemplate);
        return RespBean.ok("修改成功");
    }
    @ApiOperation("根据id删除模板")
    @GetMapping("/delete")
    public RespBean deleteTemplate(Long[] ids){
        System.out.println("删除成功");
        templateService.deleteTemplate(ids);
        return RespBean.ok("删除成功");
    }

    @ApiOperation("查询模板分页")
    @GetMapping("/findPage")
    public ResultPage findPage(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page<TbTypeTemplate> page = (Page<TbTypeTemplate>) templateService.findAllTemplate();

        ResultPage resultPage = new ResultPage();
        resultPage.setRows(page.getResult());
        resultPage.setTotal(page.getTotal());
        System.out.println(resultPage);
        return resultPage;

    }
}
