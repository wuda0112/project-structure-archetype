package com.wuda.rpc.client.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wuda.common.lang.response.Result;
import com.wuda.service.api.SystemService;
import com.wuda.service.model.PingDTO;
import org.springframework.stereotype.Component;

@Component
public class SystemServiceInterface {

    @Reference
    private SystemService systemService;

    public Result<PingDTO> ping() {
        return systemService.ping();
    }

    public Result<PingDTO> pingMysql() {
        return systemService.pingMysql();
    }
}
