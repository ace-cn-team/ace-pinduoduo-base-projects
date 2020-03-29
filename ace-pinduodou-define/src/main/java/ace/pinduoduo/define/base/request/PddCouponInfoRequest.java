package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author qjj
 * @create 2020/3/29 17:20
 * @description 查询优惠券信息
 */
@Data
@ApiModel
public class PddCouponInfoRequest {

    @ApiModelProperty(required=true, value="优惠券id")
    @Size(min=1, max=100, message = "优惠券id数量在1到100之间")
    private List<String> couponIds;

}
