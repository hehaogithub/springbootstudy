package com.bootstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@MapperScan("com.bootstudy.mapper")
@SpringBootApplication()
public class BootStart{
    public static void main(String[] args) {
        SpringApplication.run(BootStart.class, args);
    }

}
