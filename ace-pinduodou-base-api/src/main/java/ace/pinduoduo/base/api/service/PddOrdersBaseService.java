package ace.pinduoduo.base.api.service;

import ace.pinduoduo.define.base.constant.ProjectConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;

/**
 * @author qjj
 * @create 2020/3/22 12:00
 * @description 订单类
 */
@FeignClient(
        name = ProjectConstants.BASE_FEIGN_CLIENT_NAME,
        contextId = "pddOrdersBaseService",
        path = "/" + PddOrdersBaseService.MODULE_RESTFUL_NAME
)
@Validated
public interface PddOrdersBaseService {

    String MODULE_RESTFUL_NAME = "pdd-orders-base";

}
