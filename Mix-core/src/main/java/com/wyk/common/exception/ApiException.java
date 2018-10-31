package com.wyk.common.exception;

import com.wyk.common.api.IErrorCode;

/**
 * <p>
 * REST API 请求异常类
 * </p>
 *
 * @author wyk
 * @since 2017-06-26
 */
public class ApiException extends RuntimeException {

    /**
     * 错误码
     */
    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}