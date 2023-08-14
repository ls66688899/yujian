package com.shun.yujian.auth.feign;

import com.shun.yujian.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author luoshun
 * @since 2023/6/27
 */
@FeignClient("yujian-third")
public interface ThirdFeignService {

    @GetMapping("sms/sendcode")
    public R sendCod(@RequestParam("phone") String phone, @RequestParam ("code") String code);
}
