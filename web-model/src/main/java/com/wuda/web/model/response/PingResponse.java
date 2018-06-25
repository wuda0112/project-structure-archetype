package com.wuda.web.model.response;

import com.wuda.common.lang.web.Vo;
import com.wuda.service.model.PingDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ping返回内容.
 *
 * @author wuda
 */
@Getter
@Setter
@ToString
@ApiModel(description = "ping返回内容")
public class PingResponse implements Vo {

    @ApiModelProperty(notes = "成功或者失败")
    private boolean success;
    @ApiModelProperty(notes = "消息内容")
    private String message;
    @ApiModelProperty(notes = "耗时,毫秒")
    private long time;
    @ApiModelProperty(notes = "版权")
    private String copyright;

    /**
     * 从{@link PingDTO}生成{@link PingResponse}.
     *
     * @param pingDTO
     *         ping info
     * @return ping response info
     */
    public static PingResponse from(PingDTO pingDTO) {
        PingResponse pingResponse = new PingResponse();
        pingResponse.success = pingDTO.isSuccess();
        pingResponse.message = pingDTO.getMessage();
        pingResponse.time = pingDTO.getTime();
        return pingResponse;
    }

}
