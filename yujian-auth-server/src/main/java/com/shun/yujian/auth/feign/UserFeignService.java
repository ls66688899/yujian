package com.shun.yujian.auth.feign;

import com.shun.yujian.auth.dto.UserLoginDto;
import com.shun.yujian.auth.dto.UserRegistDto;
import com.shun.yujian.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author luoshun
 * @since 2023/6/28
 */
@FeignClient("yujian-user")
public interface UserFeignService {

    @PostMapping("user/user/regist")
    public R regist(@RequestBody UserRegistDto userRegistDto);

    @PostMapping("user/user/login")
    public R login(@RequestBody UserLoginDto userLoginDto);
}
