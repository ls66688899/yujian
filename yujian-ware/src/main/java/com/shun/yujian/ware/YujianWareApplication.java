package com.shun.yujian.ware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class YujianWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(YujianWareApplication.class, args);
    }

}
