package com.wuda.service.impl;

import com.wuda.common.configuration.CoreProperty;
import com.wuda.dao.mysql.dao.DualDAO;
import com.wuda.dao.mysql.response.PingDO;
import com.wuda.service.api.SystemService;
import com.wuda.service.model.PingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuda
 */
@Service(value = SystemServiceImpl.NAME)
public class SystemServiceImpl implements SystemService {

    /**
     * my bean name.
     */
    public final static String NAME = "systemService";

    @Autowired
    private DualDAO dualDAO;

    @Autowired
    private CoreProperty coreProperty;

    @Override
    public PingDTO ping() {
        PingDTO info = new PingDTO();
        info.setSuccess(true);
        info.setMessage("app ping ok");
        return info;
    }

    @Override
    public PingDTO pingMysql() {
        long start = System.currentTimeMillis();
        PingDO pingDO = dualDAO.ping();
        long end = System.currentTimeMillis();
        long time = end - start;
        PingDTO info = new PingDTO();
        info.setSuccess(pingDO.isSuccess());
        info.setMessage(pingDO.getMessage());
        info.setTime(time);
        return info;
    }
}