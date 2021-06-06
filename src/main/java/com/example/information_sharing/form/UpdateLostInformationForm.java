package com.example.information_sharing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/6/6 13:33
 */
@Data
public class UpdateLostInformationForm {
	@ApiModelProperty("失物招领信息编号")
	@NotNull(message = "失物招领信息编号不能为空")
	private int lostAndFoundId;

	@ApiModelProperty("描述")
	@NotBlank(message = "描述不能为空")
	private String describe;

	@ApiModelProperty("拾到地点")
	@NotBlank(message = "拾到地点不能为空")
	private String pickupPlace;

	@ApiModelProperty("拾到时间")
	@NotNull(message = "拾到时间不能为空")
	private Date pickupTime;

	@ApiModelProperty("联系方式")
	@NotBlank(message = "联系方式不能为空")
	private String contactInformation;
}
