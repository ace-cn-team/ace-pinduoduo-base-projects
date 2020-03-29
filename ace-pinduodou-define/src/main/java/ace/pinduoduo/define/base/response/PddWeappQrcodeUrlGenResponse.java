package ace.pinduoduo.define.base.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author qjj
 * @create 2020/3/29 17:20
 */
@Data
@ApiModel
public class PddWeappQrcodeUrlGenResponse {

    /**
     * 单品推广小程序二维码url
     */
    private String url;

}
