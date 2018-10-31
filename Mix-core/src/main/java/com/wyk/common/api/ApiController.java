package com.wyk.common.api;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * <p>
 * REST API 通用控制器
 * </p>
 *
 * @author wyk
 * @since 2018-06-08
 */
public class ApiController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * <p>
     * 请求成功
     * </p>
     *
     * @param data 数据内容
     * @param <T>  对象泛型
     * @return
     */
    protected <T> Result<T> success(T data) {
        return Result.ok(data);
    }

    /**
     * <p>
     * 请求失败
     * </p>
     *
     * @param msg 提示内容
     * @return
     */
    protected Result<Object> failed(String msg) {
        return Result.failed(msg);
    }

    /**
     * <p>
     * 请求失败
     * </p>
     *
     * @param errorCode 请求错误码
     * @return
     */
    protected Result<Object> failed(IErrorCode errorCode) {
        return Result.failed(errorCode);
    }

}
