package com.example.information_sharing.service.impl;

import com.example.information_sharing.dao.UserMapper;
import com.example.information_sharing.entity.User;
import com.example.information_sharing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/5/17 16:28
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

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
}
