package ace.pinduoduo.define.base.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class PddPIdGenerateResponse {

    private List<PIdGenerateItemResponse> pIdGenerateItemResponseList;

    @Data
    @ApiModel
    public static class PIdGenerateItemResponse {

        /**
         * 推广位创建时间
         */
        private Long createTime;

        /**
         * 推广位名称
         */
        private String pidName;

        /**
         * 调用方推广位ID
         */
        private String pId;

    }

}
