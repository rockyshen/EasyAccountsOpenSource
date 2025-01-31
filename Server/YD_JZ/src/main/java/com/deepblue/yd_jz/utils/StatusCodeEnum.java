package com.deepblue.yd_jz.utils;

/**
 * @author rockyshen
 * @date 2025/1/27 15:40
 */

import lombok.Getter;

/**
 * 状态码枚举类
 * @author rockyshen
 * @date 2024/9/10 13:48
 */

@Getter
public enum StatusCodeEnum {
    // 第四步：利用构造方法，构造枚举值
    SUCCESS(200,"ok",""),
    USERNAME_OR_PASSWORD_ERROR(1002,"用户名或密码错误",""),
    PARAMS_ERROR(1005,"请求参数错误",""),
    NULL_ERROR(1006,"请求数据为空",""),
    NOT_LOGIN(401,"未登录",""),
    NO_AUTH(403,"无权限",""),
    NOT_FOUND(404,"404页面找不到",""),
    SYSTEM_ERROR(500,"系统内部异常",""),
    FLOW_ERROR(502,"减少金额不允许大于账户金额","")
    ;

    // 第一步：定义枚举属性
    private final int code;
    // 状态码信息
    private final String msg;
    // 状态码详细描述
    private final String description;

    // 第二步：全参构造器
    StatusCodeEnum(int code, String msg, String description) {
        this.code = code;
        this.msg = msg;
        this.description = description;
    }

    // 第三步：getter方法
}