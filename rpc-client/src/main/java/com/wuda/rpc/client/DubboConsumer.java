package com.wuda.rpc.client;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.wuda.common.configuration.Swagger2Configuration;
import com.wuda.rpc.client.conf.DubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 例子来自于dubbo官网.
 *
 * @author wuda
 */
@SpringBootApplication
@Import({Swagger2Configuration.class, DubboConfiguration.class})
@ComponentScan("com.wuda")
@DubboComponentScan(basePackages = "com.wuda.rpc.client.service")
public class DubboConsumer {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumer.class, args);
    }
}
