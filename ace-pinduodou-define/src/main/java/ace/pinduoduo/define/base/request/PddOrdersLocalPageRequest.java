package ace.pinduoduo.define.base.request;


import ace.fw.data.model.request.resful.PageQueryRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

/**
 * @author qjunjia
 */
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class PddOrdersLocalPageRequest{

    private Integer pageIndex = 0;

    private Integer pageSize = 10;

    @ApiModelProperty(required = true, value = "账号id")
    @NotEmpty(message = "accountId不能为空")
    private String accountId;

}
