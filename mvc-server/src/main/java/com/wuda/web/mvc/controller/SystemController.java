package com.wuda.web.controller;

import com.wuda.service.api.SystemService;
import com.wuda.service.model.PingDto;
import com.wuda.web.model.PingVo;
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
@RequestMapping(path = "/controller/system/")
public class SystemController {

    @Autowired
    private SystemService systemService;

    @RequestMapping(path = "ping", method = RequestMethod.GET)
    public String ping(Model model) {
        PingDto pingDto = systemService.ping();
        PingVo pingVo = PingVo.from(pingDto);
        model.addAttribute("pingVo", pingVo);
        return "system/ping";
    }

    @RequestMapping(path = "ping/mysql", method = RequestMethod.GET)
    public String pingMysql(Model model) {
        PingDto pingDto = systemService.pingMysql();
        PingVo pingVo = PingVo.from(pingDto);
        model.addAttribute("pingVo", pingVo);
        return "system/ping";
    }

}
