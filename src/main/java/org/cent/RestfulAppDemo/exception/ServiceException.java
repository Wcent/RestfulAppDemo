package org.cent.RestfulAppDemo.exception;

import org.cent.RestfulAppDemo.service.ResultStatus;

/**
 * 服务业务逻辑处理异常类
 * @author cent
 * @version 1.0
 */
public class ServiceException extends RuntimeException {
    private ResultStatus status;

    /**
     * 有参构造异常类，指明出错原因
     * @param status 结果状态枚举，包含出错信息
     */
    public ServiceException(ResultStatus status) {
        super(status.getMsg());
    }

    public ResultStatus getStatus() {
        return status;
    }
}
