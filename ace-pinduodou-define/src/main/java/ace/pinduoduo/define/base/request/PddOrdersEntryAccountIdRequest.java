package ace.pinduoduo.define.base.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author qjunjia
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class PddOrdersEntryAccountIdRequest {

    List<PddOrdersEntryAccountIdItemRequest>  pddOrdersEntryAccountIdItemRequestList;

    @Data
    @ApiModel
    public static class PddOrdersEntryAccountIdItemRequest{
        @ApiModelProperty(value = "主键")
        private String id;

        @ApiModelProperty(required = true, value = "账号id")
        @NotEmpty(message = "accountId不能为空")
        private String accountId;
    }



}
