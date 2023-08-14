package com.shun.yujian.common.exception;

/**
 * @author luoshun
 * @since 2023/6/27
 */
public enum BusinessCodeEnume {
    UNKNOW_EXCEPTION(10000,"系统异常"),
    VAILD_SMS_CODE_EXCEPTION(10000,"系统异常");

    private int code;
    private String msg;

    BusinessCodeEnume(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
