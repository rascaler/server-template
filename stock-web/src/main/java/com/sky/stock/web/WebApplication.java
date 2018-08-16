package com.sky.stock.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @Author: wurenqing
 * @Description:
 * @Date 2017/4/1 14:43
 */
@SpringBootApplication(scanBasePackages = "com.sky.stock")
@ImportResource({"classpath:spring-context.xml","classpath:spring-mvc.xml"})
@PropertySource({"classpath:application.properties"})
//@EnableMongoRepositories(basePackages = {"com.sky.stock.infrastructure.repository"})
public class WebApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }

}
