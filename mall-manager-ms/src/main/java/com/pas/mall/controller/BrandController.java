package com.pas.mall.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pas.mall.pojo.Brand;
import com.pas.mall.entity.RespBean;
import com.pas.mall.entity.ResultPage;
import com.pas.mall.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "BrandController",description = "品牌后端管理")
@RestController  //ResponseBody
@RequestMapping("/Brand-Ms")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @ApiOperation("查询所有的品牌信息")
    @GetMapping("/loadAllBrand")
    public List<Brand> loadAllBrand(){
        System.out.println(brandService.findAllBrand());
        return brandService.findAllBrand();
    }

    @ApiOperation("根据Id查找唯一品牌信息")
    @GetMapping("/loadBrandId/{id}")
    public Brand loadBrandById(@PathVariable Long id){  //@PathVariable 网址后面有个｛id｝
        System.out.println(brandService.findBrandId(id));
        return brandService.findBrandId(id);
    }

    @ApiOperation("添加品牌信息")
    @PostMapping("/addBrand")
    public RespBean addBrand(@RequestBody @ApiParam("品牌对象") Brand brand){
        try {
            brandService.addBrand(brand);
            System.out.println("在这呢，看这个："+brand);
            return RespBean.ok("添加成功");
        }catch (Exception ex){
            ex.printStackTrace();
            return RespBean.error("添加失败");

        }

    }
    @ApiOperation("根据id更新品牌信息")
    @PostMapping("/updateBrand")
    public RespBean updateBrand(@RequestBody @ApiParam("品牌对象") Brand brand){
        try {
            brandService.updateBrand(brand);
            System.out.println(brand.getId());
            System.out.println(brand.getName());

            return RespBean.ok("修改成功");
        }catch (Exception ex){
            ex.printStackTrace();
            return RespBean.error("修改失败");

        }
    }

    @ApiOperation("根据id删除品牌信息")
    @GetMapping("/deleteBrand")
    public RespBean deleteBrand(int[] ids){
        System.out.println(ids.length);
        try {
            brandService.deleteBrand(ids);
            System.out.println(ids);
            return RespBean.ok("删除成功"+ids);
        }catch (Exception ex){
            ex.printStackTrace();
            return RespBean.error("删除失败");
        }
    }

    @ApiOperation("获取品牌的分页信息")
    @GetMapping("/findByPage")
    public ResultPage findByPage(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        Page<Brand> page = (Page<Brand>) brandService.findAllBrand();

        ResultPage  resultPage = new ResultPage();
        resultPage.setRows(page.getResult());
        resultPage.setTotal(page.getTotal());

        return resultPage;
    }

    @ApiOperation("下拉列表的内容")
    @GetMapping("/selectOptionList")
    public List<Map> findOptionList(){
        return  brandService.selectOptionList();
    }

}
