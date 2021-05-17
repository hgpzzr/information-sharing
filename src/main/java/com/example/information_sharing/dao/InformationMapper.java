package com.example.information_sharing.dao;

import com.example.information_sharing.entity.Information;
import java.util.List;

public interface InformationMapper {
    int deleteByPrimaryKey(Integer informationId);

    int insert(Information record);

    Information selectByPrimaryKey(Integer informationId);

    List<Information> selectAll();

    int updateByPrimaryKey(Information record);
}