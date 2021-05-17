package com.example.information_sharing.dao;

import com.example.information_sharing.entity.informationCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface informationCategoryMapper {
    int deleteByPrimaryKey(Integer informationCategoryId);

    int insert(informationCategory record);

    informationCategory selectByPrimaryKey(Integer informationCategoryId);

    List<informationCategory> selectAll();

    int updateByPrimaryKey(informationCategory record);
}