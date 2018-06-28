package com.wuda.web.rest.server.controller;

import com.wuda.common.lang.web.Response;
import com.wuda.common.lang.web.ResponseCode;
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
    public Response<PingResponse> ping() {
        PingDTO pingDTO = systemService.ping();
        PingResponse pingResponse = PingResponse.from(pingDTO);
        Response<PingResponse> response = new Response<>();
        response.setResponseCode(ResponseCode.OK);
        response.setContent(pingResponse);
        return response;
    }

    @RequestMapping(path = PathConstant.REST_SYSTEM_CONTROLLER_PING_MYSQL
            , method = RequestMethod.GET)
    public Response<PingResponse> pingMysql() {
        PingDTO pingDTO = systemService.pingMysql();
        PingResponse pingResponse = PingResponse.from(pingDTO);
        Response<PingResponse> response = new Response<>();
        response.setResponseCode(ResponseCode.OK);
        response.setContent(pingResponse);
        return response;
    }
}
