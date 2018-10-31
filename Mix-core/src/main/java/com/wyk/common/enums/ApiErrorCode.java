package com.wyk.common.enums;

import com.wyk.common.api.IErrorCode;

/**
 * <p>
 * REST API 错误码
 * </p>
 *
 * @author wyk
 * @since 2018-10-15
 */
public enum ApiErrorCode implements IErrorCode {
    /**
     * 失败
     */
    FAILED(-1, "失败"),
    /**
     * 成功
     */
    SUCCESS(0, "成功");

    private final long code;
    private final String msg;

    ApiErrorCode(final long code, final String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ApiErrorCode fromCode(long code) {
        ApiErrorCode[] ecs = ApiErrorCode.values();
        for (ApiErrorCode ec : ecs) {
            if (ec.getCode() == code) {
                return ec;
            }
        }
        return SUCCESS;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return String.format(" ErrorCode:{code=%s, msg=%s} ", code, msg);
    }
}
