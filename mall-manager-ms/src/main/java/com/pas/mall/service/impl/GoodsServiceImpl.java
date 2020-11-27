package com.pas.mall.service.impl;


import com.alibaba.fastjson.JSON;
import com.pas.mall.entity.RespBean;
import com.pas.mall.mapper.*;
import com.pas.mall.pojo.*;
import com.pas.mall.pojogroup.Goods;
import com.pas.mall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private TbGoodsMapper tbGoodsMapper;

    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbGoodsDescMapper tbGoodsDescMapper;
    @Autowired
    private TbItemCatMapper tbItemCatMapper;
    @Autowired
    private TbSellerMapper tbSellerMapper;
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public void add(Goods goods) {
        goods.getTbGoods().setAuditStatus("0");
        tbGoodsMapper.insert(goods.getTbGoods());

        goods.getTbGoodsDesc().setGoodsId(goods.getTbGoods().getId());
        tbGoodsDescMapper.insert(goods.getTbGoodsDesc());

        setItemList(goods);

    }

    private void setItemList(Goods goods) {
        if(goods.getTbGoods().getIsEnableSpec().equals("1")){
            //判断一下是否启用了规格
            for (TbItem item:goods.getListItem()) {
                String title = goods.getTbGoods().getGoodsName();
                Map<String,String> map = JSON.parseObject(item.getSpec(),Map.class);
                for(String key:map.keySet()){
                    title += " " + map.get(key);
                }
                item.setTitle(title);
                setItemValue(goods,item);
                tbItemMapper.insert(item);
            }
        }else{
            TbItem item = new TbItem();
            item.setTitle(goods.getTbGoods().getGoodsName());
            item.setPrice(goods.getTbGoods().getPrice());
            item.setNum(99999);
            item.setStatus("0");
            item.setIsDefault("1");
            item.setSpec("{}");

            setItemValue(goods,item);
            tbItemMapper.insert(item);
        }
    }

    private void setItemValue(Goods goods, TbItem item) {
        List<Map> imageList = JSON.parseArray(goods.getTbGoodsDesc().getItemImages(),Map.class);
        //读取上传图片的地址
        if (imageList.size()>0){
            item.setImage((String) imageList.get(0).get("url"));
        }
        //设置各种ID
        item.setCategoryid(goods.getTbGoods().getCategory3Id());
        TbItemCat tbItemCat = tbItemCatMapper.selectByPrimaryKey(goods.getTbGoods().getCategory3Id());
        item.setCategory(tbItemCat.getName());

        item.setGoodsId(goods.getTbGoods().getId());
        item.setSellerId(goods.getTbGoods().getSellerId());

        TbSeller tbSeller = tbSellerMapper.selectByPrimaryKey(goods.getTbGoods().getSellerId());
        item.setSeller(tbSeller.getName());

        Brand brand = brandMapper.selectByPrimaryKey(goods.getTbGoods().getBrandId());
        item.setBrand(brand.getName());


        item.setCreateTime(new Date());
        item.setUpdateTime(new Date());

    }

    @Override
    public List<TbGoods> findAll() {
        TbGoodsExample example = new TbGoodsExample();
        TbGoodsExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeleteIsNull();
        return tbGoodsMapper.selectByExample(example);
    }

    @Override
    public List<TbItemCat> findItemCat() {
        System.out.println(tbItemCatMapper.selectByExample(null));
        return tbItemCatMapper.selectByExample(null);
    }

    @Override
    public void update(Goods goods) {

    }

    @Override
    public Goods findOne(Long id) {
        return null;
    }

    @Override
    public void delete(Long[] ids) {
        for (Long id:ids) {
            TbGoods tbGoods = tbGoodsMapper.selectByPrimaryKey(id);
            tbGoods.setIsDelete("1");
            tbGoodsMapper.updateByPrimaryKey(tbGoods);
            System.out.println("删除成功");
        }

    }

    @Override
    public void updateStatus(Long[] ids, String status) {
        for (Long id:ids) {
            TbGoods tbGoods = tbGoodsMapper.selectByPrimaryKey(id);
            tbGoods.setAuditStatus(status);
            tbGoodsMapper.updateByPrimaryKey(tbGoods);
        }

    }

    @Override
    public TbItem findItemListByGoodsIdListAndStatus(Long[] ids, String status) {
        return null;
    }

    @Override
    public List<TbItemCat> findByCateGoryId(Long parentId) {
        TbItemCatExample tbItemCatExample = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = tbItemCatExample.createCriteria();
        criteria.andParentIdEqualTo(parentId);

        return tbItemCatMapper.selectByExample(tbItemCatExample);
    }

    @Override
    public TbItemCat findTemplateId(Long id) {
        return tbItemCatMapper.selectByPrimaryKey(id);
    }



}
