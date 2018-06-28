package com.wuda.web.rest.client.api;

import com.wuda.common.lang.web.Response;
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
        Response<PingResponse> response = client.ping();
        System.out.println("response code:" + response.getResponseCode());
        System.out.println(response.getContent().toString());
    }
}
