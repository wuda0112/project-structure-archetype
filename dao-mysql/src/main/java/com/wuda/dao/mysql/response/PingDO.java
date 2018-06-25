package com.wuda.dao.mysql.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ping info.
 *
 * @author wuda
 */
@Getter
@Setter
@ToString
public class PingDO {

    /**
     * 成功或者失败.
     */
    private boolean success;
    /**
     * 消息.
     */
    private String message;
}
