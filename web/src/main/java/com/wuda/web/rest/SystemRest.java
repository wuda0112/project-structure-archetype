package com.wuda.web.rest;

import com.wuda.common.lang.web.Response;
import com.wuda.common.lang.web.ResponseCode;
import com.wuda.service.api.SystemService;
import com.wuda.service.model.PingDto;
import com.wuda.web.vo.PingVo;
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
@RequestMapping(path = "/rest/system/")
public class SystemRest {

    @Autowired
    private SystemService systemService;

    @RequestMapping(path = "ping", method = RequestMethod.GET)
    public Response<PingVo> ping() {
        PingDto pingDto = systemService.ping();
        PingVo pingVo = PingVo.from(pingDto);
        return new Response<>(ResponseCode.OK, pingVo);
    }

    @RequestMapping(path = "ping/mysql", method = RequestMethod.GET)
    public Response<PingVo> pingMysql() {
        PingDto pingDto = systemService.pingMysql();
        PingVo pingVo = PingVo.from(pingDto);
        return new Response<>(ResponseCode.OK, pingVo);
    }
}
