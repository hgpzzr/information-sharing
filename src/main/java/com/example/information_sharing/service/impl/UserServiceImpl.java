package com.example.information_sharing.service.impl;

import com.example.information_sharing.VO.ResultVO;
import com.example.information_sharing.dao.UserMapper;
import com.example.information_sharing.entity.User;
import com.example.information_sharing.enums.ResultEnum;
import com.example.information_sharing.form.ChangePasswordForm;
import com.example.information_sharing.form.LoginForm;
import com.example.information_sharing.form.RegisterForm;
import com.example.information_sharing.security.JwtProperties;
import com.example.information_sharing.security.JwtUserDetailServiceImpl;
import com.example.information_sharing.service.UserService;
import com.example.information_sharing.utils.FileUtil;
import com.example.information_sharing.utils.JwtTokenUtil;
import com.example.information_sharing.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private JwtUserDetailServiceImpl jwtUserDetailService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtProperties jwtProperties;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Value("${img.headPic.filePath}")
	private String filePath;
	@Value("${img.headPic.url}")
	private String url;

	@Override
	public User getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userName = authentication.getName();
		String key = "anonymousUser";
		if (!userName.equals(key)) {
			return getUserByUserName(userName);
		}
		return null;
	}

	@Override
	public User getUserByUserName(String userName) {
		User user = userMapper.getUserByUserName(userName);
		return user;
	}

	@Override
	public ResultVO login(LoginForm loginForm, HttpServletResponse response) {
		User user = userMapper.getUserByUserName(loginForm.getUserName());
		if (user == null) {
			log.error("【登录】：用户不存在");
			return ResultVOUtil.error(ResultEnum.USER_NOT_EXIST_ERROR);
		}
		UserDetails userDetails = jwtUserDetailService.loadUserByUsername(loginForm.getUserName());
		if (!(new BCryptPasswordEncoder().matches(loginForm.getPassword(), userDetails.getPassword()))) {
			log.error("【登录】：密码错误");
			return ResultVOUtil.error(ResultEnum.PASSWORD_ERROR);
		}
		Authentication token = new UsernamePasswordAuthenticationToken(loginForm.getUserName(), loginForm.getPassword(), userDetails.getAuthorities());
		Authentication authentication = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		final String realToken = jwtTokenUtil.generateToken(userDetails);
		response.addHeader(jwtProperties.getTokenName(), realToken);
		Map<String, Serializable> map = new HashMap<>();
		map.put("name", user.getUserName());
		map.put("userId", user.getUserId());
		map.put("role", user.getRole());
		map.put("realName", user.getRealName());
		map.put("nickName", user.getNickName());
		map.put("token",token);
		return ResultVOUtil.success(map);
	}

	@Override
	public ResultVO register(RegisterForm form) {
		boolean isHave = userMapper.getUserByUserName(form.getUserName()) != null;
		if (isHave) {
			return ResultVOUtil.error(ResultEnum.USER_EXIST_ERROR);
		}
		// 判断学号长度
		if (form.getUserName().length() != 12) {
			return ResultVOUtil.error(ResultEnum.USER_NAME_FORMAT_ERROR);
		}
		// 判断密码长度
		if (form.getPassword().length() < 6 || form.getPassword().length() > 18) {
			return ResultVOUtil.error(ResultEnum.PASSWORD_LENGTH_ERROR);
		}
		User user = new User();
		// 赋值
		BeanUtils.copyProperties(form, user);
		// 将密码加密后保存
		user.setPassword(passwordEncoder.encode(form.getPassword()));
		// 设置默认权限
		user.setRole(0);
		// 设置默认头像
		user.setPicUrl(url + "default.jpg");
		user.setFilePath(filePath + "default.jpg");
		Date date = new Date();
		user.setCreateTime(date);
		// 存入数据库
		int insert = userMapper.insert(user);
		if (insert != 1) {
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("注册成功");
	}

	@Override
	public ResultVO uploadPic(MultipartFile file, int userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		if(user == null){
			return ResultVOUtil.error(ResultEnum.USER_NOT_EXIST_ERROR);
		}
		String fileName = FileUtil.generateFileName(file);
		FileUtil.upload(file,filePath,fileName);
		user.setFilePath(filePath+fileName);
		user.setPicUrl(url+fileName);
		int update = userMapper.updateByPrimaryKey(user);
		if(update != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("上传成功");
	}

	@Override
	public ResultVO changePassword(ChangePasswordForm form) {
		User user = userMapper.selectByPrimaryKey(form.getUserId());
		if(user == null){
			return ResultVOUtil.error(ResultEnum.USER_NOT_EXIST_ERROR);
		}
		UserDetails userDetails = jwtUserDetailService.loadUserByUsername(form.getUserName());
		if (!new BCryptPasswordEncoder().matches(form.getOldPassword(), userDetails.getPassword())) {
			return ResultVOUtil.error(ResultEnum.PASSWORD_ERROR);
		}
		user.setPassword(passwordEncoder.encode(form.getNewPassword()));
		int update = userMapper.updateByPrimaryKey(user);
		if(update != 1){
			return ResultVOUtil.error(ResultEnum.DATABASE_OPTION_ERROR);
		}
		return ResultVOUtil.success("修改成功");
	}
}
