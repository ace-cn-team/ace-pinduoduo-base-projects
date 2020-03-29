package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author qjj
 * @create 2020/3/29 17:20
 */
@Data
@ApiModel
public class PddGoodsPidQueryRequest {

    @ApiModelProperty(value = "返回的页数")
    private Integer page;

    @ApiModelProperty(value = "返回的每页推广位数量")
    private Integer pageSize;

    @ApiModelProperty(value = "推广位id列表")
    private List<String> pidList;

}
