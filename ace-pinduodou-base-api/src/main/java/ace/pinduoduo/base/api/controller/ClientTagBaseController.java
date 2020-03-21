package ace.pinduoduo.base.api.controller;

import ace.pinduoduo.base.api.service.ClientTagBaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Caspar
 * @contract 279397942@qq.com
 * @create 2020/1/14 12:29
 * @description
 */
@RestController
@RequestMapping(path = "/" + ClientTagBaseService.MODULE_RESTFUL_NAME)
@Validated
public interface ClientTagBaseController extends ClientTagBaseService {

}
