package com.pas.mall.pojo;

import java.io.Serializable;

public class TbGoodsDesc implements Serializable {
    /**
     * SPU_ID
     *
     * @mbg.generated
     */
    private Long goodsId;

    /**
     * 描述
     *
     * @mbg.generated
     */
    private String introduction;

    /**
     * 规格结果集，所有规格，包含isSelected
     *
     * @mbg.generated
     */
    private String specificationItems;

    /**
     * 自定义属性（参数结果）
     *
     * @mbg.generated
     */
    private String customAttributeItems;

    private String itemImages;

    /**
     * 包装列表
     *
     * @mbg.generated
     */
    private String packageList;

    /**
     * 售后服务
     *
     * @mbg.generated
     */
    private String saleService;

    private static final long serialVersionUID = 1L;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSpecificationItems() {
        return specificationItems;
    }

    public void setSpecificationItems(String specificationItems) {
        this.specificationItems = specificationItems;
    }

    public String getCustomAttributeItems() {
        return customAttributeItems;
    }

    public void setCustomAttributeItems(String customAttributeItems) {
        this.customAttributeItems = customAttributeItems;
    }

    public String getItemImages() {
        return itemImages;
    }

    public void setItemImages(String itemImages) {
        this.itemImages = itemImages;
    }

    public String getPackageList() {
        return packageList;
    }

    public void setPackageList(String packageList) {
        this.packageList = packageList;
    }

    public String getSaleService() {
        return saleService;
    }

    public void setSaleService(String saleService) {
        this.saleService = saleService;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", goodsId=").append(goodsId);
        sb.append(", introduction=").append(introduction);
        sb.append(", specificationItems=").append(specificationItems);
        sb.append(", customAttributeItems=").append(customAttributeItems);
        sb.append(", itemImages=").append(itemImages);
        sb.append(", packageList=").append(packageList);
        sb.append(", saleService=").append(saleService);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}