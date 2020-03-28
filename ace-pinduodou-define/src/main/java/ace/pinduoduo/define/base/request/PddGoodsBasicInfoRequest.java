package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@ApiModel
public class PddGoodsBasicInfoRequest {

    @ApiModelProperty(required=true, value="商品id")
    @Size(min=1, max=100, message = "商品id数量在1到100之间")
    private List<Long> goodsIdList;

}
