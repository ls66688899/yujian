package com.shun.yujian.auth.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author luoshun
 * @since 2023/6/28
 */
@Data
public class UserLoginDto implements Serializable {

    private String loginAccount;
    private String password;

}
