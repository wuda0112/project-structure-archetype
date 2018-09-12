package com.wuda.web.rest.client.api;

import com.wuda.common.lang.response.Result;
import com.wuda.web.model.constant.HttpMethodConstant;
import com.wuda.web.model.constant.PathConstant;
import com.wuda.web.model.constant.StringConstant;
import com.wuda.web.model.response.PingResponse;
import feign.Feign;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;

/**
 * system controller的客户端.
 *
 * @author wuda
 */
public interface SystemClient {

    @RequestLine(HttpMethodConstant.GET + StringConstant.SPACE + PathConstant.REST_SYSTEM_CONTROLLER_PING)
    Result<PingResponse> ping();

    /**
     * 创建feign client,并且连接.
     *
     * @return system client 实例
     */
    static SystemClient connect() {
        return Feign.builder()
                .decoder(new JacksonDecoder())
                .target(SystemClient.class, "http://localhost:8080");
    }

}