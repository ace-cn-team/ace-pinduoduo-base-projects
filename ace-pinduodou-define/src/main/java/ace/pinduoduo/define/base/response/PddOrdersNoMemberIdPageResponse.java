package ace.pinduoduo.define.base.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qjunjia
 */
@ApiModel
@Data
public class PddOrdersNoMemberIdPageResponse {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "自定义参数")
    private String customParameters;

    @ApiModelProperty(value = "订单ID")
    private String orderId;

}
