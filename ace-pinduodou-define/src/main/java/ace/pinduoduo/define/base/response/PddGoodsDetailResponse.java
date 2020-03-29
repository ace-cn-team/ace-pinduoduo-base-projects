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
public class PddGoodsDetailResponse {

    private List<GoodsDetailResponseGoodsDetailsItem> goodsDetails;

    @Data
    @ApiModel
    public static class GoodsDetailResponseGoodsDetailsItem {
        @ApiModelProperty(value = "店铺优惠券id")
        private Long mallCouponId;

        @ApiModelProperty(value = "店铺折扣")
        private Integer mallCouponDiscountPct;

        @ApiModelProperty(value = "最小使用金额")
        private Integer mallCouponMinOrderAmount;

        @ApiModelProperty(value = "最大使用金额")
        private Integer mallCouponMaxDiscountAmount;

        @ApiModelProperty(value = "店铺券总量")
        private Long mallCouponTotalQuantity;

        @ApiModelProperty(value = "店铺券余量")
        private Long mallCouponRemainQuantity;

        @ApiModelProperty(value = "店铺券使用开始时间")
        private Long mallCouponStartTime;

        @ApiModelProperty(value = "店铺券使用结束时间")
        private Long mallCouponEndTime;

        @ApiModelProperty(value = "参与多多进宝的商品ID")
        private Long goodsId;

        @ApiModelProperty(value = "参与多多进宝的商品标题")
        private String goodsName;

        @ApiModelProperty(value = "参与多多进宝的商品描述")
        private String goodsDesc;

        @ApiModelProperty(value = "多多进宝商品主图")
        private String goodsImageUrl;

        @ApiModelProperty(value = "商品轮播图")
        private List<String> goodsGalleryUrls;

        @ApiModelProperty(value = "最低价sku的拼团价，单位为分")
        private Long minGroupPrice;

        @ApiModelProperty(value = "最低价sku的单买价，单位为分")
        private Long minNormalPrice;

        @ApiModelProperty(value = "店铺名称")
        private String mallName;

        @ApiModelProperty(value = "商品标签ID，使用pdd.goods.opt.get接口获取")
        private Long optId;

        @ApiModelProperty(value = "商品标签名称")
        private String optName;

        @ApiModelProperty(value = "商品标签ID")
        private List<Integer> optIds;

        @ApiModelProperty(value = "商品一~四级类目ID列表")
        private List<Integer> catIds;

        @ApiModelProperty(value = "优惠券门槛金额，单位为分")
        private Long couponMinOrderAmount;

        @ApiModelProperty(value = "优惠券面额，单位为分")
        private Long couponDiscount;

        @ApiModelProperty(value = "优惠券总数量")
        private Long couponTotalQuantity;

        @ApiModelProperty(value = "优惠券剩余数量")
        private Long couponRemainQuantity;

        @ApiModelProperty(value = "优惠券生效时间，UNIX时间戳")
        private Long couponStartTime;

        @ApiModelProperty(value = "优惠券失效时间，UNIX时间戳")
        private Long couponEndTime;

        @ApiModelProperty(value = "佣金比例，千分比")
        private Long promotionRate;

        @ApiModelProperty(value = "商品评价数")
        private Long goodsEvalCount;

        @ApiModelProperty(value = "商品类目ID，使用pdd.goods.cats.get接口获取")
        private Long catId;

        @ApiModelProperty(value = "已售卖件数")
        private String salesTip;

        @ApiModelProperty(value = "商家id")
        private Long mallId;

        @ApiModelProperty(value = "服务标签: 4-送货入户并安装,5-送货入户,6-电子发票,9-坏果包赔,11-闪电退款,12-24小时发货,13-48小时发货,17-顺丰包邮,18-只换不修,19-全国联保,20-分期付款,24-极速退款,25-品质保障,26-缺重包退,27-当日发货,28-可定制化,29-预约配送,1000001-正品发票,1000002-送货入户并安装")
        private List<Integer> serviceTags;

        @ApiModelProperty(value = "店铺收藏券id")
        private String cltCpnBatchSn;

        @ApiModelProperty(value = "店铺收藏券起始时间")
        private Long cltCpnStartTime;

        @ApiModelProperty(value = "店铺收藏券截止时间")
        private Long cltCpnEndTime;

        @ApiModelProperty(value = "店铺收藏券总量")
        private Long cltCpnQuantity;

        @ApiModelProperty(value = "店铺收藏券剩余量")
        private Long cltCpnRemainQuantity;

        @ApiModelProperty(value = "店铺收藏券面额，单位为分")
        private Long cltCpnDiscount;

        @ApiModelProperty(value = "店铺收藏券使用门槛价格，单位为分")
        private Long cltCpnMinAmt;

        @ApiModelProperty(value = "描述分")
        private String descTxt;

        @ApiModelProperty(value = "服务分")
        private String servTxt;

        @ApiModelProperty(value = "物流分")
        private String lgstTxt;

        @ApiModelProperty(value = "推广计划类型")
        private Integer planType;

        @ApiModelProperty(value = "招商团长id")
        private Long zsDuoId;

        @ApiModelProperty(value = "快手专享")
        private Boolean onlySceneAuth;
    }

}
