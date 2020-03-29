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
public class PddGoodsRecommendGetRequest {

    @ApiModelProperty(value = "从多少位置开始请求；默认值 ： 0，offset需是limit的整数倍，仅支持整页翻页")
    private Integer offset;

    @ApiModelProperty(value = "请求数量；默认值 ： 10")
    private Integer limit = 10;

    @ApiModelProperty(value = "频道类型；0, \"1.9包邮\", 1, \"今日爆款\", 2, \"品牌清仓\", 非必填 ,默认是1")
    private Integer channelType;

    @ApiModelProperty(value = "推广位id")
    private String pid;

    @ApiModelProperty(value = "自定义参数")
    private String customParameters;

    @ApiModelProperty(value = "翻页时必填前页返回的list_id值")
    private String listId;
    
}
