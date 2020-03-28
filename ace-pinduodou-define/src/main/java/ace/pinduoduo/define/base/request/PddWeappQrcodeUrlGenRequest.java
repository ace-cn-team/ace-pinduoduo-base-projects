package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@ApiModel
public class PddWeappQrcodeUrlGenRequest {

    @ApiModelProperty(required = true, value = "推广位ID")
    @NotNull(message = "推广位ID不能为空")
    private String pId;

    @ApiModelProperty(required = true, value = "商品ID，仅支持单个查询")
    @Size(min = 1, max = 1, message = "商品ID，仅支持单个查询")
    private List<Long> goodsIdList;

    @ApiModelProperty(value = "自定义参数，为链接打上自定义标签。自定义参数最长限制64个字节。")
    @Length(max = 64, message = "自定义参数最长限制64个字节")
    private String customParameters;

    @ApiModelProperty(value = "招商多多客ID")
    private Long zsDuoId;

    @ApiModelProperty(value = "是否生成店铺收藏券推广链接")
    private Boolean generateMallCollectCoupon;

}
