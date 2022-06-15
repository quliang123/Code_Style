package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: Code_Style
 * @description:
 * @author: quliang
 * @create: 2022-06-15 11:21
 **/
@SpringBootApplication
public class AppBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(AppBootstrap.class, args);
        System.out.println("Hello world!");
    }
}
