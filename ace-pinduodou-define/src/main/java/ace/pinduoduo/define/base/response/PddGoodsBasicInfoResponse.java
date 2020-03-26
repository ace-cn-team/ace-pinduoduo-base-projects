package ace.pinduoduo.define.base.response;

import lombok.Data;

import java.util.List;

@Data
public class PddGoodsBasicInfoResponse {

    private List<PddGoodsBasicInfoResponse.GoodsBasicDetailResponseGoodsListItem>  goodsBasicDetailList;

    @Data
    public static class GoodsBasicDetailResponseGoodsListItem {
        private Long goodsId;

        private Long minNormalPrice;

        private Long minGroupPrice;

        private String goodsPic;

        private String goodsName;
    }

}
