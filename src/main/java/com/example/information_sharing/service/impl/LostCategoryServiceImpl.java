package com.example.information_sharing.service.impl;

import com.example.information_sharing.VO.ResultVO;
import com.example.information_sharing.dao.LostCategoryMapper;
import com.example.information_sharing.entity.LostCategory;
import com.example.information_sharing.enums.ResultEnum;
import com.example.information_sharing.form.UpdateLostCategoryForm;
import com.example.information_sharing.service.LostCategoryService;
import com.example.information_sharing.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/5/26 20:12
 */
@Service
@Slf4j
public class LostCategoryServiceImpl implements LostCategoryService {
	@Autowired
	private LostCategoryMapper lostCategoryMapper;

	@Override
	public ResultVO insertLostCategory(String lostCategoryName) {
		LostCategory lostCategory = new LostCategory();
		lostCategory.setLostCategoryName(lostCategoryName);
		int insert = lostCategoryMapper.insert(lostCategory);
		if(insert != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("添加成功");
	}

	@Override
	public ResultVO deleteLostCategory(int lostCategoryId) {
		int delete = lostCategoryMapper.deleteByPrimaryKey(lostCategoryId);
		if(delete != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO updateLostCategory(UpdateLostCategoryForm form) {
		LostCategory lostCategory = lostCategoryMapper.selectByPrimaryKey(form.getLostCategoryId());
		BeanUtils.copyProperties(form,lostCategory);
		int update = lostCategoryMapper.updateByPrimaryKey(lostCategory);
		if(update != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("修改成功");
	}

	@Override
	public ResultVO selectAll() {
		List<LostCategory> lostCategories = lostCategoryMapper.selectAll();
		return ResultVOUtil.success(lostCategories);
	}
}
