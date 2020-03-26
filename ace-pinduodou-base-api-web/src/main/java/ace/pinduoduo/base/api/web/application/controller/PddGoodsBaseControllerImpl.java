package ace.pinduoduo.base.api.web.application.controller;

import ace.fw.copier.cglib.util.CachedBeanCopierUtils;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.GenericResponseExtUtils;
import ace.pinduoduo.base.api.controller.PddGoodsBaseController;
import ace.pinduoduo.define.base.request.PddCouponInfoRequest;
import ace.pinduoduo.define.base.request.PddGoodsBasicInfoRequest;
import ace.pinduoduo.define.base.request.PddGoodsDetailRequest;
import ace.pinduoduo.define.base.request.PddTopGoodsListRequest;
import ace.pinduoduo.define.base.response.PddCouponInfoResponse;
import ace.pinduoduo.define.base.response.PddGoodsBasicInfoResponse;
import ace.pinduoduo.define.base.response.PddGoodsDetailResponse;
import ace.pinduoduo.define.base.response.PddTopGoodsListResponse;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.api.request.PddDdkCouponInfoQueryRequest;
import com.pdd.pop.sdk.http.api.request.PddDdkGoodsBasicInfoGetRequest;
import com.pdd.pop.sdk.http.api.request.PddDdkGoodsDetailRequest;
import com.pdd.pop.sdk.http.api.request.PddDdkTopGoodsListQueryRequest;
import com.pdd.pop.sdk.http.api.response.PddDdkCouponInfoQueryResponse;
import com.pdd.pop.sdk.http.api.response.PddDdkGoodsBasicInfoGetResponse;
import com.pdd.pop.sdk.http.api.response.PddDdkGoodsDetailResponse;
import com.pdd.pop.sdk.http.api.response.PddDdkTopGoodsListQueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author qjj
 * @create 2020/3/22 12:00
 * @description 商品类
 */
