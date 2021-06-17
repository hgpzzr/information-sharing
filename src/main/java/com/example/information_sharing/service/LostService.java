package com.example.information_sharing.service;

import com.example.information_sharing.VO.ResultVO;
import com.example.information_sharing.form.LostInformationForm;
import com.example.information_sharing.form.UpdateLostInformationForm;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/5/18 14:24
 */
@Service
public interface LostService {
	/**
	 * 添加失物招领信息
	 * @param form
	 * @param file
	 * @return
	 */
	ResultVO insertLostInformation(LostInformationForm form, MultipartFile file);

	/**
	 * 删除失物招领信息
	 * @param lostId
	 * @return
	 */
	ResultVO deleteLostInformation(int lostId);

	/**
	 * 修改失物招领信息
	 * @param form
	 * @return
	 */
	ResultVO updateLostInformation(UpdateLostInformationForm form);

	/**
	 * 查询所有未找回的失物招领信息
	 * @return
	 */
	ResultVO selectAllLostInformation();

	/**
	 * 根据分类查找未找回的失物招领信息
	 * @param categoryId
	 * @return
	 */
	ResultVO selectByCategoryId(int categoryId);

	ResultVO changeItemStatus(int lostId);

	ResultVO fuzzyQuery(Integer categoryId,String key,Integer flag);
}