package com.shun.yujian.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/*
一。使用nacos作为配置中心统一管理配置
* 1.引入配置中心依赖
* 2.创建一个bootstrap.properties
* 3.给配置中心默认添加一个叫  数据及data id 应用名.properties
* 4.给应用名.properties添加任何配置
* 5.动态获取配置
* @RefreshScope： 动态获取配置
* @Value（“${}”）
* 如果配置中心和当前应用的配置文件中都配置相同的项，优先使用配置中心
二。细节
1.命名空间：配置隔离
默认：public
  1）开发，测试，生产,利用命名空间做环境隔离
  在bootstrap.properties配置上需要指定哪个命名空间下的配置。
  spring.cloud.nacos.config.namespace=915dfca6-2b05-474e-b7a3-4496de81a2c3
  2）每个微服务之间相互隔离，每个微服务建立命名空间
2.配置集：所有配置集合
3.配置集id：类似配置文件名
    DataId：类似配置文件名
4.配置分组
  默认所有配置集都属于：DEFAULT_GROUP;
  618 1111
  每个微服务创建自己的命名空间，使用配置分组区分环境dev，test，prod

三同时加载多个配置集
1)微服务任何配置信息，任何配置文件都可以放在配置中心中
2)只需要在bootstrap。properties说明加载配置中心中哪些配置文件即可
3)@Value。。
以前springboot任何方法从配置文件中获取值，都能使用

* */
@EnableRedisHttpSession
@SpringBootApplication
@EnableDiscoveryClient
public class YujianProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(YujianProductApplication.class, args);
    }

}
