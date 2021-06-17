package com.example.information_sharing.controller;

import com.example.information_sharing.VO.ResultVO;
import com.example.information_sharing.service.InformationCategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/6/17 12:56
 */
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/informationCategory")
public class InformationCategoryController {
	@Autowired
	private InformationCategoryService informationCategoryService;

	@PostMapping("/insert")
	@ApiOperation("添加其他信息分类信息")
	public ResultVO insert(String categoryName){
		return informationCategoryService.add(categoryName);
	}

	@DeleteMapping("/delete")
	@ApiOperation("删除其他信息分类信息")
	public ResultVO delete(int cateGoryId){
		return informationCategoryService.delete(cateGoryId);
	}

	@PutMapping("/update")
	@ApiOperation("修改其他信息分类信息")
	public ResultVO update(String categoryName,int categoryId){
		return informationCategoryService.update(categoryId,categoryName);
	}

	@GetMapping("/selectAll")
	@ApiOperation("查询所有分类")
	public ResultVO selectAll(){
		return informationCategoryService.selectAll();
	}
}
