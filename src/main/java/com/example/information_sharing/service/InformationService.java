package com.example.information_sharing.service;

import com.example.information_sharing.VO.ResultVO;
import com.example.information_sharing.entity.Information;

public interface InformationService {

    // 添加其他信息
    ResultVO insertInformation(Information information);

    // 删除其他信息
    ResultVO deleteInformation(Integer informationId);

    // 修改其他信息
    ResultVO updateInformation(Information information);

    // 查询其他信息
    ResultVO selectAllInformation();

    // 根据分类查找信息
    ResultVO selectByCategoryId(Integer informationCategoryId);
}
