package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class PddOrderListIncrementGetRequest {

    @ApiModelProperty(required = true, value = "最近90天内多多进宝商品订单更新时间--查询时间开始。note：此时间为时间戳，指格林威治时间 1970 年01 月 01 日 00 时 00 分 00 秒(北京时间 1970 年 01 月 01 日 08 时 00 分 00 秒)起至现在的总秒数")
    @NotNull(message = "startUpdateTime不能为空")
    private Long startUpdateTime;

    @ApiModelProperty(required = true, value = "查询结束时间，和开始时间相差不能超过24小时。note：此时间为时间戳，指格林威治时间 1970 年01 月 01 日 00 时 00 分 00 秒(北京时间 1970 年 01 月 01 日 08 时 00 分 00 秒)起至现在的总秒数")
    @NotNull(message = "endUpdateTime不能为空")
    private Long endUpdateTime;

    @ApiModelProperty(value = "返回的每页结果订单数，默认为100，范围为10到100，建议使用40~50，可以提高成功率，减少超时数量。")
    private Integer pageSize;

    @ApiModelProperty(value = "第几页，从1到10000，默认1，注：使用最后更新时间范围增量同步时，必须采用倒序的分页方式（从最后一页往回取）才能避免漏单问题。")
    private Integer page;

    @ApiModelProperty(value = "是否返回总数，默认为true，如果指定false, 则返回的结果中不包含总记录数，通过此种方式获取增量数据，效率在原有的基础上有80%的提升。")
    private Boolean returnCount;
}
