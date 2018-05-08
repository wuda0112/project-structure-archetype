package com.wuda.web.vo;

import com.wuda.common.lang.web.Vo;
import com.wuda.service.model.PingDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wuda
 */
@Getter
@Setter
@ApiModel(description = "ping返回内容")
public class PingVo implements Vo {

    @ApiModelProperty(notes = "消息内容")
    private String message;
    @ApiModelProperty(notes = "版权")
    private String copyright;

    /**
     * 从{@link PingDto}生成{@link PingVo}.
     *
     * @param pingDto
     *         ping info
     * @return ping vo
     */
    public static PingVo from(PingDto pingDto) {
        PingVo pingVo = new PingVo();
        pingVo.message = pingDto.getMessage();
        pingVo.copyright = pingDto.getCopyright();
        return pingVo;
    }

}
