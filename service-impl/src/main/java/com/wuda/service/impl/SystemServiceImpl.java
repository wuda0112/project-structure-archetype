package com.wuda.service.impl;

import com.wuda.common.lang.response.CommonResultDesc;
import com.wuda.common.lang.response.Result;
import com.wuda.dao.mysql.mapper.SystemMapper;
import com.wuda.service.api.SystemService;
import com.wuda.service.model.PingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wuda
 */
@Service(value = SystemServiceImpl.BEAN_NAME)
public class SystemServiceImpl implements SystemService {

    public final static String BEAN_NAME = "systemService";

    @Autowired
    private SystemMapper systemMapper;

    @Override
    public Result<PingDTO> ping() {
        PingDTO info = new PingDTO();
        info.setSuccess(true);
        info.setMessage("app ping ok");
        return new Result<>(CommonResultDesc.OK, info);
    }

    @Override
    public Result<PingDTO> pingMysql() {
        boolean success;
        String message;
        long start = System.currentTimeMillis();
        try {
            systemMapper.ping();
            success = true;
            message = "ping mysql ok!";
        } catch (Exception e) {
            success = false;
            message = "ping mysql failed ! brief message is:" + e.getMessage();
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        PingDTO info = new PingDTO();
        info.setSuccess(success);
        info.setMessage(message);
        info.setTime(time);
        return new Result<>(success ? CommonResultDesc.OK : CommonResultDesc.FAIL, info);
    }
}