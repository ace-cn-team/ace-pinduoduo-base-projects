package ace.pinduoduo.define.base.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class PddThemeGoodsSearchResponse {

    private Long total;

    private List<ThemeListGetResponseGoodsItemList> goodsList;

    @Data
    public static class ThemeListGetResponseGoodsItemList {
        /**
         * 商品编码
         */
        private Long goodsId;

        /**
         * 商品名称
         */
        private String goodsName;

        /**
         * 商品描述
         */
        private String goodsDesc;

        /**
         * 商品缩略图
         */
        private String goodsThumbnailUrl;

        /**
         * 商品主图
         */
        private String goodsImageUrl;

        /**
         * 商品详情图列表
         */
        private List<String> goodsGalleryUrls;

        /**
         * 最小拼团价格,单位为分
         */
        private Long minGroupPrice;

        /**
         * 最小单买价格,单位为分
         */
        private Long minNormalPrice;

        /**
         * 店铺名称
         */
        private String mallName;

        /**
         * 商品标签类目ID,使用pdd.goods.opt.get获取
         */
        private Long optId;

        /**
         * 商品标签名
         */
        private String optName;

        /**
         * 商品一~四级类目ID列表
         */
        private List<Integer> catIds;

        /**
         * 商品是否带券,true-带券,false-不带券
         */
        private Boolean hasCoupon;

        /**
         * 优惠券门槛价格,单位为分
         */
        private Long couponMinOrderAmount;

        /**
         * 优惠券面额,单位为分
         */
        private Long couponDiscount;

        /**
         * 优惠券总数量
         */
        private Long couponTotalQuantity;

        /**
         * 优惠券剩余数量
         */
        private Long couponRemainQuantity;

        /**
         * 优惠券生效时间,UNIX时间戳
         */
        private Long couponStartTime;

        /**
         * 优惠券失效时间,UNIX时间戳
         */
        private Long couponEndTime;

        /**
         * 佣金比例,千分比
         */
        private Long promotionRate;

        /**
         * 商品评价数量
         */
        private Long goodsEvalCount;

        /**
         * 已售卖件数
         */
        private String salesTip;

        /**
         * 描述分
         */
        private String descTxt;

        /**
         * 服务分
         */
        private String servTxt;

        /**
         * 物流分
         */
        private String lgstTxt;

    }
}
