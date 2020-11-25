package com.pas.mall.service.impl;

import com.pas.mall.mapper.TbGoodsDescMapper;
import com.pas.mall.mapper.TbGoodsMapper;
import com.pas.mall.mapper.TbItemMapper;
import com.pas.mall.pojo.TbGoods;
import com.pas.mall.pojo.TbItem;
import com.pas.mall.pojogroup.Goods;
import com.pas.mall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private TbGoodsMapper tbGoodsMapper;

    @Autowired
    private TbItemMapper tbItemMapper;
    @Autowired
    private TbGoodsDescMapper tbGoodsDescMapper;

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
        }
    }

    @Override
    public List<TbGoods> findAll() {
        return tbGoodsMapper.selectByExample(null);
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
}
