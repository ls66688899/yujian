package com.shun.yujian.user.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author luoshun
 * @since 2023/6/27
 */
@Data
public class UserRegistDto {
    @NotEmpty(message = "用户名必须提交")
    private String userName;
    @NotEmpty(message = "密码必须提交")
    private String password;
    @NotEmpty(message = "电话必须提交")
    @Pattern(regexp = "^[1][0-9]{10}$",message = "手机号格式存在问题")
    private String phone;
    @NotEmpty(message = "验证码必须填写")
    private String code;
}
