package com.example.information_sharing.entity;

import java.io.Serializable;

public class LostCategory implements Serializable {
    private Integer lostCategoryId;

    private String lostCategoryName;

    private static final long serialVersionUID = 1L;

    public Integer getLostCategoryId() {
        return lostCategoryId;
    }

    public void setLostCategoryId(Integer lostCategoryId) {
        this.lostCategoryId = lostCategoryId;
    }

    public String getLostCategoryName() {
        return lostCategoryName;
    }

    public void setLostCategoryName(String lostCategoryName) {
        this.lostCategoryName = lostCategoryName == null ? null : lostCategoryName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lostCategoryId=").append(lostCategoryId);
        sb.append(", lostCategoryName=").append(lostCategoryName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}