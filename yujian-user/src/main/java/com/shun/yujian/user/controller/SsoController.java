package com.shun.yujian.user.controller;

import com.shun.yujian.user.entity.UserEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luoshun
 * @since 2023/6/29
 */
@Controller
public class SsoController {

    @Value("${sso.server.url}")
    private String ssoServerUrl;

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

/*
* 需要感知用户登录成功
* 只要去认证服务器登陆成功跳回来就会带上
* */
    @GetMapping("/users")
    public  String users(Model model, HttpSession session, @RequestParam(value = "token",required = false) String token){

       if (StringUtils.isNotEmpty(token)){
           //说明登录成功，去server后跳回来
           //去ssoserver获取token真正对应用户信息
           RestTemplate restTemplate = new RestTemplate();
           ResponseEntity<String> entity = restTemplate.getForEntity("http://shunssoserver.com:8080/userInfo?token=" + token, String.class);
           String body = entity.getBody();
           session.setAttribute("loginUser",body);

       }

        Object loginUser = session.getAttribute("loginUser");

        if (loginUser != null){
            List<String> users = new ArrayList<>();
            users.add("zhangsan");
            users.add("lisi");
            model.addAttribute("users",users);

            return "list";
        }else {
            //没登录,跳转到登录服务器登录

            return "redirect:" + ssoServerUrl + "?redirect_url=http://user.com:8081/users";
        }

    }

}
