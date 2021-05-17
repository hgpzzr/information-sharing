package com.example.information_sharing.entity;

import java.io.Serializable;

public class informationCategory implements Serializable {
    private Integer informationCategoryId;

    private String informationCategoryName;

    private static final long serialVersionUID = 1L;

    public Integer getInformationCategoryId() {
        return informationCategoryId;
    }

    public void setInformationCategoryId(Integer informationCategoryId) {
        this.informationCategoryId = informationCategoryId;
    }

    public String getInformationCategoryName() {
        return informationCategoryName;
    }

    public void setInformationCategoryName(String informationCategoryName) {
        this.informationCategoryName = informationCategoryName == null ? null : informationCategoryName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", informationCategoryId=").append(informationCategoryId);
        sb.append(", informationCategoryName=").append(informationCategoryName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}