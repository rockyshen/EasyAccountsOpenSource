package com.deepblue.yd_jz.exception;

/**
 * @author rockyshen
 * @date 2025/1/27 15:42
 */

import com.deepblue.yd_jz.dto.BaseDto;
import com.deepblue.yd_jz.utils.StatusCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 * @author rockyshen
 * @date 2024/9/10 14:34
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 只捕获业务相关异常
     * @param e
     * @return
     * e.getCode(),e.getMessage(),e.getDescription()
     */
    @ExceptionHandler
    public BaseDto businessException(BusinessException e, HttpServletRequest request){
//        log.error("businessException:"+e.getMessage(),e);
        log.error("请求：{}，发送异常：{}",request.getRequestURL(),e.getMessage(),e);
        return BaseDto.setErrorBean(e.getMessage(),e.getCode());
    }

    /**
     * 捕获其他RuntimeException
     * @param e
     * @return
     * StatusCodeEnum.SYSTEM_ERROR,"系统内部错误"
     */
    @ExceptionHandler
    public BaseDto runtimeException(RuntimeException e){
        log.error("runtimeException",e);
        return BaseDto.setErrorBean(StatusCodeEnum.SYSTEM_ERROR.getMsg(),StatusCodeEnum.SYSTEM_ERROR.getCode());
    }
}
