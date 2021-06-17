package com.example.information_sharing.service.impl;

import com.example.information_sharing.VO.LostInformationVO;
import com.example.information_sharing.VO.ResultVO;
import com.example.information_sharing.dao.LostCategoryMapper;
import com.example.information_sharing.dao.LostInformationMapper;
import com.example.information_sharing.dao.UserMapper;
import com.example.information_sharing.entity.LostCategory;
import com.example.information_sharing.entity.LostInformation;
import com.example.information_sharing.entity.User;
import com.example.information_sharing.enums.ResultEnum;
import com.example.information_sharing.form.LostInformationForm;
import com.example.information_sharing.form.UpdateLostInformationForm;
import com.example.information_sharing.service.LostService;
import com.example.information_sharing.service.UserService;
import com.example.information_sharing.utils.FileUtil;
import com.example.information_sharing.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/5/18 14:25
 */
@Service
@Slf4j
public class LostServiceImpl implements LostService {
	@Autowired
	private UserService userService;
	@Autowired
	private LostInformationMapper lostInformationMapper;
	@Autowired
	private LostCategoryMapper lostCategoryMapper;
	@Autowired
	private UserMapper userMapper;

	@Value("${img.informationPic.filePath}")
	private String filePath;
	@Value("${img.informationPic.url}")
	private String url;

	@Override
	public ResultVO insertLostInformation(LostInformationForm form, MultipartFile file) {
		LostInformation information = new LostInformation();
		BeanUtils.copyProperties(form, information);
		// 查出当前用户
		User currentUser = userService.getCurrentUser();
		// 设置用户id
		information.setUserId(currentUser.getUserId());
		// 上传图片
		String fileName = FileUtil.generateFileName(file);
		boolean upload = FileUtil.upload(file, filePath, fileName);
		if (!upload) {
			return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
		}
		String realFilePath = filePath + fileName;
		String realUrl = url + fileName;
		information.setFilePath(realFilePath);
		information.setPicUrl(realUrl);
		information.setItemStatus(0);
		Date createTime = new Date();
		Date updateTime = new Date();
		information.setCreateTime(createTime);
		information.setUpdateTime(updateTime);
		// 存入数据库
		int insert = lostInformationMapper.insert(information);
		if (insert != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("添加成功");
	}

	@Override
	public ResultVO deleteLostInformation(int lostId) {
		LostInformation lostInformation = lostInformationMapper.selectByPrimaryKey(lostId);
		if (lostInformation == null) {
			return ResultVOUtil.error(ResultEnum.LOST_AND_FOUND_INFORMATION_NOT_EXIST_ERROR);
		}
		// 判断是否是本人或者是管理员
		User user = userMapper.selectByPrimaryKey(lostInformation.getUserId());
		if(user.getRole() == 1 && !userService.getCurrentUser().getUserName().equals(user.getUserName())){
			return ResultVOUtil.error(ResultEnum.NOT_SELF_OPTION);
		}
		// 删除图片
		FileUtil.deleteFile(lostInformation.getFilePath());
		// 删除数据库记录
		int delete = lostInformationMapper.deleteByPrimaryKey(lostId);
		if (delete != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}

	@Override
	public ResultVO updateLostInformation(UpdateLostInformationForm form) {
		LostInformation lostInformation = lostInformationMapper.selectByPrimaryKey(form.getLostAndFoundId());
		if (lostInformation == null) {
			return ResultVOUtil.error(ResultEnum.LOST_AND_FOUND_INFORMATION_NOT_EXIST_ERROR);
		}
		BeanUtils.copyProperties(form, lostInformation);
		int update = lostInformationMapper.updateByPrimaryKey(lostInformation);
		if (update != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("修改成功");
	}

	@Override
	public ResultVO selectAllLostInformation() {
		List<LostInformation> lostInformationList = lostInformationMapper.selectByItemStatus(0);
		List<LostInformationVO> lostInformationVOList = new ArrayList<>();
		for (LostInformation lostInformation : lostInformationList) {
			LostInformationVO lostInformationVO = new LostInformationVO();
			BeanUtils.copyProperties(lostInformation,lostInformationVO);
			LostCategory lostCategory = lostCategoryMapper.selectByPrimaryKey(lostInformation.getCategoryId());
			lostInformationVO.setCategoryName(lostCategory.getLostCategoryName());
			lostInformationVOList.add(lostInformationVO);
		}
		return ResultVOUtil.success(lostInformationVOList);
	}

	@Override
	public ResultVO selectByCategoryId(int categoryId) {
		List<LostInformation> lostInformationList = lostInformationMapper.selectByCategoryId(categoryId);
		List<LostInformationVO> lostInformationVOList = new ArrayList<>();
		for (LostInformation lostInformation : lostInformationList) {
			LostInformationVO lostInformationVO = new LostInformationVO();
			BeanUtils.copyProperties(lostInformation,lostInformationVO);
			LostCategory lostCategory = lostCategoryMapper.selectByPrimaryKey(lostInformation.getCategoryId());
			lostInformationVO.setCategoryName(lostCategory.getLostCategoryName());
			lostInformationVOList.add(lostInformationVO);
		}
		return ResultVOUtil.success(lostInformationVOList);
	}

	@Override
	public ResultVO changeItemStatus(int lostId) {
		LostInformation lostInformation = lostInformationMapper.selectByPrimaryKey(lostId);
		if(lostInformation == null){
			return ResultVOUtil.error(ResultEnum.LOST_AND_FOUND_INFORMATION_NOT_EXIST_ERROR);
		}
		lostInformation.setItemStatus(1);
		lostInformationMapper.updateByPrimaryKey(lostInformation);
		return ResultVOUtil.success("修改成功");
	}
}
