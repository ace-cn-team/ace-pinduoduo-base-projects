package ace.pinduoduo.base.api.controller;

import ace.pinduoduo.base.api.service.PddGoodsBaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qjj
 * @create 2020/3/22 12:00
 * @description 订单类
 */
@RestController
@RequestMapping(path = "/" + PddGoodsBaseService.MODULE_RESTFUL_NAME)
@Validated
public interface PddOrdersBaseController extends PddGoodsBaseService {

}
