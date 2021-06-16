package com.example.information_sharing.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class ChangePasswordForm {
	@ApiModelProperty("用户名（学号）")
	@NotBlank(message = "用户名不能为空")
	private String userName;

	@ApiModelProperty("用户编号")
	@NotNull(message = "用户编号不能为空")
	private int userId;

	@ApiModelProperty("旧密码")
	@NotBlank(message = "旧密码不能为空")
	private String oldPassword;

	@ApiModelProperty("新密码")
	@NotBlank(message = "新密码不能为空")
	private String newPassword;
}
