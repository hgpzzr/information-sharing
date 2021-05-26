package com.example.information_sharing.controller;

import com.example.information_sharing.VO.ResultVO;
import com.example.information_sharing.service.LostCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/5/26 20:17
 */
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/lostCategory")
@Api(tags = "失物招领分类信息接口")
public class LostCategoryController {
	@Autowired
	private LostCategoryService lostCategoryService;

	@PostMapping("/insert")
	@ApiOperation("添加失物招领分类信息")
	public ResultVO insert(String lostCategoryName){
		return lostCategoryService.insertLostCategory(lostCategoryName);
	}
}