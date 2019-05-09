package com.designpattern.strategypattern;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.designpattern.strategypattern.mapper")
public class DesignPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignPatternApplication.class, args);
    }

}
