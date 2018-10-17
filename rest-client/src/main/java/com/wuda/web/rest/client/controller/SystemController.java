package com.wuda.web.rest.client.controller;

import com.wuda.common.lang.response.Result;
import com.wuda.web.model.constant.PathConstant;
import com.wuda.web.model.response.PingResponse;
import com.wuda.web.rest.client.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {

    @Autowired
    private SystemClient systemClient;

    @RequestMapping(path = PathConstant.MVC_SYSTEM_CONTROLLER_PING
            , method = RequestMethod.GET)
    @ResponseBody
    public Result<PingResponse> ping() {
        return systemClient.ping();
    }

    @RequestMapping(path = PathConstant.MVC_SYSTEM_CONTROLLER_PING_MYSQL
            , method = RequestMethod.GET)
    @ResponseBody
    public Result<PingResponse> pingMysql() {
        return systemClient.pingMysql();
    }
}
