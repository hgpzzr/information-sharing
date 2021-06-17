package com.example.information_sharing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/5/18 14:29
 */
@Data
public class LostInformationForm {
	@NotBlank(message = "描述不能为空")
	@ApiModelProperty("描述")
	private String describe;

	@NotBlank(message = "拾到地点不能为空")
	@ApiModelProperty("拾到地点（或丢失地点）")
	private String pickupPlace;

	@NotBlank(message = "拾到时间不能为空")
	@ApiModelProperty("拾到时间（或丢失时间）")
//	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date pickupTime;

	@NotBlank(message = "联系方式不能为空")
	@ApiModelProperty("联系方式")
	private String contactInformation;

	@NotBlank(message = "分类编号不能为空")
	@ApiModelProperty("分类编号")
	private int categoryId;

	@NotBlank(message = "启事类型不能为空")
	@ApiModelProperty("启事类型(0为失物启事，1为拾物启事)")
	private int flag;
}
