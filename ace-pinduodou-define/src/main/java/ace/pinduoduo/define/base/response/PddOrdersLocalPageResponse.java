package ace.pinduoduo.define.base.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qjunjia
 */
@ApiModel
@Data
public class PddOrdersLocalPageResponse {

    @ApiModelProperty(value = "推广订单编号")
    private String orderSn;

    @ApiModelProperty(value = "商品ID")
    private Long goodsId;

    @ApiModelProperty(value = "商品标题")
    private String goodsName;

    @ApiModelProperty(value = "商品缩略图")
    private String goodsThumbnailUrl;

    @ApiModelProperty(value = "购买商品的数量")
    private Long goodsQuantity;

    @ApiModelProperty(value = "订单中sku的单件价格，单位为分")
    private Long goodsPrice;

    @ApiModelProperty(value = "实际支付金额，单位为分")
    private Long orderAmount;

    @ApiModelProperty(value = "推广位ID")
    private String pId;

    @ApiModelProperty(value = "佣金比例，千分比")
    private Long promotionRate;

    @ApiModelProperty(value = "佣金金额，单位为分")
    private Long promotionAmount;

    @ApiModelProperty(value = "订单状态： -1 未支付; 0-已支付；1-已成团；2-确认收货；3-审核成功；4-审核失败（不可提现）；5-已经结算；8-非多多进宝商品（无佣金订单）")
    private Integer orderStatus;

    @ApiModelProperty(value = "订单状态描述")
    private String orderStatusDesc;

    @ApiModelProperty(value = "订单生成时间，UNIX时间戳")
    private Long orderCreateTime;

    @ApiModelProperty(value = "支付时间")
    private Long orderPayTime;

    @ApiModelProperty(value = "成团时间")
    private Long orderGroupSuccessTime;

    @ApiModelProperty(value = "审核时间")
    private Long orderVerifyTime;

    @ApiModelProperty(value = "最后更新时间")
    private Long orderModifyAt;

    @ApiModelProperty(value = "自定义参数")
    private String customParameters;

    @ApiModelProperty(value = "是否是 cpa 新用户，1表示是，0表示否")
    private Integer cpaNew;

    @ApiModelProperty(value = "订单推广类型")
    private Integer type;

    @ApiModelProperty(value = "结算时间")
    private Long orderSettleTime;

    @ApiModelProperty(value = "多多客工具id")
    private Long authDuoId;

    @ApiModelProperty(value = "结算批次号")
    private String batchNo;

    @ApiModelProperty(value = "确认收货时间")
    private Long orderReceiveTime;

    @ApiModelProperty(value = "成团编号")
    private Long groupId;

    @ApiModelProperty(value = "审核失败原因")
    private String failReason;

    @ApiModelProperty(value = "订单ID")
    private String orderId;

    @ApiModelProperty(value = "招商多多客id")
    private Long zsDuoId;

}
