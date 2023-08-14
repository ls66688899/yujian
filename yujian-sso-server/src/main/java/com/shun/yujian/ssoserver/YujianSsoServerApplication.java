package com.shun.yujian.ssoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class YujianSsoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(YujianSsoServerApplication.class, args);
    }

}
