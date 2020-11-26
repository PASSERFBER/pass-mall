package com.pas.mall.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class TbGoods implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 商家ID
     *
     * @mbg.generated
     */
    private String sellerId;

    /**
     * SPU名
     *
     * @mbg.generated
     */
    private String goodsName;

    /**
     * 默认SKU
     *
     * @mbg.generated
     */
    private Long defaultItemId;

    /**
     * 状态
     *
     * @mbg.generated
     */
    private String auditStatus;

    /**
     * 是否上架
     *
     * @mbg.generated
     */
    private String isMarketable;

    /**
     * 品牌
     *
     * @mbg.generated
     */
    private Long brandId;

    /**
     * 副标题
     *
     * @mbg.generated
     */
    private String caption;

    /**
     * 一级类目
     *
     * @mbg.generated
     */
    private Long category1Id;

    /**
     * 二级类目
     *
     * @mbg.generated
     */
    private Long category2Id;

    /**
     * 三级类目
     *
     * @mbg.generated
     */
    private Long category3Id;

    /**
     * 小图
     *
     * @mbg.generated
     */
    private String smallPic;

    /**
     * 商城价
     *
     * @mbg.generated
     */
    private Double price;

    /**
     * 分类模板ID
     *
     * @mbg.generated
     */
    private Long typeTemplateId;

    /**
     * 是否启用规格
     *
     * @mbg.generated
     */
    private String isEnableSpec;

    /**
     * 是否删除
     *
     * @mbg.generated
     */
    private String isDelete;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getDefaultItemId() {
        return defaultItemId;
    }

    public void setDefaultItemId(Long defaultItemId) {
        this.defaultItemId = defaultItemId;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(String isMarketable) {
        this.isMarketable = isMarketable;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Long getCategory1Id() {
        return category1Id;
    }

    public void setCategory1Id(Long category1Id) {
        this.category1Id = category1Id;
    }

    public Long getCategory2Id() {
        return category2Id;
    }

    public void setCategory2Id(Long category2Id) {
        this.category2Id = category2Id;
    }

    public Long getCategory3Id() {
        return category3Id;
    }

    public void setCategory3Id(Long category3Id) {
        this.category3Id = category3Id;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getTypeTemplateId() {
        return typeTemplateId;
    }

    public void setTypeTemplateId(Long typeTemplateId) {
        this.typeTemplateId = typeTemplateId;
    }

    public String getIsEnableSpec() {
        return isEnableSpec;
    }

    public void setIsEnableSpec(String isEnableSpec) {
        this.isEnableSpec = isEnableSpec;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", defaultItemId=").append(defaultItemId);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", isMarketable=").append(isMarketable);
        sb.append(", brandId=").append(brandId);
        sb.append(", caption=").append(caption);
        sb.append(", category1Id=").append(category1Id);
        sb.append(", category2Id=").append(category2Id);
        sb.append(", category3Id=").append(category3Id);
        sb.append(", smallPic=").append(smallPic);
        sb.append(", price=").append(price);
        sb.append(", typeTemplateId=").append(typeTemplateId);
        sb.append(", isEnableSpec=").append(isEnableSpec);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}