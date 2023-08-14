package com.shun.yujian.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 属性&属性分组关联
 * 
 * @author luoshun
 * @email
 * @date
 */
@Data
@TableName("user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotEmpty(message = "用户名必须提交")
	private String userName;
	@NotEmpty(message = "密码必须提交")
	private String password;
	@NotEmpty(message = "手机号必须提交")
	private String phone;


}
