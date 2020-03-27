package ace.pinduoduo.define.base.request;

import lombok.Data;

@Data
public class PddGoodsUnitQueryRequest {

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 招商duoId
     */
    private Long zsDuoId;

}
