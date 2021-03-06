package com.example.information_sharing.dao;

import com.example.information_sharing.entity.LostInformation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LostInformationMapper {
    int deleteByPrimaryKey(Integer lostAndFoundId);

    int insert(LostInformation record);

    LostInformation selectByPrimaryKey(Integer lostAndFoundId);

    List<LostInformation> selectAll();

    List<LostInformation> selectByItemStatus(int itemStatus);

    List<LostInformation> selectByCategoryId(int categoryId);

    List<LostInformation> fuzzyQuery(Integer categoryId,String key,Integer flag);

    int updateByPrimaryKey(LostInformation record);

}