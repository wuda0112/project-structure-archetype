package com.wuda.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * ping返回的信息.
 *
 * @author wuda
 */
@Getter
@Setter
@ToString
public class PingDTO implements Serializable {

    /**
     * 成功或者失败.
     */
    private boolean success;
    /**
     * 消息内容.
     */
    private String message;
    /**
     * 耗时,毫秒.
     */
    private long time;
}
