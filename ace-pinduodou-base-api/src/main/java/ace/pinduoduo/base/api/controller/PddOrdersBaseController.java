package ace.pinduoduo.base.api.controller;

import ace.fw.model.response.GenericResponseExt;
import ace.pinduoduo.base.api.service.PddGoodsBaseService;
import ace.pinduoduo.base.api.service.PddOrdersBaseService;
import ace.pinduoduo.define.base.request.PddOrderDetailGetRequest;
import ace.pinduoduo.define.base.request.PddOrderListIncrementGetRequest;
import ace.pinduoduo.define.base.response.PddOrderDetailGetResponse;
import ace.pinduoduo.define.base.response.PddOrderListIncrementGetResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author qjj
 * @create 2020/3/22 12:00
 * @description 订单类
 */
@RestController
@RequestMapping(path = "/" + PddOrdersBaseService.MODULE_RESTFUL_NAME)
@Validated
public interface PddOrdersBaseController extends PddOrdersBaseService {

    /**
     * 最后更新时间段增量同步推广订单信息
     * @param request
     * @return
     */
    @ApiOperation(value = "最后更新时间段增量同步推广订单信息")
    @RequestMapping(path = "/find-order-list", method = RequestMethod.POST)
    GenericResponseExt<PddOrderListIncrementGetResponse> findOrderList(@Valid @RequestBody PddOrderListIncrementGetRequest request);

    /**
     * 查询订单详情
     * @param request
     * @return
     */
    @ApiOperation(value = "查询订单详情")
    @RequestMapping(path = "/find-order-detail", method = RequestMethod.POST)
    GenericResponseExt<PddOrderDetailGetResponse> findOrderDetail(@Valid @RequestBody PddOrderDetailGetRequest request);

}
