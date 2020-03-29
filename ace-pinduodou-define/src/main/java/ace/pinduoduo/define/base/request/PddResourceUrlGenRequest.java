package ace.pinduoduo.define.base.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author qjj
 * @create 2020/3/29 17:20
 */
@Data
@ApiModel
public class PddResourceUrlGenRequest {

    @ApiModelProperty(value = "自定义参数，为链接打上自定义标签。自定义参数最长限制64个字节")
    private String customParameters;

    @ApiModelProperty(value = "是否生成qq小程序")
    private Boolean generateQqApp;

    @ApiModelProperty(value = "是否返回 schema URL")
    private Boolean generateSchemaUrl;

    @ApiModelProperty(value = "是否生成小程序")
    private Boolean generateWeApp;

    @ApiModelProperty(required = true, value = "推广位")
    @NotBlank(message = "pid不能为空")
    private String pid;

    @ApiModelProperty(value = "频道来源：4-限时秒杀,39997-充值中心, 39998-转链type，39999-电器城，39996-百亿补贴")
    private Integer resourceType;

    @ApiModelProperty(value = "原链接")
    private String url;
}
