package com.example.information_sharing.dao;

import com.example.information_sharing.entity.InformationCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationCategoryMapper {
    int deleteByPrimaryKey(Integer informationCategoryId);

    int insert(InformationCategory record);

    InformationCategory selectByPrimaryKey(Integer informationCategoryId);

    List<InformationCategory> selectAll();

    int updateByPrimaryKey(InformationCategory record);
}