package com.wuda.web.mvc;

import com.wuda.common.configuration.Swagger2Configuration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * 应用启动类.
 *
 * @author wuda
 */
@SpringBootApplication
@Import({Swagger2Configuration.class})
@ComponentScan(basePackages = "com.wuda")
@MapperScan(basePackages = "com.wuda.dao.**.mapper")
public class MvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);
    }
}
