package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author qjj
 * @create 2020/3/29 17:20
 */
@Data
@ApiModel
public class PddGoodsUnitQueryRequest {

    @ApiModelProperty(required = true, value = "商品id")
    @NotNull(message = "goodsId不能为空")
    private Long goodsId;

    @ApiModelProperty(value = "招商duoId")
    private Long zsDuoId;

}
