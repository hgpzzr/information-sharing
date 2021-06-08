package com.example.information_sharing.controller;

import com.example.information_sharing.VO.ResultVO;
import com.example.information_sharing.form.UpdateLostCategoryForm;
import com.example.information_sharing.service.LostCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@DeleteMapping("/delete")
	@ApiOperation("删除失物招领分类信息")
	public ResultVO delete(int lostCateGoryId){
		return lostCategoryService.deleteLostCategory(lostCateGoryId);
	}

	@PutMapping("/update")
	@ApiOperation("修改失物招领分类信息")
	public ResultVO update(UpdateLostCategoryForm form){
		return lostCategoryService.updateLostCategory(form);
	}

	@GetMapping("/selectAll")
	@ApiOperation("查询所有分类")
	public ResultVO selectAll(){
		return lostCategoryService.selectAll();
	}
}
