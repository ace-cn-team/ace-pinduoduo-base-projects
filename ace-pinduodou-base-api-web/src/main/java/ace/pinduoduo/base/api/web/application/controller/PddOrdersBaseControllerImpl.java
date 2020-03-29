package ace.pinduoduo.base.api.web.application.controller;

import ace.fw.copier.cglib.util.CachedBeanCopierUtils;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.GenericResponseExtUtils;
import ace.pinduoduo.base.api.controller.PddAdBaseController;
import ace.pinduoduo.base.api.controller.PddOrdersBaseController;
import ace.pinduoduo.define.base.request.PddOrderDetailGetRequest;
import ace.pinduoduo.define.base.request.PddOrderListIncrementGetRequest;
import ace.pinduoduo.define.base.response.PddOrderDetailGetResponse;
import ace.pinduoduo.define.base.response.PddOrderListIncrementGetResponse;
import com.alibaba.fastjson.JSONObject;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.api.request.PddDdkOrderDetailGetRequest;
import com.pdd.pop.sdk.http.api.request.PddDdkOrderListIncrementGetRequest;
import com.pdd.pop.sdk.http.api.response.PddDdkOrderDetailGetResponse;
import com.pdd.pop.sdk.http.api.response.PddDdkOrderListIncrementGetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author qjj
 * @create 2020/3/22 12:00
 * @description 订单类
 */
@RestController
@Slf4j
public class PddOrdersBaseControllerImpl
        implements PddOrdersBaseController {

    @Autowired
    private PopClient popClient;

    @Override
    public GenericResponseExt<PddOrderListIncrementGetResponse> findOrderList(@Valid PddOrderListIncrementGetRequest request) {
        PddOrderListIncrementGetResponse pddOrderListIncrementGetResponse = null;

        try{
            PddDdkOrderListIncrementGetRequest pddDdkOrderListIncrementGetRequest = CachedBeanCopierUtils.copy(request, PddDdkOrderListIncrementGetRequest.class);
            PddDdkOrderListIncrementGetResponse pddDdkOrderListIncrementGetResponse = popClient.syncInvoke(pddDdkOrderListIncrementGetRequest);
            PddDdkOrderListIncrementGetResponse.OrderListGetResponse orderListGetResponse = pddDdkOrderListIncrementGetResponse.getOrderListGetResponse();

            if(orderListGetResponse != null){
                pddOrderListIncrementGetResponse = CachedBeanCopierUtils.copy(orderListGetResponse, PddOrderListIncrementGetResponse.class);
            }
            return GenericResponseExtUtils.buildSuccessWithData(pddOrderListIncrementGetResponse);
        }catch (Exception e){
            log.error("最后更新时间段增量同步推广订单信息异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(pddOrderListIncrementGetResponse);
        }
    }

    @Override
    public GenericResponseExt<PddOrderDetailGetResponse> findOrderDetail(@Valid PddOrderDetailGetRequest request) {
        PddOrderDetailGetResponse pddOrderDetailGetResponse = null;
        try{
            PddDdkOrderDetailGetRequest pddDdkOrderDetailGetRequest = new PddDdkOrderDetailGetRequest();
            pddDdkOrderDetailGetRequest.setOrderSn(request.getOrderSn());
            PddDdkOrderDetailGetResponse pddDdkOrderDetailGetResponse = popClient.syncInvoke(pddDdkOrderDetailGetRequest);
            log.info("查询订单详情,请求参数:[{}],返回结果:[{}]", request, JSONObject.toJSON(pddDdkOrderDetailGetResponse));
            PddDdkOrderDetailGetResponse.OrderDetailResponse orderDetailResponse = pddDdkOrderDetailGetResponse.getOrderDetailResponse();
            pddOrderDetailGetResponse = CachedBeanCopierUtils.copy(orderDetailResponse, PddOrderDetailGetResponse.class);
            return GenericResponseExtUtils.buildSuccessWithData(pddOrderDetailGetResponse);
        }catch (Exception e){
            log.error("查询订单详情异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(pddOrderDetailGetResponse);
        }
    }
}
