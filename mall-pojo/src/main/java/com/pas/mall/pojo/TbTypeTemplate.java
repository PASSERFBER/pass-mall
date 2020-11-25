package com.pas.mall.pojo;

import java.io.Serializable;

public class TbTypeTemplate implements Serializable {
    private Long id;

    /**
     * 模板名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 关联规格
     *
     * @mbg.generated
     */
    private String specIds;

    /**
     * 关联品牌
     *
     * @mbg.generated
     */
    private String brandIds;

    /**
     * 自定义属性
     *
     * @mbg.generated
     */
    private String customAttributeItems;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecIds() {
        return specIds;
    }

    public void setSpecIds(String specIds) {
        this.specIds = specIds;
    }

    public String getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(String brandIds) {
        this.brandIds = brandIds;
    }

    public String getCustomAttributeItems() {
        return customAttributeItems;
    }

    public void setCustomAttributeItems(String customAttributeItems) {
        this.customAttributeItems = customAttributeItems;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", specIds=").append(specIds);
        sb.append(", brandIds=").append(brandIds);
        sb.append(", customAttributeItems=").append(customAttributeItems);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}