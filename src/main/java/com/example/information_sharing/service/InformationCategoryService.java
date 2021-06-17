package com.example.information_sharing.service;

import com.example.information_sharing.VO.ResultVO;
import org.springframework.stereotype.Service;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/6/17 12:51
 */
@Service
public interface InformationCategoryService {
	ResultVO add(String categoryName);

	ResultVO delete(int categoryId);

	ResultVO update(int categoryId,String categoryName);

	ResultVO selectAll();
}
