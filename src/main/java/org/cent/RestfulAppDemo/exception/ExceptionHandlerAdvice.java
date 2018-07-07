package org.cent.RestfulAppDemo.exception;

import org.cent.RestfulAppDemo.service.Result;
import org.cent.RestfulAppDemo.service.ResultStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * 全局异常处理类，与controller分离，统一管理
 * @author cent
 * @version 1.0
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice {
    // 区分业务逻辑、程序异常日志记录，可独立控制开关
    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);
    private final static Logger SERVICE_LOGGER = LoggerFactory.getLogger(ServiceException.class);

    /**
     * 未定义其他子异常处理方法时，最终匹配该异常处理方法
     * @param e 异常实例
     * @return 返回json格式结果
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        LOGGER.info(e.toString());
//        e.printStackTrace();
        return new Result(ResultStatus.UNKNOWN);
    }

    /**
     * http请求参数缺少异常处理方法
     * @param e 异常实例
     * @return 返回json格式结果
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result handleMissingParamException(MissingServletRequestParameterException e) {
        LOGGER.info(e.toString());
//        e.printStackTrace();
        return new Result(ResultStatus.MISS);
    }

    /**
     * http请求参数类型不匹配异常处理方法
     * @param e 异常实例
     * @return 返回json格式结果
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Result handleMismatchParamException(MethodArgumentTypeMismatchException e) {
        LOGGER.info(e.toString());
//        e.printStackTrace();
        return new Result(ResultStatus.ERROR);
    }

    /**
     * http请求参数无效异常处理方法
     * @param e 异常实例
     * @return 返回json格式结果
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleIllegalParamException(MethodArgumentNotValidException e) {
        LOGGER.info(e.toString());
//        e.printStackTrace();
        return new Result(ResultStatus.ERROR);
    }

    /**
     * 服务的业务逻辑异常处理方法
     * @param e 统一ServiceException异常实例
     * @return 返回json格式结果
     */
    @ExceptionHandler(ServiceException.class)
    public Result handleServiceException(ServiceException e) {
        SERVICE_LOGGER.info(e.toString());
//        e.printStackTrace();
        return new Result(ResultStatus.ERROR);
    }
}
