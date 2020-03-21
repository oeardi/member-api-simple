package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PreDestroy;

/**
 * 如果启动报 com.mongodb.MongoSocketOpenException: Exception opening socket（不是 100% 会报）
 * 是因为 Springboot 自动配置了支持 mongodb 在启动 Springboot 时会自动实例化一个 mongo 实例，需要禁用自动配置。
 * 需要在 @SpringBootApplication 标签增加参数 (exclude = MongoAutoConfiguration.class)
 *
 * @author difeng
 */
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class Application {

    @Autowired
    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {

        context = SpringApplication.run(Application.class, args);

    }

    @PreDestroy
    public void close() {
        context.close();
    }
}
