package ace.pinduoduo.base.api.web.application.controller;

import ace.fw.copier.cglib.util.CachedBeanCopierUtils;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.GenericResponseExtUtils;
import ace.pinduoduo.base.api.controller.PddAdBaseController;
import ace.pinduoduo.define.base.request.PddPIdGenerateRequest;
import ace.pinduoduo.define.base.request.PddWeappQrcodeUrlGenRequest;
import ace.pinduoduo.define.base.response.PddPIdGenerateResponse;
import ace.pinduoduo.define.base.response.PddWeappQrcodeUrlGenResponse;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.api.request.PddDdkGoodsPidGenerateRequest;
import com.pdd.pop.sdk.http.api.request.PddDdkWeappQrcodeUrlGenRequest;
import com.pdd.pop.sdk.http.api.response.PddDdkGoodsPidGenerateResponse;
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
}
