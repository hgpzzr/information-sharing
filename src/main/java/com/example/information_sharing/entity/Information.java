package com.example.information_sharing.entity;

import java.io.Serializable;
import java.util.Date;

public class Information implements Serializable {
    private Integer informationId;

    private Date time;

    private String contactInformation;

    private Integer informationStatus;

    private Integer informationCategoryId;

    private Date createTime;

    private Date updateTime;

    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getInformationId() {
        return informationId;
    }

    public void setInformationId(Integer informationId) {
        this.informationId = informationId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation == null ? null : contactInformation.trim();
    }

    public Integer getInformationStatus() {
        return informationStatus;
    }

    public void setInformationStatus(Integer informationStatus) {
        this.informationStatus = informationStatus;
    }

    public Integer getInformationCategoryId() {
        return informationCategoryId;
    }

    public void setInformationCategoryId(Integer informationCategoryId) {
        this.informationCategoryId = informationCategoryId;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", informationId=").append(informationId);
        sb.append(", time=").append(time);
        sb.append(", contactInformation=").append(contactInformation);
        sb.append(", informationStatus=").append(informationStatus);
        sb.append(", informationCategoryId=").append(informationCategoryId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}