package ace.pinduoduo.base.api.controller;

import ace.fw.model.response.GenericResponseExt;
import ace.pinduoduo.base.api.service.PddAdBaseService;
import ace.pinduoduo.define.base.request.PddGoodsPidQueryRequest;
import ace.pinduoduo.define.base.request.PddGoodsPromotionUrlGenerateRequest;
import ace.pinduoduo.define.base.request.PddPidGenerateRequest;
import ace.pinduoduo.define.base.request.PddWeappQrcodeUrlGenRequest;
import ace.pinduoduo.define.base.response.PddGoodsPidQueryResponse;
import ace.pinduoduo.define.base.response.PddGoodsPromotionUrlGenerateResponse;
import ace.pinduoduo.define.base.response.PddPidGenerateResponse;
import ace.pinduoduo.define.base.response.PddWeappQrcodeUrlGenResponse;
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
 * @description 推广类
 */
@RestController
@RequestMapping(path = "/" + PddAdBaseService.MODULE_RESTFUL_NAME)
@Validated
public interface PddAdBaseController extends PddAdBaseService {

    /**
     * 生成单品推广小程序二维码url
     * @param request
     * @return
     */
    @ApiOperation(value = "生成单品推广小程序二维码url")
    @RequestMapping(path = "/find-qr-code-url", method = RequestMethod.POST)
    GenericResponseExt<PddWeappQrcodeUrlGenResponse> findQrCodeUrl(@Valid @RequestBody PddWeappQrcodeUrlGenRequest request);

    /**
     * 创建多多进宝推广位
     * @param request
     * @return
     */
    @ApiOperation(value = "创建多多进宝推广位")
    @RequestMapping(path = "/create-pid", method = RequestMethod.POST)
    GenericResponseExt<PddPidGenerateResponse> createPid(@Valid @RequestBody PddPidGenerateRequest request);

    /**
     * 查询已经生成的推广位信息
     * @param request
     * @return
     */
    @ApiOperation(value = "查询已经生成的推广位信息")
    @RequestMapping(path = "/query-pid", method = RequestMethod.POST)
    GenericResponseExt<PddGoodsPidQueryResponse> queryPid(@Valid @RequestBody PddGoodsPidQueryRequest request);

    /**
     * 推广链接生成
     * @param request
     * @return
     */
    @ApiOperation(value = "推广链接生成")
    @RequestMapping(path = "/promotion-url-generate", method = RequestMethod.POST)
    GenericResponseExt<PddGoodsPromotionUrlGenerateResponse> promotionUrlGenerate(@Valid @RequestBody PddGoodsPromotionUrlGenerateRequest request);
}
