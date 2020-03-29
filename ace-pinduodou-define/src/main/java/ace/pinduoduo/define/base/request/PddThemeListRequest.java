package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;

/**
 * @author qjj
 * @create 2020/3/29 17:20
 */
@Data
@ApiModel
public class PddThemeListRequest {

    @ApiModelProperty(value = "返回的一页数据数量")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "返回的页码")
    private Integer page;

}
