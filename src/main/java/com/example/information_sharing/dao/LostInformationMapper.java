package com.example.information_sharing.dao;

import com.example.information_sharing.entity.LostInformation;
import java.util.List;

public interface LostInformationMapper {
    int deleteByPrimaryKey(Integer lostAndFoundId);

    int insert(LostInformation record);

    LostInformation selectByPrimaryKey(Integer lostAndFoundId);

    List<LostInformation> selectAll();

    int updateByPrimaryKey(LostInformation record);
}