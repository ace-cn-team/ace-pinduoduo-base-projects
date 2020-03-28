package ace.pinduoduo.define.base.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class PddGoodsPidQueryResponse {

    @ApiModelProperty(value = "多多进宝推广位对象列表")
    private List<PIdQueryResponsePIdItemList> pIdList;

    @ApiModelProperty(value = "返回推广位总数")
    private Long totalCount;

    @Data
    @ApiModel
    public static class PIdQueryResponsePIdItemList {

        @ApiModelProperty(value = "推广位生成时间")
        private Long createTime;

        @ApiModelProperty(value = "推广位名称")
        private String pidName;

        @ApiModelProperty(value = "推广位ID")
        private String pId;

    }
}
