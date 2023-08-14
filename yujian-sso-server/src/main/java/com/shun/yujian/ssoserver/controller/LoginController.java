package com.shun.yujian.ssoserver.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author luoshun
 * @since 2023/6/30
 */
@Controller
public class LoginController {

    @Autowired
    StringRedisTemplate redisTemplate;

    /*
     * 根据用户信息得到用户对象
     * */
    @ResponseBody
    @GetMapping("userInfo")
    public String userInfo(@RequestParam("token") String token) {
        return redisTemplate.opsForValue().get(token);
    }


    @GetMapping("/login.html")
    public String loginPage(@RequestParam("redirect_url") String url, Model model, @CookieValue(value = "sso_token", required = false) String sso_token) {
        if (StringUtils.isNotEmpty(sso_token)) {
            //说明之前有人登录过
            return "redirect:" + url + "?token=" + sso_token;
        }

        model.addAttribute("url", url);
        return "login";
    }


    @PostMapping("/doLogin")
    public String doLogin(@RequestParam("username") String username, @RequestParam("password") String password
            , @RequestParam("url") String url, HttpServletResponse httpServletResponse) {
        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {

            //登录成功跳转，跳回到之前的页面
            //1.设置
            String uuid = UUID.randomUUID().toString().replace("_", "");
            redisTemplate.opsForValue().set(uuid, username);

            Cookie cookie = new Cookie("sso_token", uuid);
            httpServletResponse.addCookie(cookie);

            return "redirect:" + url + "?token=" + uuid;
        }


        return "login";
    }


}
