package com.guanys.shardingproxy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.guanys.shardingproxy.order.mapper")
@SpringBootApplication
public class ShardingProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingProxyApplication.class, args);
    }

}
