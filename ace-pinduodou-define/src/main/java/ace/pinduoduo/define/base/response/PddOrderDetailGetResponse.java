package ace.pinduoduo.define.base.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class PddOrderDetailGetResponse {

    @ApiModelProperty(value = "订单编号")
    private String orderSn;

    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品缩略图")
    private String goodsThumbnailUrl;

    @ApiModelProperty(value = "商品数量")
    private Long goodsQuantity;

    @ApiModelProperty(value = "商品价格（分）")
    private Long goodsPrice;

    @ApiModelProperty(value = "订单价格（分）")
    private Long orderAmount;

    @ApiModelProperty(value = "佣金比例 千分比")
    private Long promotionRate;

    @ApiModelProperty(value = "佣金（分）")
    private Long promotionAmount;

    @ApiModelProperty(value = "结算批次号")
    private String batchNo;

    @ApiModelProperty(value = "订单状态")
    private Integer orderStatus;

    @ApiModelProperty(value = "订单状态描述（ -1 未支付; 0-已支付；1-已成团；2-确认收货；3-审核成功；4-审核失败（不可提现）；5-已经结算；8-非多多进宝商品（无佣金订单）;10-已处罚）")
    private String orderStatusDesc;

    @ApiModelProperty(value = "订单创建时间（UNIX时间戳）")
    private Long orderCreateTime;

    @ApiModelProperty(value = "订单支付时间（UNIX时间戳）")
    private Long orderPayTime;

    @ApiModelProperty(value = "订单成团时间（UNIX时间戳）")
    private Long orderGroupSuccessTime;

    @ApiModelProperty(value = "订单确认收货时间（UNIX时间戳）")
    private Long orderReceiveTime;

    @ApiModelProperty(value = "订单审核时间（UNIX时间戳）")
    private Long orderVerifyTime;

    @ApiModelProperty(value = "订单结算时间（UNIX时间戳）")
    private Long orderSettleTime;

    @ApiModelProperty(value = "订单最后更新时间（UNIX时间戳）")
    private Long orderModifyAt;

    @ApiModelProperty(value = "订单类型：0：领券页面， 1： 红包页， 2：领券页， 3： 题页")
    private Integer type;

    @ApiModelProperty(value = "成团编号")
    private Long groupId;

    @ApiModelProperty(value = "多多客工具id")
    private Long authDuoId;

    @ApiModelProperty(value = "招商多多客id")
    private Long zsDuoId;

    @ApiModelProperty(value = "自定义参数")
    private String customParameters;

    @ApiModelProperty(value = "CPS_Sign")
    private String cpsSign;

    @ApiModelProperty(value = "链接最后一次生产时间")
    private Long urlLastGenerateTime;

    @ApiModelProperty(value = "打点时间")
    private Long pointTime;

    @ApiModelProperty(value = " 售后状态：0：无，1：售后中，2：售后完成")
    private Integer returnStatus;

    @ApiModelProperty(value = "推广位id")
    private String pid;

    @ApiModelProperty(value = "是否是 cpa 新用户，1表示是，0表示否")
    private Integer cpaNew;
}
