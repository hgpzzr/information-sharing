package com.example.information_sharing.entity;

import java.io.Serializable;
import java.util.Date;

public class LostInformation implements Serializable {
    private Integer lostAndFoundId;

    private Integer userId;

    private String describe;

    private String picUrl;

    private String filePath;

    private String pickupPlace;

    private Date pickupTime;

    private String contactInformation;

    private Integer itemStatus;

    private Date createTime;

    private Integer categoryId;

    private Integer flag;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getLostAndFoundId() {
        return lostAndFoundId;
    }

    public void setLostAndFoundId(Integer lostAndFoundId) {
        this.lostAndFoundId = lostAndFoundId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getPickupPlace() {
        return pickupPlace;
    }

    public void setPickupPlace(String pickupPlace) {
        this.pickupPlace = pickupPlace == null ? null : pickupPlace.trim();
    }

    public Date getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation == null ? null : contactInformation.trim();
    }

    public Integer getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(Integer itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lostAndFoundId=").append(lostAndFoundId);
        sb.append(", userId=").append(userId);
        sb.append(", describe=").append(describe);
        sb.append(", picUrl=").append(picUrl);
        sb.append(", filePath=").append(filePath);
        sb.append(", pickupPlace=").append(pickupPlace);
        sb.append(", pickupTime=").append(pickupTime);
        sb.append(", contactInformation=").append(contactInformation);
        sb.append(", itemStatus=").append(itemStatus);
        sb.append(", createTime=").append(createTime);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", flag=").append(flag);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}