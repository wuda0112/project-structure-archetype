package com.wuda.web.rest.client;

import com.wuda.common.configuration.Swagger2Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableFeignClients
@Import(Swagger2Configuration.class)
@ComponentScan("com.wuda")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
