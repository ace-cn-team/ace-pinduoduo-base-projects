package ace.pinduoduo.define.base.response;

import lombok.Data;

import java.util.List;

@Data
public class PddGoodsBasicDetailResponse {

    private List<PddGoodsBasicDetailResponse.GoodsBasicDetailResponseGoodsListItem>  goodsBasicDetailList;

    @Data
    public static class GoodsBasicDetailResponseGoodsListItem {
        private Long goodsId;

        private Long minNormalPrice;

        private Long minGroupPrice;

        private String goodsPic;

        private String goodsName;
    }

}
