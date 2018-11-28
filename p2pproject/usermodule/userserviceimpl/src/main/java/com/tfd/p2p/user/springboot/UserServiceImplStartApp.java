package com.tfd.p2p.user.springboot;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.tfd.p2p.user.service","com.tfd.p2p.user.springboot"})
@DubboComponentScan(basePackages = {"com.tfd.p2p.user.service","com.tfd.p2p.user.springboot"})
@MapperScan(basePackages = "com.tfd.p2p.user.mapper")
public class UserServiceImplStartApp {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceImplStartApp.class,args);
    }
}
