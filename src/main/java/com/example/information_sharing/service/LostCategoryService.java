package com.example.information_sharing.service;

import com.example.information_sharing.VO.ResultVO;
import org.springframework.stereotype.Service;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/5/26 20:10
 */
@Service
public interface LostCategoryService {
	ResultVO insertLostCategory(String lostCategoryName);

	ResultVO deleteLostCategory(int lostCategoryId);
}
