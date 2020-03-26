package ace.pinduoduo.define.base.response;

import lombok.Data;

import java.util.List;

@Data
public class PddCouponInfoResponse {

    private List<CouponInfoResponseItemList> couponInfoResponseItemListList;

    @Data
    public static class CouponInfoResponseItemList {

        /**
         * 优惠券结束时间
         */
        private Long couponEndTime;

        /**
         * 优惠券id
         */
        private String couponId;

        /**
         * 优惠券开始时间
         */
        private Long couponStartTime;

        /**
         * 优惠券类型
         */
        private Integer couponType;

        /**
         * 优惠券面额 单位：厘
         */
        private Long discount;

        /**
         * 优惠券总量
         */
        private Long initQuantity;

        /**
         * 优惠券剩余数量
         */
        private Long remainQuantity;

    }
}
