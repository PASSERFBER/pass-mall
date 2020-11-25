package com.pas.mall.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pas.mall.entity.RespBean;
import com.pas.mall.entity.ResultPage;
import com.pas.mall.pojo.TbSpecification;
import com.pas.mall.pojogroup.Specification;
import com.pas.mall.service.SpecificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@Api(tags = "SpecificationController",description = "规格后端管理")
@RestController
@RequestMapping("/specification-Ms")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;


    @ApiOperation("查询所有规格信息")
    @GetMapping("/findAllSpecification")
    public List<TbSpecification> findAll(){
        System.out.println(specificationService.findAll());
        return specificationService.findAll();
    }


    @ApiOperation("根据Id查询相关信息")
    @GetMapping("/findOneSpecification/{id}")
    public Specification findOne(@PathVariable Long id){
        System.out.println(id+"在这里呢");
        return specificationService.findOne(id);

    }

    @ApiOperation("添加规格信息")
    @PostMapping("/addSpecification")
    public RespBean add(@RequestBody Specification specification){
        try{
            specificationService.add(specification);
            System.out.println("添加成功了"+specification);
            return RespBean.ok("添加成功");
        }catch (Exception e){
            e.printStackTrace();
            return RespBean.error("添加失败");

        }
    }
    @ApiOperation("根据id修改相关规格信息")
    @PostMapping("/updateSpecification")
    public RespBean update(@RequestBody Specification specification){
        System.out.println("更新在这里呢");
        try {
            specificationService.update(specification);
            System.out.println("更新成功了" +specification);
            return RespBean.ok("修改成功");
        }catch (Exception e){
            return RespBean.error("修改失败");
        }
    }

    @ApiOperation("批量删除规格相关数据")
    @GetMapping("/deleteSpecification")
    public RespBean delete(Long [] ids){
        try {
            specificationService.delete(ids);
            System.out.println(ids);
            return RespBean.ok("删除成功");
        }catch (Exception e){
            return RespBean.error("删除失败");
        }
    }

    @ApiOperation("查询规格的分页信息")
    @GetMapping("/findSpecificationPage")
    public ResultPage findSpecificationPage(int pageNum,int pageSize){

        PageHelper.startPage(pageNum,pageSize);
        Page<TbSpecification> page = (Page<TbSpecification>) specificationService.findAll();

        ResultPage resultPage = new ResultPage();
        resultPage.setRows(page.getResult());
        resultPage.setTotal(page.getTotal());
        System.out.println(resultPage);
        return resultPage;
    }

    @ApiOperation("下拉列表的内容")
    @GetMapping("/selectOptionList")
    public List<Map> findOptionList(){
        return  specificationService.selectOptionList();
    }

}