@RestController
@Slf4j
public class PddGoodsBaseControllerImpl
        implements PddGoodsBaseController {

    @Autowired
    private PopClient popClient;

    @Override
    public GenericResponseExt<PddTopGoodsListResponse> findTopGoodsList(@Valid PddTopGoodsListRequest request) {
        PddTopGoodsListResponse pddTopGoodsListResponse = new PddTopGoodsListResponse();

        try{
            PddDdkTopGoodsListQueryRequest pddDdkTopGoodsListQueryRequest = CachedBeanCopierUtils.copy(request, PddDdkTopGoodsListQueryRequest.class);
            PddDdkTopGoodsListQueryResponse pddDdkTopGoodsListQueryResponse = popClient.syncInvoke(pddDdkTopGoodsListQueryRequest);
            PddDdkTopGoodsListQueryResponse.TopGoodsListGetResponse topGoodsListGetResponse = pddDdkTopGoodsListQueryResponse.getTopGoodsListGetResponse();

            if(topGoodsListGetResponse != null){
                List<PddDdkTopGoodsListQueryResponse.TopGoodsListGetResponseListItem> topGoodsListGetResponseListItemList = topGoodsListGetResponse.getList();
                List<PddTopGoodsListResponse.TopGoodsListGetResponseListItem> topGoodsListGetResponseListItems = CachedBeanCopierUtils.copyList(topGoodsListGetResponseListItemList, PddTopGoodsListResponse.TopGoodsListGetResponseListItem.class);
                pddTopGoodsListResponse.setList(topGoodsListGetResponseListItems);
                pddTopGoodsListResponse.setListId(topGoodsListGetResponse.getListId());
                pddTopGoodsListResponse.setSearchId(topGoodsListGetResponse.getSearchId());
                pddTopGoodsListResponse.setTotal(topGoodsListGetResponse.getTotal());
            }
            return GenericResponseExtUtils.buildSuccessWithData(pddTopGoodsListResponse);
        }catch (Exception e){
            log.error("查询爆款排行商品异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(pddTopGoodsListResponse);
        }
    }

    @Override
    public GenericResponseExt<PddGoodsBasicInfoResponse> findGoodsBasicInfo(@Valid PddGoodsBasicInfoRequest request) {
        PddGoodsBasicInfoResponse pddGoodsBasicInfoResponse = new PddGoodsBasicInfoResponse();

        try {
            //获取拼多多商品信息
            PddDdkGoodsBasicInfoGetRequest pddDdkGoodsBasicInfoGetRequest = new PddDdkGoodsBasicInfoGetRequest();
            pddDdkGoodsBasicInfoGetRequest.setGoodsIdList(request.getGoodsIdList());
            PddDdkGoodsBasicInfoGetResponse response = popClient.syncInvoke(pddDdkGoodsBasicInfoGetRequest);
            PddDdkGoodsBasicInfoGetResponse.GoodsBasicDetailResponse goodsBasicDetailResponse = response.getGoodsBasicDetailResponse();

            if(goodsBasicDetailResponse != null){
                List<PddDdkGoodsBasicInfoGetResponse.GoodsBasicDetailResponseGoodsListItem> goodsList = goodsBasicDetailResponse.getGoodsList();
                List<PddGoodsBasicInfoResponse.GoodsBasicDetailResponseGoodsListItem> resultList = CachedBeanCopierUtils.copyList(goodsList, PddGoodsBasicInfoResponse.GoodsBasicDetailResponseGoodsListItem.class);
                pddGoodsBasicInfoResponse.setGoodsBasicDetailList(resultList);
            }
            return GenericResponseExtUtils.buildSuccessWithData(pddGoodsBasicInfoResponse);
        }catch (Exception e){
            log.error("查询商品信息异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(pddGoodsBasicInfoResponse);
        }
    }

    @Override
    public GenericResponseExt<PddGoodsDetailResponse> findGoodsDetail(@Valid PddGoodsDetailRequest request) {
        PddGoodsDetailResponse pddGoodsDetailResponse = new PddGoodsDetailResponse();

        try{
            PddDdkGoodsDetailRequest pddDdkGoodsDetailRequest = CachedBeanCopierUtils.copy(request, PddDdkGoodsDetailRequest.class);
            PddDdkGoodsDetailResponse pddDdkGoodsDetailResponse = popClient.syncInvoke(pddDdkGoodsDetailRequest);
            PddDdkGoodsDetailResponse.GoodsDetailResponse goodsDetailResponse = pddDdkGoodsDetailResponse.getGoodsDetailResponse();

            if(goodsDetailResponse != null){
                List<PddDdkGoodsDetailResponse.GoodsDetailResponseGoodsDetailsItem> goodsDetails = goodsDetailResponse.getGoodsDetails();
                List<PddGoodsDetailResponse.GoodsDetailResponseGoodsDetailsItem> goodsDetailResponseGoodsDetailsItemList = CachedBeanCopierUtils.copyList(goodsDetails, PddGoodsDetailResponse.GoodsDetailResponseGoodsDetailsItem.class);
                pddGoodsDetailResponse.setGoodsDetails(goodsDetailResponseGoodsDetailsItemList);
            }
            return GenericResponseExtUtils.buildSuccessWithData(pddGoodsDetailResponse);
        }catch (Exception e){
            log.error("商品详情查询异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(pddGoodsDetailResponse);
        }
    }

    @Override
    public GenericResponseExt<PddCouponInfoResponse> findCouponDetail(@Valid PddCouponInfoRequest request) {
        PddCouponInfoResponse pddCouponInfoResponse = new PddCouponInfoResponse();
        try{
            PddDdkCouponInfoQueryRequest pddDdkCouponInfoQueryRequest = CachedBeanCopierUtils.copy(request, PddDdkCouponInfoQueryRequest.class);
            PddDdkCouponInfoQueryResponse pddDdkCouponInfoQueryResponse = popClient.syncInvoke(pddDdkCouponInfoQueryRequest);
            PddDdkCouponInfoQueryResponse.DdkCouponInfoQueryResponse ddkCouponInfoQueryResponse = pddDdkCouponInfoQueryResponse.getDdkCouponInfoQueryResponse();

            if(ddkCouponInfoQueryResponse != null){
                List<PddDdkCouponInfoQueryResponse.DdkCouponInfoQueryResponseListItem> ddkCouponInfoQueryResponseListItemList = ddkCouponInfoQueryResponse.getList();
                List<PddCouponInfoResponse.CouponInfoResponseItemList> couponInfoResponseItemListList = CachedBeanCopierUtils.copyList(ddkCouponInfoQueryResponseListItemList, PddCouponInfoResponse.CouponInfoResponseItemList.class);
                pddCouponInfoResponse.setCouponInfoResponseItemListList(couponInfoResponseItemListList);
            }
            return GenericResponseExtUtils.buildSuccessWithData(pddCouponInfoResponse);
        }catch (Exception e){
            log.error("查询优惠券信息异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(pddCouponInfoResponse);
        }
    }
}
