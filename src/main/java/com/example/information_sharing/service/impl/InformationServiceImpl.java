package com.example.information_sharing.service.impl;

import com.example.information_sharing.VO.InformationVO;
import com.example.information_sharing.VO.ResultVO;
import com.example.information_sharing.dao.InformationCategoryMapper;
import com.example.information_sharing.dao.InformationMapper;
import com.example.information_sharing.entity.Information;
import com.example.information_sharing.entity.InformationCategory;
import com.example.information_sharing.enums.ResultEnum;
import com.example.information_sharing.service.InformationService;
import com.example.information_sharing.service.UserService;
import com.example.information_sharing.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@Transactional
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationMapper informationMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private InformationCategoryMapper informationCategoryMapper;

    @Override
    public ResultVO insertInformation(Information information) {
        int insert = informationMapper.insert(information);
        if (insert != 1){
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
        return ResultVOUtil.success("添加成功");
    }

    @Override
    public ResultVO deleteInformation(Integer informationId) {
        Information information = informationMapper.selectByPrimaryKey(informationId);
        if(information == null){
            return ResultVOUtil.error(ResultEnum.LOST_AND_FOUND_INFORMATION_NOT_EXIST_ERROR);
        }
        int delete = informationMapper.deleteByPrimaryKey(informationId);
        if (delete != 1){
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
        return ResultVOUtil.success("删除成功");
    }

    @Override
    public ResultVO updateInformation(Information information) {
        Information information1 = informationMapper.selectByPrimaryKey(information.getInformationId());
        if(information1 == null){
            return ResultVOUtil.error(ResultEnum.LOST_AND_FOUND_INFORMATION_NOT_EXIST_ERROR);
        }
        int update = informationMapper.updateByPrimaryKey(information);
        if(update != 1){
            return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
        }
        return ResultVOUtil.success("修改成功");
    }

    @Override
    public ResultVO selectAllInformation() {
        List<Information> informationList = informationMapper.selectByStatus(0);
        List<InformationVO> informationVOList = new ArrayList<>();
        for(Information information : informationList){
            InformationVO informationVO = new InformationVO();
            BeanUtils.copyProperties(information,informationVO);
            InformationCategory informationCategory = informationCategoryMapper.selectByPrimaryKey(information.getInformationCategoryId());
            informationVO.setInformationCategoryId(informationCategory.getInformationCategoryId());
            informationVOList.add(informationVO);
        }
        return ResultVOUtil.success(informationVOList);
    }

    @Override
    public ResultVO selectByCategoryId(Integer informationCategoryId) {
        List<Information> informationList = informationMapper.selectByCategoryId(informationCategoryId);
        List<InformationVO> informationVOList = new ArrayList<>();
        for(Information information : informationList){
            InformationVO informationVO = new InformationVO();
            BeanUtils.copyProperties(information,informationVO);
            InformationCategory informationCategory = informationCategoryMapper.selectByPrimaryKey(information.getInformationCategoryId());
            informationVO.setInformationCategoryId(informationCategory.getInformationCategoryId());
            informationVOList.add(informationVO);
        }
        return ResultVOUtil.success(informationVOList);
    }
}
