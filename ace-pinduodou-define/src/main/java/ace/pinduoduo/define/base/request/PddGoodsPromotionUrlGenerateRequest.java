package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@ApiModel
public class PddGoodsPromotionUrlGenerateRequest {

    @ApiModelProperty(required = true, value = "推广位ID")
    @NotEmpty(message = "推广位ID不能为空")
    private String pId;

    @ApiModelProperty(required = true, value = "商品ID，仅支持单个查询")
    private List<Long> goodsIdList;

    @ApiModelProperty(value = "是否生成短链接，true-是，false-否")
    private Boolean generateShortUrl;

    @ApiModelProperty(value = "true--生成多人团推广链接 false--生成单人团推广链接（默认false）1、单人团推广链接：用户访问单人团推广链接，可直接购买商品无需拼团。2、多人团推广链接：用户访问双人团推广链接开团，若用户分享给他人参团，则开团者和参团者的佣金均结算给推手")
    private Boolean multiGroup;

    @ApiModelProperty(value = "自定义参数，为链接打上自定义标签。自定义参数最长限制64个字节。")
    private String customParameters;

    @ApiModelProperty(value = "是否生成唤起微信客户端链接，true-是，false-否，默认false")
    private Boolean generateWeappWebview;

    @ApiModelProperty(value = "招商多多客ID")
    private Long zsDuoId;

    @ApiModelProperty(value = "是否生成小程序推广")
    private Boolean generateWeApp;

    @ApiModelProperty(value = "是否生成微博推广链接")
    private Boolean generateWeiboappWebview;

    @ApiModelProperty(value = "是否生成店铺收藏券推广链接")
    private Boolean generateMallCollectCoupon;

    @ApiModelProperty(value = "是否返回 schema URL")
    private Boolean generateSchemaUrl;

    @ApiModelProperty(value = "是否生成qq小程序")
    private Boolean generateQqApp;

    @ApiModelProperty(value = "搜索id，必填，否则影响收益")
    private String searchId;
}
