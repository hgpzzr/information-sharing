package com.example.information_sharing.VO;

import lombok.Data;

import java.util.Date;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/6/8 14:54
 */
@Data
public class LostInformationVO {
	private Integer lostAndFoundId;

	private Integer userId;

	private String describe;

	private String picUrl;

	private String pickupPlace;

	private Date pickupTime;

	private String contactInformation;

	private Integer itemStatus;

	private String categoryName;

	private Integer flag;
}
