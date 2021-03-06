package com.example.information_sharing.enums;

import lombok.Getter;

/**
 * @author hgp
 * @version 1.0
 * @date 2021/3/29 19:45
 */
@Getter
public enum  ResultEnum {
    /***/
    USER_EXIST_ERROR(1,"用户已存在"),
    DATABASE_OPTION_ERROR(2,"数据库操作失败"),
    USER_NOT_EXIST_ERROR(3,"用户不存在"),
    PASSWORD_ERROR(4,"密码错误"),
    FILE_UPLOAD_ERROR(5,"文件上传失败"),
    LOST_AND_FOUND_INFORMATION_NOT_EXIST_ERROR(6,"失物招领信息不存在"),
    USER_NAME_FORMAT_ERROR(7,"学号格式错误"),
    PASSWORD_LENGTH_ERROR(8,"密码长度错误"),
    CATEGORY_NOT_EXIST_ERROR(9,"分类不存在"),
    NOT_SELF_OPTION(10,"非本人操作"),




    AUTHENTICATION_ERROR(401, "用户认证失败,请重新登录"),
    PERMISSION_DENNY(403, "权限不足"),
    NOT_FOUND(404, "url错误,请求路径未找到"),
    SERVER_ERROR(500, "服务器未知错误:%s"),
    BIND_ERROR(511, "参数校验错误:%s"),
    REQUEST_METHOD_ERROR(550, "不支持%s的请求方式");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
