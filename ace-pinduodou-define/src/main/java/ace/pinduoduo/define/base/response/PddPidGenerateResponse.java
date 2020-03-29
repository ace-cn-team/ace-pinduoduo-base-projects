package ace.pinduoduo.define.base.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @author qjj
 * @create 2020/3/29 17:20
 */
@Data
@ApiModel
public class PddPidGenerateResponse {

    private List<PidGenerateItemResponse> pIdGenerateItemResponseList;

    @Data
    @ApiModel
    public static class PidGenerateItemResponse {

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
