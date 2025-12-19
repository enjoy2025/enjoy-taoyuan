package com.taoyuan.enjoy.framework.common.enums;

public enum YesNoEnum {

    YES(1, "是"),
    NO(0, "否");

    private final int code;
    private final String desc;

    YesNoEnum(int code, String desc) {
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
