package ace.pinduoduo.define.base.request;

import lombok.Data;

import java.util.List;

@Data
public class PddWeappQrcodeUrlGenRequest {

    /**
     * 推广位ID
     */
    private String pId;

    /**
     * 商品ID，仅支持单个查询
     */
    private List<Long> goodsIdList;

    /**
     * 自定义参数，为链接打上自定义标签。自定义参数最长限制64个字节。
     */
    private String customParameters;

    /**
     * 招商多多客ID
     */
    private Long zsDuoId;

    /**
     * 是否生成店铺收藏券推广链接
     */
    private Boolean generateMallCollectCoupon;

}
