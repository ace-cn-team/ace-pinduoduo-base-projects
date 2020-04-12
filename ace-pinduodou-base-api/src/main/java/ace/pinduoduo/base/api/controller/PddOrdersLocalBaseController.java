package ace.pinduoduo.base.api.controller;

import ace.fw.data.model.PageResponse;
import ace.fw.model.response.GenericResponseExt;
import ace.pinduoduo.base.api.service.PddOrdersLocalBaseService;
import ace.pinduoduo.define.base.request.PddOrdersEntryAccountIdRequest;
import ace.pinduoduo.define.base.request.PddOrdersLocalPageRequest;
import ace.pinduoduo.define.base.request.PddOrdersLocalSaveRequest;
import ace.pinduoduo.define.base.request.PddOrdersNoMemberIdPageRequest;
import ace.pinduoduo.define.base.response.PddOrdersLocalPageResponse;
import ace.pinduoduo.define.base.response.PddOrdersNoMemberIdPageResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author qjj
 * @create 2020/4/6 23:14
 * @description 本地订单类(本地数据库存档)
 */
@RestController
@RequestMapping(path = "/" + PddOrdersLocalBaseService.MODULE_RESTFUL_NAME)
@Validated
public interface PddOrdersLocalBaseController extends PddOrdersLocalBaseService {

    /**
     * 保存拼多多订单
     * @param request
     * @return
     */
    @ApiOperation(value = "保存拼多多订单")
    @RequestMapping(path = "/save-pdd-orders-local", method = RequestMethod.POST)
    GenericResponseExt<Boolean> savePddOrders(@Valid @RequestBody PddOrdersLocalSaveRequest request);

    /**
     * 根据账号id查询本地库拼多多订单
     * @param request
     * @return
     */
    @RequestMapping(path = "/page-by-memberId", method = RequestMethod.POST)
    GenericResponseExt<PageResponse<PddOrdersLocalPageResponse>> pageByAccountId(@Valid @RequestBody PddOrdersLocalPageRequest request);

    /**
     * 查询accountId为空的订单id
     * 用于根据自定参数补上accountId
     * @param request
     * @return
     */
    @RequestMapping(path = "/page-no-accountId", method = RequestMethod.POST)
    GenericResponseExt<PageResponse<PddOrdersNoMemberIdPageResponse>> pageNoAccountId(@Valid @RequestBody PddOrdersNoMemberIdPageRequest request);

    /**
     * 录入accountId
     * @param request
     * @return
     */
    @ApiOperation(value = "录入accountId")
    @RequestMapping(path = "/entry-accountId", method = RequestMethod.POST)
    GenericResponseExt<Boolean> entryAccountId(@Valid @RequestBody PddOrdersEntryAccountIdRequest request);
}
