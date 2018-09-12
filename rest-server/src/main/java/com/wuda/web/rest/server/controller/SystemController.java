package com.wuda.web.rest.server.controller;

import com.wuda.common.lang.response.Result;
import com.wuda.service.api.SystemService;
import com.wuda.service.model.PingDTO;
import com.wuda.web.model.constant.PathConstant;
import com.wuda.web.model.response.PingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供系统的信息.系统可以是应用本身,也可以是操作系统,也可以是物理主机.
 *
 * @author wuda
 */
@RestController
public class SystemController {

    @Autowired
    private SystemService systemService;

    @RequestMapping(path = PathConstant.REST_SYSTEM_CONTROLLER_PING
            , method = RequestMethod.GET)
    public Result<PingResponse> ping() {
        Result<PingDTO> pingDTOResult = systemService.ping();
        PingResponse pingResponse = PingResponse.from(pingDTOResult.getContent());
        return new Result<>(pingDTOResult.getResultDesc(), pingResponse);
    }

    @RequestMapping(path = PathConstant.REST_SYSTEM_CONTROLLER_PING_MYSQL
            , method = RequestMethod.GET)
    public Result<PingResponse> pingMysql() {
        Result<PingDTO> pingDTOResult = systemService.pingMysql();
        PingResponse pingResponse = PingResponse.from(pingDTOResult.getContent());
        return new Result<>(pingDTOResult.getResultDesc(), pingResponse);
    }
}
