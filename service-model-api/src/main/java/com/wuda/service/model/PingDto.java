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
public class PingDto implements Serializable {

    /**
     * 消息内容.
     */
    private String message;
    /**
     * 版权内容.
     */
    private String copyright;
}
