package com.wuda.web.mvc.controller;

import com.wuda.service.api.SystemService;
import com.wuda.service.model.PingDTO;
import com.wuda.web.model.constant.PathConstant;
import com.wuda.web.model.response.PingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 提供系统的信息.系统可以是应用本身,也可以是操作系统,也可以是物理主机.
 *
 * @author wuda
 */
@Controller
public class SystemController {

    @Autowired
    private SystemService systemService;

    @RequestMapping(path = PathConstant.MVC_SYSTEM_CONTROLLER_PING
            , method = RequestMethod.GET)
    public String ping(Model model) {
        PingDTO pingDTO = systemService.ping();
        PingResponse pingResponse = PingResponse.from(pingDTO);
        model.addAttribute("pingResponse", pingResponse);
        return "system/ping";
    }

    @RequestMapping(path = PathConstant.MVC_SYSTEM_CONTROLLER_PING_MYSQL
            , method = RequestMethod.GET)
    public String pingMysql(Model model) {
        PingDTO pingDTO = systemService.pingMysql();
        PingResponse pingResponse = PingResponse.from(pingDTO);
        model.addAttribute("pingResponse", pingResponse);
        return "system/ping";
    }

}
