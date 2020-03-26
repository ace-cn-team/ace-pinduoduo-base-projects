package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;

@Data
public class PddTopGoodsListRequest{

    @ApiModelProperty(required=false, value="推广位id")
    private String pId;

    @ApiModelProperty(required=false, value="从多少位置开始请求；默认值:0，offset需是limit的整数倍，仅支持整页翻页")
    private Integer offset;

    @ApiModelProperty(required=false, value="1-实时热销榜；2-实时收益榜")
    @Range(min=1, max=2)
    private Integer sortType;

    @ApiModelProperty(required=false, value="请求数量；默认值:100")
    @Max(100)
    private Integer limit = 10;

    @ApiModelProperty(required=false, value="翻页时建议填写前页返回的list_id值")
    private String listId;

}
