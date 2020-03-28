package ace.pinduoduo.define.base.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class PddThemeListResponse {

    private Integer total;

    private List<ThemeListGetResponseThemeItemList>  themeListGetResponseThemeItemListList;

    @ApiModel
    @Data
    public static class ThemeListGetResponseThemeItemList {

        @ApiModelProperty(value = "主题ID")
        private Long id;

        @ApiModelProperty(value = "主题图片")
        private String imageUrl;

        @ApiModelProperty(value = "主题名称")
        private String name;

        @ApiModelProperty(value = "主题包含的商品数量")
        private Long goodsNum;

    }

}
