package ace.pinduoduo.base.api.controller;

import ace.pinduoduo.base.api.service.PddAdBaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qjj
 * @create 2020/3/22 12:00
 * @description 推广类
 */
@RestController
@RequestMapping(path = "/" + PddAdBaseService.MODULE_RESTFUL_NAME)
@Validated
public interface PddAdBaseController extends PddAdBaseService {

}
