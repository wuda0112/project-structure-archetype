package com.wuda.rpc.server;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * 例子来自于dubbo官网,稍微改造了一下,以spring boot方式运行.
 *
 * @author wuda
 */
@EnableConfigurationProperties
@SpringBootApplication
@ComponentScan("com.wuda")
@MapperScan("com.wuda.dao.mysql.mapper")
@DubboComponentScan(basePackages = "com.wuda.service.impl")
public class DubboProvider {

    public static void main(String[] args) {
        SpringApplication.run(DubboProvider.class, args);
    }
}