package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author qjj
 * @create 2020/3/29 17:20
 */
@Data
@ApiModel
public class PddTopGoodsListRequest{

    @ApiModelProperty(value="推广位id")
    private String pId;

    @ApiModelProperty(value="从多少位置开始请求；默认值:0，offset需是limit的整数倍，仅支持整页翻页")
    private Integer offset = 0;

    @ApiModelProperty(value="1-实时热销榜；2-实时收益榜")
    private Integer sortType;

    @ApiModelProperty(value="请求数量；默认值:10,最大100")
    private Integer limit = 10;

    @ApiModelProperty(value="翻页时建议填写前页返回的list_id值")
    private String listId;

}
