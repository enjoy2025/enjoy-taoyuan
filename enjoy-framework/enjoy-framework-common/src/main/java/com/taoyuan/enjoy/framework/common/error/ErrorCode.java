package com.taoyuan.enjoy.framework.common.error;

/**
 * 错误码接口
 * 所有错误码枚举必须实现该接口
 */
public interface ErrorCode {

    /**
     * 错误码
     */
    int getCode();

    /**
     * 错误信息
     */
    String getMessage();
}