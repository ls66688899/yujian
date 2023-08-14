package com.shun.yujian.auth.controller;

import com.shun.yujian.auth.dto.UserLoginDto;
import com.shun.yujian.auth.dto.UserRegistDto;
import com.shun.yujian.auth.feign.ThirdFeignService;
import com.shun.yujian.auth.feign.UserFeignService;
import com.shun.yujian.common.constant.AuthServerConstant;
import com.shun.yujian.common.exception.BusinessCodeEnume;
import com.shun.yujian.common.utils.R;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author luoshun
 * @since 2023/6/27
 */
@RestController
public class LoginController {

    @Autowired
    private ThirdFeignService thirdFeignService;

    @Autowired
    private UserFeignService userFeignService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/sms/sendcode")
    public R senCode(@RequestParam("phone") String phone) {
        //1.接口防刷
        String redisCode = redisTemplate.opsForValue().get(AuthServerConstant.SMS_CODE_CACHE_PREFIX + phone);
        if (StringUtils.isNotEmpty(redisCode)) {
            long l = Long.parseLong(redisCode.split("_")[1]);
            if (System.currentTimeMillis() - l < 60000) {
                //60秒内不能发
                return R.error(BusinessCodeEnume.VAILD_SMS_CODE_EXCEPTION.getCode(), BusinessCodeEnume.VAILD_SMS_CODE_EXCEPTION.getMsg());
            }
        }

        //2.验证码再次校验。redis. 存key-phone,value-code
        String code = UUID.randomUUID().toString().substring(0, 5);
        String redisCodes = UUID.randomUUID().toString().substring(0, 5) + "_" + System.currentTimeMillis();

        //redis缓存验证码，防止同一个phone在60秒内再次发送验证码
        redisTemplate.opsForValue().set(AuthServerConstant.SMS_CODE_CACHE_PREFIX + phone, redisCodes, 10, TimeUnit.MINUTES);

        R r = thirdFeignService.sendCod("1333333", code);
        System.out.println(r);
        return R.ok();
    }

    @PostMapping("regist")
    public String regist(@RequestBody UserRegistDto userRegistDto) {

        //真正注册，调用远程服务校验
        //1.校验验证码
        String code = userRegistDto.getCode();
        String s = redisTemplate.opsForValue().get(AuthServerConstant.SMS_CODE_CACHE_PREFIX + userRegistDto.getPhone());
        if (StringUtils.isNotEmpty(s)){
            if (code.equals(s.split("_")[0])){
                //删除验证码
                redisTemplate.delete(AuthServerConstant.SMS_CODE_CACHE_PREFIX + userRegistDto.getPhone());
                //验证码通过。真正注册，调用远程服务校验
                R regist = userFeignService.regist(userRegistDto);
                if ((int)regist.get("code") == 0){
                    //成功到首页

                }else {
                    return null;
                }
                //检验手机号是否唯一

            }else {
                return null;
            }
        }else {
            return null;
        }


        return null;
    }


    @PostMapping("login")
    public String login(@RequestBody UserLoginDto userLoginDto){

        R login = userFeignService.login(userLoginDto);
        if ((int)login.get("code")==0){
            return "true";
        }else {
            return "false";
        }
    }
}
