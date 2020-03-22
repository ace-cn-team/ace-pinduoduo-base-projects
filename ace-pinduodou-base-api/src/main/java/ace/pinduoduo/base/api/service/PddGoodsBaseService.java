package ace.pinduoduo.base.api.service;

import ace.pinduoduo.define.base.constant.ProjectConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;

/**
 * @author qjj
 * @create 2020/3/22 12:00
 * @description 商品类
 */
@FeignClient(
        name = ProjectConstants.BASE_FEIGN_CLIENT_NAME,
        contextId = "pddGoodsBaseService",
        path = "/" + PddGoodsBaseService.MODULE_RESTFUL_NAME
)
@Validated
public interface PddGoodsBaseService {

    String MODULE_RESTFUL_NAME = "pdd-goods-base";

}
