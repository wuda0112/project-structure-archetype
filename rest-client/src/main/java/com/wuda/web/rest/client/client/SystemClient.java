package com.wuda.web.rest.client.client;

import com.wuda.common.lang.response.Result;
import com.wuda.web.model.constant.ApplicationConstant;
import com.wuda.web.model.constant.PathConstant;
import com.wuda.web.model.response.PingResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * system controller的客户端.
 *
 * @author wuda
 */
@FeignClient(ApplicationConstant.APP_NAME_REST_SERVER)
public interface SystemClient {

    @RequestMapping(path = PathConstant.REST_SYSTEM_CONTROLLER_PING, method = RequestMethod.GET)
    Result<PingResponse> ping();

    @RequestMapping(path = PathConstant.REST_SYSTEM_CONTROLLER_PING_MYSQL, method = RequestMethod.GET)
    Result<PingResponse> pingMysql();

}