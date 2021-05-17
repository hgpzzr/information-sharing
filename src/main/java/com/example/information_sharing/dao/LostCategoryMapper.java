package com.example.information_sharing.dao;

import com.example.information_sharing.entity.LostCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LostCategoryMapper {
    int deleteByPrimaryKey(Integer lostCategoryId);

    int insert(LostCategory record);

    LostCategory selectByPrimaryKey(Integer lostCategoryId);

    List<LostCategory> selectAll();

    int updateByPrimaryKey(LostCategory record);
}