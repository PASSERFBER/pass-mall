package com.pas.mall.pojo;

import org.apache.solr.client.solrj.beans.Field;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TbItem implements Serializable {
    /**
     * 商品id，同时也是商品编号
     *
     * @mbg.generated
     */

    @Field
    private Long id;

    /**
     * 商品标题
     *
     * @mbg.generated
     */
    @Field("item_title")
    private String title;

    /**
     * 商品卖点
     *
     * @mbg.generated
     */
    @Field("item_sell_point")
    private String sellPoint;

    /**
     * 商品价格，单位为：元
     *
     * @mbg.generated
     */
    @Field("item_price")
    private Double price;

    private Integer stockCount;

    /**
     * 库存数量
     *
     * @mbg.generated
     */
    private Integer num;

    /**
     * 商品条形码
     *
     * @mbg.generated
     */
    private String barcode;

    /**
     * 商品图片
     *
     * @mbg.generated
     */
    @Field("item_image")
    private String image;

    /**
     * 所属类目，叶子类目
     *
     * @mbg.generated
     */
    private Long categoryid;

    /**
     * 商品状态，1-正常，2-下架，3-删除
     *
     * @mbg.generated
     */
    private String status;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 更新时间
     *
     * @mbg.generated
     */
    private Date updateTime;

    private String itemSn;

    private BigDecimal costPirce;

    private BigDecimal marketPrice;

    private String isDefault;

    /*@Field("item_goods_id")*/
    private Long goodsId;

    private String sellerId;

    private String cartThumbnail;

/*    @Field("item_category")*/
    private String category;

   /* @Field("item_brand")*/
    private String brand;

    private String spec;

   /* @Field("item_seller")*/
    private String seller;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getItemSn() {
        return itemSn;
    }

    public void setItemSn(String itemSn) {
        this.itemSn = itemSn;
    }

    public BigDecimal getCostPirce() {
        return costPirce;
    }

    public void setCostPirce(BigDecimal costPirce) {
        this.costPirce = costPirce;
    }

    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getCartThumbnail() {
        return cartThumbnail;
    }

    public void setCartThumbnail(String cartThumbnail) {
        this.cartThumbnail = cartThumbnail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", sellPoint=").append(sellPoint);
        sb.append(", price=").append(price);
        sb.append(", stockCount=").append(stockCount);
        sb.append(", num=").append(num);
        sb.append(", barcode=").append(barcode);
        sb.append(", image=").append(image);
        sb.append(", categoryid=").append(categoryid);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", itemSn=").append(itemSn);
        sb.append(", costPirce=").append(costPirce);
        sb.append(", marketPrice=").append(marketPrice);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", cartThumbnail=").append(cartThumbnail);
        sb.append(", category=").append(category);
        sb.append(", brand=").append(brand);
        sb.append(", spec=").append(spec);
        sb.append(", seller=").append(seller);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}