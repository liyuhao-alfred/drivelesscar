package com.liyuhao.drivelesscar.constant;

import com.liyuhao.drivelesscar.exception.DefaultException;

public enum CommandConstant {

    clockwise("clockwise"),
    anticlockwise("anticlockwise"),
    forward("forward"),
    backward("backward");

    private String code;

    private CommandConstant(String code) {
        this.code = code;
    }

    public static CommandConstant getByCode(String code) {
        for (CommandConstant examType : CommandConstant.values()) {
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