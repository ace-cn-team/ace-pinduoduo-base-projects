package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

@Data
public class PddCouponInfoRequest {

    @ApiModelProperty(required=true, value="优惠券id")
    @Size(min=1, max=100)
    private List<String> couponIds;

}
