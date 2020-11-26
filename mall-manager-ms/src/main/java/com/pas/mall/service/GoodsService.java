package com.pas.mall.service;

import com.pas.mall.pojo.TbGoods;
import com.pas.mall.pojo.TbItem;
import com.pas.mall.pojo.TbItemCat;
import com.pas.mall.pojogroup.Goods;

import java.util.List;

public interface GoodsService {
    public void add(Goods goods);
    public List<TbGoods> findAll();
    public void update(Goods goods);
    public Goods findOne(Long id);
    public void delete(Long[] ids);
    public void updateStatus(Long[] ids,String status);
    public TbItem findItemListByGoodsIdListAndStatus(Long[] ids,String status);
    public List<TbItemCat> findByCateGoryId(Long parentId);
    public TbItemCat findTemplateId(Long id);

}
