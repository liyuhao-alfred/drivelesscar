package com.liyuhao.drivelesscar.exception;

/**
 * TODO electronic DefaultException 应该继承自 Exception，以便于声明
 *
 * @author liyuhao
 */
public class DefaultException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String msg;

    public DefaultException(String msg, Throwable t) {
        super(msg, t);
        this.msg = msg;
    }

    public DefaultException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
