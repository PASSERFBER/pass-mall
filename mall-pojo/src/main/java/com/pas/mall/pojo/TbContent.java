package com.pas.mall.pojo;

import java.io.Serializable;

public class TbContent implements Serializable {
    private Long id;

    /**
     * 内容类目ID
     *
     * @mbg.generated
     */
    private Long categoryId;

    /**
     * 内容标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 链接
     *
     * @mbg.generated
     */
    private String url;

    /**
     * 图片绝对路径
     *
     * @mbg.generated
     */
    private String pic;

    /**
     * 状态
     *
     * @mbg.generated
     */
    private String status;

    /**
     * 排序
     *
     * @mbg.generated
     */
    private Integer sortOrder;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", title=").append(title);
        sb.append(", url=").append(url);
        sb.append(", pic=").append(pic);
        sb.append(", status=").append(status);
        sb.append(", sortOrder=").append(sortOrder);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}