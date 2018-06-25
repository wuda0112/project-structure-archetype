package com.wuda.service.api;

import com.wuda.service.model.PingDto;

/**
 * 系统服务类.方便了解当前系统的各种元数据和运行时状态.
 *
 * @author wuda
 */
public interface SystemService {

    /**
     * 没有任何业务逻辑的ping.
     *
     * @return ping info
     */
    PingDto ping();

    /**
     * 在mysql中执行查询语句,以达到ping的效果.
     *
     * @return mysql ping info
     */
    PingDto pingMysql();

}
