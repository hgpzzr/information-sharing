package com.example.information_sharing.service;

import com.example.information_sharing.VO.ResultVO;
import com.example.information_sharing.entity.User;
import com.example.information_sharing.form.LoginForm;
import com.example.information_sharing.form.RegisterForm;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;


@Service
public interface UserService {
	/**
	 * 获取当前用户
	 * @return
	 */
	User getCurrentUser();

	/**
	 * 根据用户名获得用户
	 * @param userName
	 * @return
	 */
	User getUserByUserName(String userName);

	ResultVO login(LoginForm loginForm, HttpServletResponse response);

	ResultVO register(RegisterForm form);
}
