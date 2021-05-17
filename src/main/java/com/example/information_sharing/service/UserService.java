package com.example.information_sharing.service;

import com.example.information_sharing.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/5/17 16:26
 */
@Service
public interface UserService {
	User getCurrentUser();

	User getUserByUserName(String userName);
}
