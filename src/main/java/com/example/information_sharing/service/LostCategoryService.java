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
	/**
	 * 添加失物招领分类信息
	 * @param lostCategoryName
	 * @return
	 */
	ResultVO insertLostCategory(String lostCategoryName);

	/**
	 * 删除失物招领分类信息
	 * @param lostCategoryId
	 * @return
	 */
	ResultVO deleteLostCategory(int lostCategoryId);
}
