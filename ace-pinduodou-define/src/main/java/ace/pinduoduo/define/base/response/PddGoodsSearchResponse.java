package ace.pinduoduo.define.base.response;

import lombok.Data;

import java.util.List;

@Data
public class PddGoodsSearchResponse {

    private List<GoodsSearchResponseGoodsItemList> goodsList;

    private Integer totalCount;

    private String searchId;

    private String listId;

    public static class GoodsSearchResponseGoodsItemList {
        /**
         * 是否有店铺券
         */
        private Boolean hasMallCoupon;

        /**
         * 店铺券id
         */
        private Long mallCouponId;

        /**
         * 店铺券折扣
         */
        private Integer mallCouponDiscountPct;

        /**
         * 最小使用金额
         */
        private Integer mallCouponMinOrderAmount;

        /**
         * 最大使用金额
         */
        private Integer mallCouponMaxDiscountAmount;

        /**
         * 店铺券总量
         */
        private Long mallCouponTotalQuantity;

        /**
         * 店铺券余量
         */
        private Long mallCouponRemainQuantity;

        /**
         * 店铺券开始使用时间
         */
        private Long mallCouponStartTime;

        /**
         * 店铺券结束使用时间
         */
        private Long mallCouponEndTime;

        /**
         * 创建时间（unix时间戳）
         */
        private Long createAt;

        /**
         * 商品id
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
         * 商品轮播图
         */
        private List<String> goodsGalleryUrls;

        /**
         * 最小拼团价（单位为分）
         */
        private Long minGroupPrice;

        /**
         * 最小单买价格（单位为分）
         */
        private Long minNormalPrice;

        /**
         * 店铺名字
         */
        private String mallName;

        /**
         * 店铺类型，1-个人，2-企业，3-旗舰店，4-专卖店，5-专营店，6-普通店
         */
        private Integer merchantType;

        /**
         * 商品类目ID，使用pdd.goods.cats.get接口获取
         */
        private Long categoryId;

        /**
         * 商品类目名
         */
        private String categoryName;

        /**
         * 商品标签ID，使用pdd.goods.opts.get接口获取
         */
        private Long optId;

        /**
         * 商品标签名
         */
        private String optName;

        /**
         * 商品标签id
         */
        private List<Long> optIds;

        /**
         * 商品类目id
         */
        private List<Long> catIds;

        /**
         * 该商品所在店铺是否参与全店推广，0：否，1：是
         */
        private Integer mallCps;

        /**
         * 商品是否有优惠券 true-有，false-没有
         */
        private Boolean hasCoupon;

        /**
         * 优惠券门槛价格，单位为分
         */
        private Long couponMinOrderAmount;

        /**
         * 优惠券面额，单位为分
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
         * 优惠券生效时间，UNIX时间戳
         */
        private Long couponStartTime;

        /**
         * 优惠券失效时间，UNIX时间戳
         */
        private Long couponEndTime;

        /**
         * 佣金比例，千分比
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
         * 活动类型，0-无活动;1-秒杀;3-限量折扣;12-限时折扣;13-大促活动;14-名品折扣;15-品牌清仓;16-食品超市;17-一元幸运团;18-爱逛街;19-时尚穿搭;20-男人帮;21-9块9;22-竞价活动;23-榜单活动;24-幸运半价购;25-定金预售;26-幸运人气购;27-特色主题活动;28-断码清仓;29-一元话费;30-电器城;31-每日好店;32-品牌卡;101-大促搜索池;102-大促品类分会场;
         */
        private Integer activityType;

        /**
         * 服务标签: 4-送货入户并安装,5-送货入户,6-电子发票,9-坏果包赔,11-闪电退款,12-24小时发货,13-48小时发货,17-顺丰包邮,18-只换不修,19-全国联保,20-分期付款,24-极速退款,25-品质保障,26-缺重包退,27-当日发货,28-可定制化,29-预约配送,1000001-正品发票,1000002-送货入户并安装
         */
        private List<Long> serviceTags;

        /**
         * 店铺收藏券id
         */
        private String cltCpnBatchSn;

        /**
         * 店铺收藏券起始时间
         */
        private Long cltCpnStartTime;

        /**
         * 店铺收藏券截止时间
         */
        private Long cltCpnEndTime;

        /**
         * 店铺收藏券总量
         */
        private Long cltCpnQuantity;

        /**
         * 店铺收藏券剩余量
         */
        private Long cltCpnRemainQuantity;

        /**
         * 店铺收藏券面额，单位为分
         */
        private Long cltCpnDiscount;

        /**
         * 店铺收藏券使用门槛价格，单位为分
         */
        private Long cltCpnMinAmt;

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

        /**
         * 推广计划类型 3:定向 4:招商
         */
        private Integer planType;

        /**
         * 招商团长id
         */
        private Long zsDuoId;

        /**
         * 快手专享
         */
        private Boolean onlySceneAuth;

        /**
         * 搜索id，转链时必填，影响收益
         */
        private String searchId;

        /**
         * 商品活动标记数组，例：[4,7]，4-秒杀 7-百亿补贴等
         */
        private List<Integer> activityTags;
    }
}
