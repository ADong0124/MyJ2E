package com.tfd.p2p.user.springboot;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.tfd.p2p.user")
@DubboComponentScan(basePackages = "com.tfd.p2p.user")
public class UserControllerStartApp {
    public static void main(String[] args) {
        SpringApplication.run(UserControllerStartApp.class,args);
    }
}
