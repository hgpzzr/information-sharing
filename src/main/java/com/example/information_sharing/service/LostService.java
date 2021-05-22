package com.example.information_sharing.service;

import com.example.information_sharing.VO.ResultVO;
import com.example.information_sharing.form.LostInformationForm;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/5/18 14:24
 */
@Service
public interface LostService {
	ResultVO insertLostInformation(LostInformationForm form, MultipartFile file);

	ResultVO deleteLostInformation(int lostId);
}