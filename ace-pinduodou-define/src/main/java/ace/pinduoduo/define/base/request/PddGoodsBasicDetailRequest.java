package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
public class PddGoodsBasicDetailRequest{

    @ApiModelProperty(required=true, value="商品id")
    @Size(min=1, max=100)
    private List<Long> goodsIdList;

}
