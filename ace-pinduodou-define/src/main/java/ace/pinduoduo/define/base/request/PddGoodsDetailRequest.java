package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@ApiModel
public class PddGoodsDetailRequest {

    @ApiModelProperty(required=true, value="商品id,仅支持单个查询", example = "[123456]")
    @Size(min=1, max=1, message = "商品id数量只能1个")
    private List<Long> goodsIdList;

    @ApiModelProperty(value="推广位id")
    private String pid;

    @ApiModelProperty(value="自定义参数")
    private String customParameters;

    @ApiModelProperty(value="招商多多客ID")
    private Long zsDuoId;

    @ApiModelProperty(value="佣金优惠券对应推广类型，3：专属 4：招商")
    private Integer planType;

    @ApiModelProperty(value="搜索id，建议填写，提高收益")
    private String searchId;

}
