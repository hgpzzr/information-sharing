package com.example.information_sharing.controller;

import com.example.information_sharing.VO.ResultVO;
import com.example.information_sharing.form.LostInformationForm;
import com.example.information_sharing.service.LostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/5/18 14:49
 */
@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/lost")
@Api(tags = "失物招领接口")
public class LostController {
	@Autowired
	private LostService lostService;

	@PostMapping("/insert")
	@ApiOperation("添加失物信息")
	public ResultVO insert(LostInformationForm form, @RequestParam("file") MultipartFile file){
		return lostService.insertLostInformation(form,file);
	}
}
