package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author qjj
 * @create 2020/3/29 17:20
 */
@Data
@ApiModel
public class PddOrderDetailGetRequest {

    @ApiModelProperty(value = "订单号")
    @NotBlank(message = "订单号不能为空")
    private String orderSn;

}
