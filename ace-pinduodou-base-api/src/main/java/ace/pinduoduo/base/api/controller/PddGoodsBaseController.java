package ace.pinduoduo.base.api.controller;

import ace.fw.model.response.GenericResponseExt;
import ace.pinduoduo.base.api.service.PddGoodsBaseService;
import ace.pinduoduo.define.base.request.PddCouponInfoRequest;
import ace.pinduoduo.define.base.request.PddGoodsBasicInfoRequest;
import ace.pinduoduo.define.base.request.PddGoodsDetailRequest;
import ace.pinduoduo.define.base.request.PddTopGoodsListRequest;
import ace.pinduoduo.define.base.response.PddCouponInfoResponse;
import ace.pinduoduo.define.base.response.PddGoodsBasicInfoResponse;
import ace.pinduoduo.define.base.response.PddGoodsDetailResponse;
import ace.pinduoduo.define.base.response.PddTopGoodsListResponse;
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
 * @description 商品类
 */
@RestController
@RequestMapping(path = "/" + PddGoodsBaseService.MODULE_RESTFUL_NAME)
@Validated
public interface PddGoodsBaseController extends PddGoodsBaseService {

    @ApiOperation(value = "获取爆款排行商品")
    @RequestMapping(path = "/find-top-goods-list", method = RequestMethod.POST)
    GenericResponseExt<PddTopGoodsListResponse> findTopGoodsList(@Valid @RequestBody PddTopGoodsListRequest request);

    @ApiOperation(value = "获取商品基本信息")
    @RequestMapping(path = "/find-goods-basic-info", method = RequestMethod.POST)
    GenericResponseExt<PddGoodsBasicInfoResponse> findGoodsBasicInfo(@Valid @RequestBody PddGoodsBasicInfoRequest request);

    @ApiOperation(value = "商品详情查询")
    @RequestMapping(path = "/find-goods-detail", method = RequestMethod.POST)
    GenericResponseExt<PddGoodsDetailResponse> findGoodsDetail(@Valid @RequestBody PddGoodsDetailRequest request);

    @ApiOperation(value = "查询优惠券信息")
    @RequestMapping(path = "/find-coupon-detail", method = RequestMethod.POST)
    GenericResponseExt<PddCouponInfoResponse> findCouponDetail(@Valid @RequestBody PddCouponInfoRequest request);

}
