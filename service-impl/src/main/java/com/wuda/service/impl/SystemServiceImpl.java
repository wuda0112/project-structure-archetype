package com.wuda.service.impl;

import com.wuda.common.configuration.CoreProperty;
import com.wuda.dao.mapper.MysqlDualMapper;
import com.wuda.service.api.SystemService;
import com.wuda.service.model.PingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = SystemServiceImpl.name)
public class SystemServiceImpl implements SystemService {

    /**
     * my bean name.
     */
    public final static String name = "systemService";

    @Autowired
    private MysqlDualMapper mysqlDualMapper;

    @Autowired
    private CoreProperty coreProperty;

    public PingDto ping() {
        PingDto info = new PingDto();
        info.setMessage("app ping ok");
        info.setCopyright(coreProperty.getCopyright());
        return info;
    }

    public PingDto pingMysql() {
        long start = System.currentTimeMillis();
        mysqlDualMapper.ping();
        long end = System.currentTimeMillis();
        long time = end - start;
        PingDto info = new PingDto();
        info.setMessage("mysql ping ok,time=" + (time == 0 ? 1 : time) + "ms");
        info.setCopyright(coreProperty.getCopyright());
        return info;
    }
}