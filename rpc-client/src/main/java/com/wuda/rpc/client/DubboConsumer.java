package com.wuda.rpc.client;

import com.wuda.service.api.SystemService;
import com.wuda.service.model.PingDto;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 例子来自于dubbo官网.
 */
public class DubboConsumer {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"dubbo-demo-consumer.xml"});
        context.start();
        // obtain proxy object for remote invocation
        SystemService systemService = (SystemService) context.getBean("systemService");
        // execute remote invocation
        PingDto pingDto = systemService.ping();
        // show the result
        System.out.println(pingDto);
    }
}
