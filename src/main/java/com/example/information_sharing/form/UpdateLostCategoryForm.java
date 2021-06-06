package com.example.information_sharing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/6/6 18:27
 */
@Data
public class UpdateLostCategoryForm {
	@ApiModelProperty("失物招领分类信息编号")
	@NotNull(message = "失物招领分类信息编号不能为空")
	private int lostCategoryId;

	@ApiModelProperty("分类名")
	@NotBlank(message = "分类名不能为空")
	private String lostCategoryName;
}
