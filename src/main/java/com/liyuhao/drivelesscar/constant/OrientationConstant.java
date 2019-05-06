package com.liyuhao.drivelesscar.constant;

import com.liyuhao.drivelesscar.exception.DefaultException;

public enum OrientationConstant {
    North("North"),
    South("South"),
    West("West"),
    East("East");

    private String code;

    private OrientationConstant(String code) {
        this.code = code;
    }

    public static OrientationConstant getByCode(String code) {
        for (OrientationConstant examType : OrientationConstant.values()) {
            if (code.equals(examType.getCode())) {
                return examType;
            }
        }
        throw new DefaultException(String.format("不支持code=%d的类型", code));
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
