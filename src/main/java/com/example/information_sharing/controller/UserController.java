package com.example.information_sharing.controller;

import com.example.information_sharing.VO.ResultVO;
import com.example.information_sharing.form.ChangePasswordForm;
import com.example.information_sharing.form.LoginForm;
import com.example.information_sharing.form.RegisterForm;
import com.example.information_sharing.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@Slf4j
@RequestMapping("/user")
@Api(tags = "用户接口")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/login")
	@ApiOperation("登录")
	public ResultVO login(LoginForm loginForm, HttpServletResponse response) {
		return userService.login(loginForm, response);
	}

	@PostMapping("/register")
	@ApiOperation("注册")
	public ResultVO register(RegisterForm form) {
		return userService.register(form);
	}

	@PostMapping("/uploadPic")
	@ApiOperation("上传头像")
	public ResultVO uploadPic(@RequestParam("file") MultipartFile file, int userId) {
		return userService.uploadPic(file,userId);
	}

	@PostMapping("/changePassword")
	@ApiOperation("修改密码")
	public ResultVO changePassword(ChangePasswordForm form) {
		return userService.changePassword(form);
	}
}
