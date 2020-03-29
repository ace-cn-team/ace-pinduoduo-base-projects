package ace.pinduoduo.define.base.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author qjj
 * @create 2020/3/29 17:20
 * @description 优惠券信息
 */
@Data
@ApiModel
public class PddCouponInfoResponse {

    private List<CouponInfoResponseItemList> couponInfoResponseItemListList;

    @Data
    @ApiModel
    public static class CouponInfoResponseItemList {

        @ApiModelProperty(value = "优惠券结束时间")
        private Long couponEndTime;

        @ApiModelProperty(value = "优惠券id")
        private String couponId;

        @ApiModelProperty(value = "优惠券开始时间")
        private Long couponStartTime;

        @ApiModelProperty(value = "优惠券类型")
        private Integer couponType;

        @ApiModelProperty(value = "优惠券面额 单位：厘")
        private Long discount;

        @ApiModelProperty(value = "优惠券总量")
        private Long initQuantity;

        @ApiModelProperty(value = "优惠券剩余数量")
        private Long remainQuantity;

    }
}
