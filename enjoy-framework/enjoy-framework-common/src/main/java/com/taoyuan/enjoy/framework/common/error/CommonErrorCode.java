package com.taoyuan.enjoy.framework.common.error;

/**
 * 通用错误码定义
 */
public enum CommonErrorCode implements ErrorCode {

    /**
     * 成功
     */
    SUCCESS(200, "success"),

    /**
     * 系统异常
     */
    SYSTEM_ERROR(500, "系统异常，请稍后再试"),

    /**
     * 参数错误
     */
    PARAM_ERROR(400, "参数错误"),

    /**
     * 非法请求
     */
    ILLEGAL_REQUEST(403, "非法请求"),

    /**
     * 未授权
     */
    UNAUTHORIZED(401, "未登录或登录已过期"),

    /**
     * 无权限
     */
    FORBIDDEN(403, "无访问权限"),

    /**
     * 数据不存在
     */
    DATA_NOT_FOUND(404, "数据不存在"),

    /**
     * 操作失败
     */
    OPERATION_FAILED(500, "操作失败");

    private final int code;
    private final String message;

    CommonErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
