package com.example.information_sharing.dao;

import com.example.information_sharing.entity.LostCategory;
import java.util.List;

public interface LostCategoryMapper {
    int deleteByPrimaryKey(Integer lostCategoryId);

    int insert(LostCategory record);

    LostCategory selectByPrimaryKey(Integer lostCategoryId);

    List<LostCategory> selectAll();

    int updateByPrimaryKey(LostCategory record);
}