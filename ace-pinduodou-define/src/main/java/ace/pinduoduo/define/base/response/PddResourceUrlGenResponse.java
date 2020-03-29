package ace.pinduoduo.define.base.response;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author qjj
 * @create 2020/3/29 17:20
 */
@Data
@ApiModel
public class PddResourceUrlGenResponse {

    private ResourceUrlResponseMultiUrlList multiUrlList;

    private ResourceUrlResponseQqAppInfo qqAppInfo;

    private String sign;

    private ResourceUrlResponseSingleUrlList singleUrlList;
    
    private ResourceUrlResponseWeAppInfo weAppInfo;

    @Data
    @ApiModel
    public static class ResourceUrlResponseMultiUrlList {
        
        private String mobileShortUrl;
        
        private String mobileUrl;
        
        private String schemaUrl;
        
        private String shortUrl;
        
        private String url;
        
        private String weAppPagePath;
        
        private String weAppWebViewShortUrl;
        
        private String weAppWebViewUrl;
    }

    @Data
    @ApiModel
    public static class ResourceUrlResponseQqAppInfo {
        
        private String appId;
        
        private String bannerUrl;
        
        private String desc;
        
        private String pagePath;
        
        private String qqAppIconUrl;
        
        private String sourceDisplayName;
        
        private String title;
        
        private String userName;
    }

    @Data
    @ApiModel
    public static class ResourceUrlResponseSingleUrlList {
        
        private String mobileShortUrl;
        
        private String mobileUrl;
        
        private String schemaUrl;
        
        private String shortUrl;
        
        private String url;
        
        private String weAppPagePath;
        
        private String weAppWebViewShortUrl;
        
        private String weAppWebViewUrl;
    }

    @Data
    @ApiModel
    public static class ResourceUrlResponseWeAppInfo {
        
        private String appId;
        
        private String bannerUrl;
        
        private String desc;
        
        private String pagePath;
        
        private String sourceDisplayName;
        
        private String title;
        
        private String userName;
        
        private String weAppIconUrl;
    }
}
