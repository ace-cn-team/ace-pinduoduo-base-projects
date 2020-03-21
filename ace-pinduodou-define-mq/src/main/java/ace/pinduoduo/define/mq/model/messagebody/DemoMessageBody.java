package ace.pinduoduo.define.mq.model.messagebody;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/2/3 12:19
 * @description
 */
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemoMessageBody {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "应用id")
    private String appId;

    @ApiModelProperty(value = "账号id")
    private String accountId;

    @ApiModelProperty(value = "账号")
    private String account;


    @ApiModelProperty(value = "创建时间")
    private LocalDateTime loginTime;
    @ApiModelProperty(value = "ip")
    private String ip;
}
