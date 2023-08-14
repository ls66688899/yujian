package com.shun.yujian.user.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.shun.yujian.common.utils.R;
import com.shun.yujian.user.dto.UserLoginDto;
import com.shun.yujian.user.dto.UserRegistDto;
import com.shun.yujian.user.entity.UserEntity;
import com.shun.yujian.user.exception.PhoneExistException;
import com.shun.yujian.user.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author luoshun
 * @since 2023/6/27
 */
@RestController
@RequestMapping("user/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("regist")
    public R regist(@RequestBody UserRegistDto userRegistDto) {
        //检查手机号是否唯一
        List<UserEntity> list = userService.list(Wrappers.<UserEntity>lambdaQuery().eq(UserEntity::getPhone, userRegistDto.getPhone()));
        if (list.size() > 1) {
            //不唯一
            return R.error("注册失败,手机号重复");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userRegistDto.getUserName());
        userEntity.setPhone(userRegistDto.getPhone());
        //加密存储
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode(userRegistDto.getPassword());
        userEntity.setPassword(encode);

        userService.save(userEntity);

        return R.ok();
    }

    @PostMapping("login")
    public R login(@RequestBody UserLoginDto userLoginDto) {
        //检查手机号是否唯一
        UserEntity userEntity = userService.getOne(Wrappers.<UserEntity>lambdaQuery().eq(UserEntity::getPhone, userLoginDto.getLoginAccount()));

        //加密存储
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean matches = passwordEncoder.matches(userLoginDto.getPassword(), userEntity.getPassword());
        if (matches) {
            //登录成功
            return R.ok();
        }else {
            //登录失败
            return R.error();
        }
    }

}
