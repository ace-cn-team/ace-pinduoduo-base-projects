package ace.pinduoduo.define.base.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author qjj
 * @create 2020/3/29 17:20
 */
@Data
@ApiModel
public class PddGoodsPromotionUrlGenerateResponse {

    private List<GoodsPromotionUrlGenerateResponseGoodsPromotionUrlItemList> goodsPromotionUrlList;

    @Data
    @ApiModel
    public static class GoodsPromotionUrlGenerateResponseGoodsPromotionUrlItemList {

        @ApiModelProperty(value = "唤起微信app推广短链接")
        private String weAppWebViewShortUrl;

        @ApiModelProperty(value = "唤起微信app推广链接")
        private String weAppWebViewUrl;

        @ApiModelProperty(value = "唤醒拼多多app的推广短链接")
        private String mobileShortUrl;

        @ApiModelProperty(value = "唤醒拼多多app的推广长链接")
        private String mobileUrl;

        @ApiModelProperty(value = "推广短链接")
        private String shortUrl;

        @ApiModelProperty(value = "推广长链接")
        private String url;

        @ApiModelProperty(value = "小程序信息")
        private GoodsPromotionUrlGenerateResponseGoodsPromotionUrlListItemWeAppInfo weAppInfo;

        @ApiModelProperty(value = "微博推广短链接")
        private String weiboAppWebViewShortUrl;

        @ApiModelProperty(value = "微博推广链接")
        private String weiboAppWebViewUrl;

        @ApiModelProperty(value = "schema的链接")
        private String schemaUrl;

        @ApiModelProperty(value = "qq小程序信息")
        private GoodsPromotionUrlGenerateResponseGoodsPromotionUrlListItemQqAppInfo qqAppInfo;

    }

    @Data
    @ApiModel
    public static class GoodsPromotionUrlGenerateResponseGoodsPromotionUrlListItemWeAppInfo {

        @ApiModelProperty(value = "小程序图片")
        private String weAppIconUrl;

        @ApiModelProperty(value = "Banner图")
        private String bannerUrl;

        @ApiModelProperty(value = "描述")
        private String desc;

        @ApiModelProperty(value = "来源名")
        private String sourceDisplayName;

        @ApiModelProperty(value = "小程序path值")
        private String pagePath;

        @ApiModelProperty(value = "用户名")
        private String userName;

        @ApiModelProperty(value = "小程序标题")
        private String title;

        @ApiModelProperty(value = "拼多多小程序id")
        private String appId;

    }

    @Data
    @ApiModel
    public static class GoodsPromotionUrlGenerateResponseGoodsPromotionUrlListItemQqAppInfo {

        @ApiModelProperty(value = "拼多多小程序id")
        private String appId;

        @ApiModelProperty(value = "Banner图")
        private String bannerUrl;

        @ApiModelProperty(value = "描述")
        private String desc;

        @ApiModelProperty(value = "小程序path值")
        private String pagePath;

        @ApiModelProperty(value = "小程序icon")
        private String qqAppIconUrl;

        @ApiModelProperty(value = "来源名")
        private String sourceDisplayName;

        @ApiModelProperty(value = "小程序标题")
        private String title;

        @ApiModelProperty(value = "用户名")
        private String userName;
    }

}
