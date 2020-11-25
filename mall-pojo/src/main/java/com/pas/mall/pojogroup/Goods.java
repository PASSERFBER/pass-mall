package com.pas.mall.pojogroup;

import com.pas.mall.pojo.TbGoods;
import com.pas.mall.pojo.TbGoodsDesc;
import com.pas.mall.pojo.TbItem;

import java.io.Serializable;
import java.util.List;

public class Goods implements Serializable {
    public TbGoods tbGoods;
    public TbGoodsDesc tbGoodsDesc;
    public List<TbItem> listItem;

    public TbGoods getTbGoods() {
        return tbGoods;
    }

    public void setTbGoods(TbGoods tbGoods) {
        this.tbGoods = tbGoods;
    }

    public TbGoodsDesc getTbGoodsDesc() {
        return tbGoodsDesc;
    }

    public void setTbGoodsDesc(TbGoodsDesc tbGoodsDesc) {
        this.tbGoodsDesc = tbGoodsDesc;
    }

    public List<TbItem> getListItem() {
        return listItem;
    }

    public void setListItem(List<TbItem> listItem) {
        this.listItem = listItem;
    }
}
