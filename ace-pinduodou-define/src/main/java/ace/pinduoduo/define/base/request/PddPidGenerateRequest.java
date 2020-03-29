package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.List;

/**
 * @author qjj
 * @create 2020/3/29 17:20
 */
@Data
@ApiModel
public class PddPidGenerateRequest {

    @ApiModelProperty(required = true, value = "要生成的推广位数量，默认为10，范围为：1~10")
    @Range(min = 1, max = 10)
    private Long number = 10L;

    @ApiModelProperty(required = true, value = "推广位名称，例如[1,2]")
    private List<String> pIdNameList;

}
