package com.wuda.web.rest.client.api;

import com.wuda.common.lang.response.Result;
import com.wuda.web.model.response.PingResponse;
import org.junit.Test;

/**
 * {@link SystemClient}测试类.
 *
 * @author wuda
 */
public class SystemClientTest {

    @Test
    public void ping() {
        SystemClient client = SystemClient.connect();
        Result<PingResponse> result = client.ping();
        System.out.println(result);
    }

    @Test
    public void pingMysql() {
        SystemClient client = SystemClient.connect();
        Result<PingResponse> result = client.pingMysql();
        System.out.println(result);
    }
}
