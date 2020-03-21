package ace.pinduoduo.base.api.service;

import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.GenericResponseExtUtils;
import ace.pinduoduo.define.base.constant.ProjectConstants;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/14 12:29
 * @description
 */
@FeignClient(
        name = ProjectConstants.BASE_FEIGN_CLIENT_NAME,
        contextId = "clientTagBaseService",
        path = "/" + ClientTagBaseService.MODULE_RESTFUL_NAME
)
@Validated
public interface ClientTagBaseService {
    String MODULE_RESTFUL_NAME = "client-tag-base";

    @ApiOperation(value = "是否client tag")
    @RequestMapping(path = "/check", method = RequestMethod.POST)
    default GenericResponseExt<String> check() {
        return GenericResponseExtUtils.buildSuccessWithData("client");
    }
}
