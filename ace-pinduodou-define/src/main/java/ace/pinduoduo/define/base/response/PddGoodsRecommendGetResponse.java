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
public class PddGoodsRecommendGetResponse {

    @ApiModelProperty(value = "total")
    private Integer total;

    @ApiModelProperty(value = "列表")
    private List<GoodsBasicDetailResponseListItem> list;

    @ApiModelProperty(value = "搜索id，转链时必填，影响收益")
    private String searchId;

    @ApiModelProperty(value = "翻页时必填前页返回的list_id值")
    private String listId;

    @Data
    @ApiModel
    public static class GoodsBasicDetailResponseListItem {

        @ApiModelProperty(value = "二维码主图")
        private String qrCodeImageUrl;

        @ApiModelProperty(value = "分享描述")
        private String shareDesc;

        @ApiModelProperty(value = "商品类目id")
        private String catId;

        @ApiModelProperty(value = "商品评价数量")
        private Long goodsEvalCount;

        @ApiModelProperty(value = "市场服务费")
        private Long marketFee;

        @ApiModelProperty(value = "商品等级")
        private Long goodsRate;

        @ApiModelProperty(value = "优惠券金额")
        private Long couponPrice;

        @ApiModelProperty(value = "佣金比例,千分比")
        private Long promotionRate;

        @ApiModelProperty(value = "优惠券失效时间,UNIX时间戳")
        private Long couponEndTime;

        @ApiModelProperty(value = "优惠券生效时间,UNIX时间戳")
        private Long couponStartTime;

        @ApiModelProperty(value = "优惠券剩余数量")
        private Long couponRemainQuantity;

        @ApiModelProperty(value = "优惠券总数量")
        private Long couponTotalQuantity;

        @ApiModelProperty(value = "优惠券面额,单位为分")
        private Long couponDiscount;

        @ApiModelProperty(value = "优惠券门槛价格,单位为分")
        private Long couponMinOrderAmount;

        @ApiModelProperty(value = "优惠券id")
        private Long couponId;

        @ApiModelProperty(value = "商品是否带券,true-带券,false-不带券")
        private Boolean hasCoupon;

        @ApiModelProperty(value = "商品类型")
        private Integer goodsType;

        @ApiModelProperty(value = "商品一~四级类目ID列表")
        private List<Long> catIds;

        @ApiModelProperty(value = "商品一~四级标签类目ID列表")
        private List<Long> optIds;

        @ApiModelProperty(value = "商品标签名")
        private String optName;

        @ApiModelProperty(value = "商品标签类目ID,使用pdd.goods.opt.get获取")
        private String optId;

        @ApiModelProperty(value = "分类名称")
        private String categoryName;

        @ApiModelProperty(value = "类目id")
        private String categoryId;

        @ApiModelProperty(value = "商家类型")
        private String merchantType;

        @ApiModelProperty(value = "店铺名称")
        private String mallName;

        @ApiModelProperty(value = "商家id")
        private Long mallId;

        @ApiModelProperty(value = "最小单买价格，单位分")
        private Long minNormalPrice;

        @ApiModelProperty(value = "最小成团价格，单位分")
        private Long minGroupPrice;

        @ApiModelProperty(value = "商品实际价格")
        private Long goodsFactPrice;

        @ApiModelProperty(value = "商品标准价格")
        private Long goodsMarkPrice;

        @ApiModelProperty(value = "商品详情图列表")
        private String goodsGalleryUrls;

        @ApiModelProperty(value = "商品主图")
        private String goodsImageUrl;

        @ApiModelProperty(value = "商品缩略图")
        private String goodsThumbnailUrl;

        @ApiModelProperty(value = "商品描述")
        private String goodsDesc;

        @ApiModelProperty(value = "商品名称")
        private String goodsName;

        @ApiModelProperty(value = "商品id")
        private Long goodsId;

        @ApiModelProperty(value = "创建时间")
        private Long createAt;

        @ApiModelProperty(value = "销售量")
        private String salesTip;

        @ApiModelProperty(value = "描述分")
        private String descTxt;

        @ApiModelProperty(value = "服务分")
        private String servTxt;

        @ApiModelProperty(value = "物流分")
        private String lgstTxt;

        @ApiModelProperty(value = "搜索id")
        private String searchId;
    }
}
