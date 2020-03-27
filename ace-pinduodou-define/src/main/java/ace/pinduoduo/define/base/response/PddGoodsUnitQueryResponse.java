package ace.pinduoduo.define.base.response;

import lombok.Data;

@Data
public class PddGoodsUnitQueryResponse {
        /**
         * 优惠券结束时间，单位：秒
         */
        private Long couponEndTime;

        /**
         * 优惠券id
         */
        private String couponId;

        /**
         * 优惠券开始时间，单位：秒
         */
        private Long couponStartTime;

        /**
         * 优惠券面额，单位：厘
         */
        private Integer discount;

        /**
         * 优惠券总数量
         */
        private Long initQuantity;

        /**
         * 商品的佣金比例，单位：千分位，比如100，表示10%
         */
        private Integer rate;

        /**
         * 优惠券剩余数量
         */
        private Long remainQuantity;

        /**
         * 商品的推广计划类型，1-通用推广，2-专属推广，3-招商推广，4-全店推广
         */
        private Integer unitType;
}
