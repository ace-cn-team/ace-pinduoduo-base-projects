package ace.pinduoduo.define.base.constant;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/19 17:37
 * @description
 */
public interface ProjectConstants {

    /**
     * openfeign扫描微服务api的包路径
     */
    String FEIGN_CLIENT_SERVICE_PACKAGE = "ace.pinduoduo.base.api.service";
    /**
     * base层微服务openfeign配置名称
     */
    String BASE_FEIGN_CLIENT_NAME = "${ace.ms.service.api.ace-pinduodou-base-api.name:ace-pinduodou-base-api-web}";
    /**
     * logic层微服务openfeign配置名称
     */
    String LOGIC_FEIGN_CLIENT_NAME = "${ace.ms.service.api.ace-pinduodou-logic-api.name:ace-pinduodou-logic-api-web}";
    /**
     * pindudou-base-api是否开启openfeign注入
     */
    String CONFIG_KEY_ACCOUNT_IDENTITY_BASE_API_ENABLE = "ace.ms.service.pinduoduo-base-api.enable";

}
