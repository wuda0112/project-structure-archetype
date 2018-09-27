package com.wuda.rpc.client.controller;

import com.wuda.common.lang.response.Result;
import com.wuda.rpc.client.service.SystemServiceInterface;
import com.wuda.service.model.PingDTO;
import com.wuda.web.model.constant.PathConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供系统的信息.系统可以是应用本身,也可以是操作系统,也可以是物理主机.
 *
 * @author wuda
 */
@RestController
public class SystemController {

    @Autowired
    private SystemServiceInterface systemServiceInterface;

    @RequestMapping(path = PathConstant.MVC_SYSTEM_CONTROLLER_PING
            , method = RequestMethod.GET)
    @ResponseBody
    public Result<PingDTO> ping(Model model) {
        return systemServiceInterface.ping();
    }

    @RequestMapping(path = PathConstant.MVC_SYSTEM_CONTROLLER_PING_MYSQL
            , method = RequestMethod.GET)
    @ResponseBody
    public Result<PingDTO> pingMysql(Model model) {
        return systemServiceInterface.pingMysql();
    }

}
