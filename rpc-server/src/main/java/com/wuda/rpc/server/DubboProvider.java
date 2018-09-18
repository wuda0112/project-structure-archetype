package com.wuda.rpc.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

/**
 * 例子来自于dubbo官网,稍微改造了一下,以spring boot方式运行.
 *
 * @author wuda
 */
@EnableConfigurationProperties
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.wuda")
@MapperScan("com.wuda.dao.mysql.mapper")
@ImportResource("classpath:dubbo-demo-provider.xml")
public class DubboProvider {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DubboProvider.class, args);
        System.in.read();
    }
}