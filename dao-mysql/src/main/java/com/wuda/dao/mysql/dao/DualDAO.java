package com.wuda.dao.mysql.dao;

import com.wuda.dao.mysql.mapper.DualMapper;
import com.wuda.dao.mysql.response.PingDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * dual　DAO.
 *
 * @author wuda
 */
@Repository
public class DualDAO {

    @Autowired
    private DualMapper dualMapper;

    /**
     * 执行select 1 from dual语句,达到ping效果.
     *
     * @return ping info
     */
    public PingDO ping() {
        PingDO pingDO = new PingDO();
        boolean success;
        String message;
        try {
            dualMapper.ping();
            success = true;
            message = "ping mysql ok!";
        } catch (Exception e) {
            success = false;
            message = "ping mysql failed ! brief message is:" + e.getMessage();
        }
        pingDO.setSuccess(success);
        pingDO.setMessage(message);
        return pingDO;
    }
}
