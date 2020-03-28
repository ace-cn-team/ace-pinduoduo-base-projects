package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class PddThemeGoodsSearchRequest {

    @ApiModelProperty(required = true, value = "主题ID")
    @NotNull(message = "主题ID不能为空")
    private Long themeId;

}
