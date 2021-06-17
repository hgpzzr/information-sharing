package com.example.information_sharing.service.impl;

import com.example.information_sharing.VO.ResultVO;
import com.example.information_sharing.dao.InformationCategoryMapper;
import com.example.information_sharing.entity.InformationCategory;
import com.example.information_sharing.enums.ResultEnum;
import com.example.information_sharing.service.InformationCategoryService;
import com.example.information_sharing.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/6/17 12:52
 */
@Service
@Slf4j
public class InformationCategoryServiceImpl implements InformationCategoryService {
	@Autowired
	private InformationCategoryMapper informationCategoryMapper;

	@Override
	public ResultVO add(String categoryName) {
		InformationCategory informationCategory = new InformationCategory();
		informationCategory.setInformationCategoryName(categoryName);
		int insert = informationCategoryMapper.insert(informationCategory);
		if(insert != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("添加成功");
	}

	@Override
	public ResultVO delete(int categoryId) {
		int delete = informationCategoryMapper.deleteByPrimaryKey(categoryId);
		if(delete != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO update(int categoryId, String categoryName) {
		InformationCategory informationCategory = informationCategoryMapper.selectByPrimaryKey(categoryId);
		if(informationCategory == null){
			return ResultVOUtil.error(ResultEnum.CATEGORY_NOT_EXIST_ERROR);
		}
		informationCategory.setInformationCategoryName(categoryName);
		int update = informationCategoryMapper.updateByPrimaryKey(informationCategory);
		if(update != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("更新成功");
	}

	@Override
	public ResultVO selectAll() {
		List<InformationCategory> informationCategories = informationCategoryMapper.selectAll();
		return ResultVOUtil.success(informationCategories);
	}
}
