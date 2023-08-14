package com.shun.yujian.third.controller;

import com.shun.yujian.common.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luoshun
 * @since 2023/6/27
 */
@RestController
@RequestMapping("/sms")
public class SmsSendController {


    @GetMapping("/sendcode")
    public R sendCod(@RequestParam("phone") String phone,@RequestParam ("code") String code){
        System.out.println("短信发送");
        return R.ok().put("hello","duanxin");
    }
}
