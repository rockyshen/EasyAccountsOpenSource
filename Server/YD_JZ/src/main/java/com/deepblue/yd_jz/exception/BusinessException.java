package com.deepblue.yd_jz.exception;

/**
 * @author rockyshen
 * @date 2025/1/27 15:39
 */

import com.deepblue.yd_jz.utils.StatusCodeEnum;

/**
 * 自定义全局异常处理类
 * @author rockyshen
 * @date 2024/9/10 14:12
 */
public class BusinessException extends RuntimeException{
    private int code;   // 结果状态，具体状态码，参见枚举类！
    private String description;

    public BusinessException(String message, int code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public BusinessException(StatusCodeEnum statusCodeEnum){
        super(statusCodeEnum.getMsg());
        this.code = statusCodeEnum.getCode();
    }

    public BusinessException(StatusCodeEnum statusCodeEnum,String description){
        super(statusCodeEnum.getMsg());
        this.code = statusCodeEnum.getCode();
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
