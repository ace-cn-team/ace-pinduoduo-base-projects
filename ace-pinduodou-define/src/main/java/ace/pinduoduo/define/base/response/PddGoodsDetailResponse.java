package ace.pinduoduo.define.base.response;

import lombok.Data;

import java.util.List;

@Data
public class PddGoodsDetailResponse {

    private List<GoodsDetailResponseGoodsDetailsItem> goodsDetails;

    @Data
    public static class GoodsDetailResponseGoodsDetailsItem {
        private Long mallCouponId;
        private Integer mallCouponDiscountPct;
        private Integer mallCouponMinOrderAmount;
        private Integer mallCouponMaxDiscountAmount;
        private Long mallCouponTotalQuantity;
        private Long mallCouponRemainQuantity;
        private Long mallCouponStartTime;
        private Long mallCouponEndTime;
        private Long goodsId;
        private String goodsName;
        private String goodsDesc;
        private String goodsImageUrl;
        private List<String> goodsGalleryUrls;
        private Long minGroupPrice;
        private Long minNormalPrice;
        private String mallName;
        private Long optId;
        private String optName;
        private List<Integer> optIds;
        private List<Integer> catIds;
        private Long couponMinOrderAmount;
        private Long couponDiscount;
        private Long couponTotalQuantity;
        private Long couponRemainQuantity;
        private Long couponStartTime;
        private Long couponEndTime;
        private Long promotionRate;
        private Long goodsEvalCount;
        private Long catId;
        private String salesTip;
        private Long mallId;
        private List<Integer> serviceTags;
        private String cltCpnBatchSn;
        private Long cltCpnStartTime;
        private Long cltCpnEndTime;
        private Long cltCpnQuantity;
        private Long cltCpnRemainQuantity;
        private Long cltCpnDiscount;
        private Long cltCpnMinAmt;
        private String descTxt;
        private String servTxt;
        private String lgstTxt;
        private Integer planType;
        private Long zsDuoId;
        private Boolean onlySceneAuth;
    }

}
