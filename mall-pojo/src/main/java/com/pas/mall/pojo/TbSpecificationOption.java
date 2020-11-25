package com.pas.mall.pojo;

import java.io.Serializable;

public class TbSpecificationOption implements Serializable {
    /**
     * 规格项ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 规格项名称
     *
     * @mbg.generated
     */
    private String optionName;

    /**
     * 规格ID
     *
     * @mbg.generated
     */
    private Long specId;

    /**
     * 排序值
     *
     * @mbg.generated
     */
    private Integer orders;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", optionName=").append(optionName);
        sb.append(", specId=").append(specId);
        sb.append(", orders=").append(orders);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}