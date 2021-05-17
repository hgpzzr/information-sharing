package com.example.information_sharing.dao;

import com.example.information_sharing.entity.Information;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationMapper {
    int deleteByPrimaryKey(Integer informationId);

    int insert(Information record);

    Information selectByPrimaryKey(Integer informationId);

    List<Information> selectAll();

    int updateByPrimaryKey(Information record);
}