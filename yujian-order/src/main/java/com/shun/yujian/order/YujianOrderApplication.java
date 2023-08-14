package com.shun.yujian.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/*
* 1.引入openfign
* 2.编写接口，告诉springcloud这个接口需要远程服务
* 3.声明接口的每一个方法都是调用哪个远程服务的哪个请求
* 4.开启远程调用功能
* */
@EnableFeignClients(basePackages = "com.shun.yujian.order.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class YujianOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(YujianOrderApplication.class, args);
    }

}
