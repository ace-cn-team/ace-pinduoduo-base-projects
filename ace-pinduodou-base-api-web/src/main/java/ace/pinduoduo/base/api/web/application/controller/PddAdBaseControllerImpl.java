package ace.pinduoduo.base.api.web.application.controller;

import ace.fw.copier.cglib.util.CachedBeanCopierUtils;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.GenericResponseExtUtils;
import ace.pinduoduo.base.api.controller.PddAdBaseController;
import ace.pinduoduo.define.base.request.PddGoodsPidQueryRequest;
import ace.pinduoduo.define.base.request.PddGoodsPromotionUrlGenerateRequest;
import ace.pinduoduo.define.base.request.PddPIdGenerateRequest;
import ace.pinduoduo.define.base.request.PddWeappQrcodeUrlGenRequest;
import ace.pinduoduo.define.base.response.PddGoodsPidQueryResponse;
import ace.pinduoduo.define.base.response.PddGoodsPromotionUrlGenerateResponse;
import ace.pinduoduo.define.base.response.PddPIdGenerateResponse;
import ace.pinduoduo.define.base.response.PddWeappQrcodeUrlGenResponse;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.api.request.PddDdkGoodsPidGenerateRequest;
import com.pdd.pop.sdk.http.api.request.PddDdkGoodsPidQueryRequest;
import com.pdd.pop.sdk.http.api.request.PddDdkGoodsPromotionUrlGenerateRequest;
import com.pdd.pop.sdk.http.api.request.PddDdkWeappQrcodeUrlGenRequest;
import com.pdd.pop.sdk.http.api.response.PddDdkGoodsPidGenerateResponse;
import com.pdd.pop.sdk.http.api.response.PddDdkGoodsPidQueryResponse;
import com.pdd.pop.sdk.http.api.response.PddDdkGoodsPromotionUrlGenerateResponse;
import com.pdd.pop.sdk.http.api.response.PddDdkWeappQrcodeUrlGenResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author qjj
 * @create 2020/3/22 12:00
 * @description 推广类
 */
