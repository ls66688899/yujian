package com.shun.yujian.user.exception;

/**
 * @author luoshun
 * @since 2023/6/27
 */
public class PhoneExistException extends RuntimeException {

    public PhoneExistException() {
        super("手机号存在");
    }

}
