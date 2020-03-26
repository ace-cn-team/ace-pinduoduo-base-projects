package ace.pinduoduo.base.api.controller;

import ace.fw.model.response.GenericResponseExt;
import ace.pinduoduo.base.api.service.PddAdBaseService;
import ace.pinduoduo.define.base.request.PddPIdGenerateRequest;
import ace.pinduoduo.define.base.request.PddWeappQrcodeUrlGenRequest;
import ace.pinduoduo.define.base.response.PddPIdGenerateResponse;
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

    @ApiOperation(value = "生成单品推广小程序二维码url")
    @RequestMapping(path = "/find-qr-code-url", method = RequestMethod.POST)
    GenericResponseExt<PddWeappQrcodeUrlGenResponse> findQrCodeUrl(@Valid @RequestBody PddWeappQrcodeUrlGenRequest request);

    @ApiOperation(value = "创建多多进宝推广位")
    @RequestMapping(path = "/create-pid", method = RequestMethod.POST)
    GenericResponseExt<PddPIdGenerateResponse> createPId(@Valid @RequestBody PddPIdGenerateRequest request);
}