@RestController
@Slf4j
public class PddAdBaseControllerImpl
        implements PddAdBaseController {

    @Autowired
    private PopClient popClient;

    @Override
    public GenericResponseExt<PddWeappQrcodeUrlGenResponse> findQrCodeUrl(@Valid PddWeappQrcodeUrlGenRequest request) {
        PddWeappQrcodeUrlGenResponse pddWeappQrcodeUrlGenResponse = new PddWeappQrcodeUrlGenResponse();
        try{
            PddDdkWeappQrcodeUrlGenRequest pddDdkWeappQrcodeUrlGenRequest = CachedBeanCopierUtils.copy(request, PddDdkWeappQrcodeUrlGenRequest.class);
            PddDdkWeappQrcodeUrlGenResponse response = popClient.syncInvoke(pddDdkWeappQrcodeUrlGenRequest);
            PddDdkWeappQrcodeUrlGenResponse.WeappQrcodeGenerateResponse weappQrcodeGenerateResponse = response.getWeappQrcodeGenerateResponse();

            if(weappQrcodeGenerateResponse != null){
                pddWeappQrcodeUrlGenResponse.setUrl(weappQrcodeGenerateResponse.getUrl());
            }
            return GenericResponseExtUtils.buildSuccessWithData(pddWeappQrcodeUrlGenResponse);
        }catch (Exception e){
            log.error("生成单品推广小程序二维码url异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(pddWeappQrcodeUrlGenResponse);
        }
    }

    @Override
    public GenericResponseExt<PddPIdGenerateResponse> createPId(@Valid PddPIdGenerateRequest request) {
        PddPIdGenerateResponse pddPIdGenerateResponse = new PddPIdGenerateResponse();
        try{
            PddDdkGoodsPidGenerateRequest pddDdkGoodsPidGenerateRequest = new PddDdkGoodsPidGenerateRequest();
            pddDdkGoodsPidGenerateRequest.setNumber(request.getNumber());
            pddDdkGoodsPidGenerateRequest.setPIdNameList(request.getPIdNameList());
            PddDdkGoodsPidGenerateResponse response = popClient.syncInvoke(pddDdkGoodsPidGenerateRequest);
            PddDdkGoodsPidGenerateResponse.PIdGenerateResponse pIdGenerateResponse = response.getPIdGenerateResponse();

            if(pIdGenerateResponse != null){
                List<PddDdkGoodsPidGenerateResponse.PIdGenerateResponsePIdListItem> pIdList = pIdGenerateResponse.getPIdList();
                List<PddPIdGenerateResponse.PIdGenerateItemResponse> pIdGenerateItemResponses = CachedBeanCopierUtils.copyList(pIdList, PddPIdGenerateResponse.PIdGenerateItemResponse.class);
                pddPIdGenerateResponse.setPIdGenerateItemResponseList(pIdGenerateItemResponses);
            }
            return GenericResponseExtUtils.buildSuccessWithData(pddPIdGenerateResponse);
        }catch (Exception e){
            log.error("创建推广位异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(pddPIdGenerateResponse);
        }
    }

    @Override
    public GenericResponseExt<PddGoodsPidQueryResponse> queryPId(@Valid PddGoodsPidQueryRequest request) {
        PddGoodsPidQueryResponse pddGoodsPidQueryResponse = null;
        try{
            PddDdkGoodsPidQueryRequest pddDdkGoodsPidQueryRequest = new PddDdkGoodsPidQueryRequest();
            pddDdkGoodsPidQueryRequest.setPage(request.getPage());
            pddDdkGoodsPidQueryRequest.setPageSize(request.getPageSize());
            pddDdkGoodsPidQueryRequest.setPidList(request.getPidList());
            PddDdkGoodsPidQueryResponse response = popClient.syncInvoke(pddDdkGoodsPidQueryRequest);
            PddDdkGoodsPidQueryResponse.PIdQueryResponse pIdQueryResponse = response.getPIdQueryResponse();

            if(pIdQueryResponse != null){
                pddGoodsPidQueryResponse = CachedBeanCopierUtils.copy(pIdQueryResponse, PddGoodsPidQueryResponse.class);
            }
            return GenericResponseExtUtils.buildSuccessWithData(pddGoodsPidQueryResponse);
        }catch (Exception e){
            log.error("查询已经生成的推广位信息异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(pddGoodsPidQueryResponse);
        }
    }

    @Override
    public GenericResponseExt<PddGoodsPromotionUrlGenerateResponse> promotionUrlGenerate(@Valid PddGoodsPromotionUrlGenerateRequest request) {
        PddGoodsPromotionUrlGenerateResponse pddGoodsPromotionUrlGenerateResponse = null;
        try{
            PddDdkGoodsPromotionUrlGenerateRequest pddDdkGoodsPromotionUrlGenerateRequest = CachedBeanCopierUtils.copy(request, PddDdkGoodsPromotionUrlGenerateRequest.class);
            PddDdkGoodsPromotionUrlGenerateResponse response = popClient.syncInvoke(pddDdkGoodsPromotionUrlGenerateRequest);
            PddDdkGoodsPromotionUrlGenerateResponse.GoodsPromotionUrlGenerateResponse goodsPromotionUrlGenerateResponse = response.getGoodsPromotionUrlGenerateResponse();

            if(goodsPromotionUrlGenerateResponse != null){
                pddGoodsPromotionUrlGenerateResponse = CachedBeanCopierUtils.copy(goodsPromotionUrlGenerateResponse, PddGoodsPromotionUrlGenerateResponse.class);
            }
            return GenericResponseExtUtils.buildSuccessWithData(pddGoodsPromotionUrlGenerateResponse);
        }catch (Exception e){
            log.error("推广链接生成异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(pddGoodsPromotionUrlGenerateResponse);
        }
    }
}
