package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

@Data
public class PddGoodsDetailRequest {

    @ApiModelProperty(required=true, value="商品id,仅支持单个查询", example = "[123456]")
    @Size(min=1, max=1)
    private List<Long> goodsIdList;

    @ApiModelProperty(required=false, value="推广位id")
    private String pid;

    @ApiModelProperty(required=false, value="自定义参数")
    private String customParameters;

    @ApiModelProperty(required=false, value="招商多多客ID")
    private Long zsDuoId;

    @ApiModelProperty(required=false, value="佣金优惠券对应推广类型，3：专属 4：招商")
    private Integer planType;

    @ApiModelProperty(required=false, value="搜索id，建议填写，提高收益")
    private String searchId;

}
