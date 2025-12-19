package com.taoyuan.enjoy.framework.common.enums;

/**
 * 逻辑删除标记枚举
 */
public enum DeletedEnum {

    /**
     * 未删除
     */
    NO(0, "未删除"),

    /**
     * 已删除
     */
    YES(1, "已删除");

    private final int code;
    private final String desc;

    DeletedEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
