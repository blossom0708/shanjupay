package com.shanjupay.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TransactionBootstrap {
    // 创建bean到容器中 https://blog.csdn.net/qq_44973310/article/details/128302144
    public static void main(String[] args) {
        SpringApplication.run(TransactionBootstrap.class,args);
    }
}