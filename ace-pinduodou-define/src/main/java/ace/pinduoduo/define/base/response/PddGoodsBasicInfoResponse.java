package ace.pinduoduo.define.base.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author qjj
 * @create 2020/3/29 17:20
 */
@Data
@ApiModel
public class PddGoodsBasicInfoResponse {

    private List<PddGoodsBasicInfoResponse.GoodsBasicDetailResponseGoodsListItem>  goodsBasicDetailList;

    @Data
    @ApiModel
    public static class GoodsBasicDetailResponseGoodsListItem {

        @ApiModelProperty(value = "商品id")
        private Long goodsId;

        @ApiModelProperty(value = "最小单买价格，单位分")
        private Long minNormalPrice;

        @ApiModelProperty(value = "最小成团价格，单位分")
        private Long minGroupPrice;

        @ApiModelProperty(value = "商品缩略图")
        private String goodsPic;

        @ApiModelProperty(value = "商品标题")
        private String goodsName;
    }

}
