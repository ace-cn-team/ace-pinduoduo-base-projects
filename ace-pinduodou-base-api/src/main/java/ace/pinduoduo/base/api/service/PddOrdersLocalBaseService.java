package ace.pinduoduo.base.api.service;

import ace.pinduoduo.define.base.constant.ProjectConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;

/**
 * @author qjj
 * @create 2020/4/6 23:14
 * @description 本地订单类(本地数据库存档)
 */
@FeignClient(
        name = ProjectConstants.BASE_FEIGN_CLIENT_NAME,
        contextId = "pddOrdersLocalBaseService",
        path = "/" + PddOrdersLocalBaseService.MODULE_RESTFUL_NAME
)
@Validated
public interface PddOrdersLocalBaseService {

    String MODULE_RESTFUL_NAME = "pdd-orders-local-base";

}
