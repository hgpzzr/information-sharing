package com.example.information_sharing.service.impl;

import com.example.information_sharing.VO.ResultVO;
import com.example.information_sharing.dao.LostInformationMapper;
import com.example.information_sharing.entity.LostInformation;
import com.example.information_sharing.entity.User;
import com.example.information_sharing.enums.ResultEnum;
import com.example.information_sharing.form.LostInformationForm;
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

import java.util.Date;

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

	@Value("${img.informationPic.filePath}")
	private String filePath;
	@Value("${img.url}")
	private String url;

	@Override
	public ResultVO insertLostInformation(LostInformationForm form, MultipartFile file) {
		LostInformation information = new LostInformation();
		BeanUtils.copyProperties(form,information);
		// 查出当前用户
		User currentUser = userService.getCurrentUser();
		// 设置用户id
		information.setUserId(currentUser.getUserId());
		// 上传图片
		String fileName = FileUtil.generateFileName(file);
		boolean upload = FileUtil.upload(file, filePath, fileName);
		if(!upload){
			return ResultVOUtil.error(ResultEnum.FILE_UPLOAD_ERROR);
		}
		String realFilePath = filePath+fileName;
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
		if(insert != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("添加成功");
	}

	@Override
	public ResultVO deleteLostInformation(int lostId) {
		LostInformation lostInformation = lostInformationMapper.selectByPrimaryKey(lostId);
		if(lostInformation == null){
			return ResultVOUtil.error(ResultEnum.LOST_AND_FOUND_INFORMATION_NOT_EXIST_ERROR);
		}
		// 删除图片
		FileUtil.deleteFile(lostInformation.getFilePath());
		// 删除数据库记录
		int delete = lostInformationMapper.deleteByPrimaryKey(lostId);
		if(delete != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("删除成功");
	}
}
