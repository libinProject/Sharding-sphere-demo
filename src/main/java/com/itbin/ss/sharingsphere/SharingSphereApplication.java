package com.itbin.ss.sharingsphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.itbin.ss.sharingsphere.mapper")
public class SharingSphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharingSphereApplication.class, args);
    }

}

