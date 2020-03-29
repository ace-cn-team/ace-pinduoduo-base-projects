package ace.pinduoduo.base.api.web.application.controller;

import ace.fw.copier.cglib.util.CachedBeanCopierUtils;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.GenericResponseExtUtils;
import ace.pinduoduo.base.api.controller.PddGoodsBaseController;
import ace.pinduoduo.define.base.request.*;
import ace.pinduoduo.define.base.response.*;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.api.request.*;
import com.pdd.pop.sdk.http.api.response.*;
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
        PddTopGoodsListResponse pddTopGoodsListResponse = null;

        try{
            PddDdkTopGoodsListQueryRequest pddDdkTopGoodsListQueryRequest = CachedBeanCopierUtils.copy(request, PddDdkTopGoodsListQueryRequest.class);
            PddDdkTopGoodsListQueryResponse pddDdkTopGoodsListQueryResponse = popClient.syncInvoke(pddDdkTopGoodsListQueryRequest);
            PddDdkTopGoodsListQueryResponse.TopGoodsListGetResponse topGoodsListGetResponse = pddDdkTopGoodsListQueryResponse.getTopGoodsListGetResponse();

            if(topGoodsListGetResponse != null){
                List<PddDdkTopGoodsListQueryResponse.TopGoodsListGetResponseListItem> topGoodsListGetResponseListItemList = topGoodsListGetResponse.getList();
                List<PddTopGoodsListResponse.TopGoodsListGetResponseListItem> topGoodsListGetResponseListItems = CachedBeanCopierUtils.copyList(topGoodsListGetResponseListItemList, PddTopGoodsListResponse.TopGoodsListGetResponseListItem.class);
                pddTopGoodsListResponse = new PddTopGoodsListResponse();
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
        PddGoodsBasicInfoResponse pddGoodsBasicInfoResponse = null;

        try {
            //获取拼多多商品信息
            PddDdkGoodsBasicInfoGetRequest pddDdkGoodsBasicInfoGetRequest = new PddDdkGoodsBasicInfoGetRequest();
            pddDdkGoodsBasicInfoGetRequest.setGoodsIdList(request.getGoodsIdList());
            PddDdkGoodsBasicInfoGetResponse response = popClient.syncInvoke(pddDdkGoodsBasicInfoGetRequest);
            PddDdkGoodsBasicInfoGetResponse.GoodsBasicDetailResponse goodsBasicDetailResponse = response.getGoodsBasicDetailResponse();

            if(goodsBasicDetailResponse != null){
                List<PddDdkGoodsBasicInfoGetResponse.GoodsBasicDetailResponseGoodsListItem> goodsList = goodsBasicDetailResponse.getGoodsList();
                List<PddGoodsBasicInfoResponse.GoodsBasicDetailResponseGoodsListItem> resultList = CachedBeanCopierUtils.copyList(goodsList, PddGoodsBasicInfoResponse.GoodsBasicDetailResponseGoodsListItem.class);
                pddGoodsBasicInfoResponse = new PddGoodsBasicInfoResponse();
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
        PddGoodsDetailResponse pddGoodsDetailResponse = null;

        try{
            PddDdkGoodsDetailRequest pddDdkGoodsDetailRequest = CachedBeanCopierUtils.copy(request, PddDdkGoodsDetailRequest.class);
            PddDdkGoodsDetailResponse pddDdkGoodsDetailResponse = popClient.syncInvoke(pddDdkGoodsDetailRequest);
            PddDdkGoodsDetailResponse.GoodsDetailResponse goodsDetailResponse = pddDdkGoodsDetailResponse.getGoodsDetailResponse();

            if(goodsDetailResponse != null){
                List<PddDdkGoodsDetailResponse.GoodsDetailResponseGoodsDetailsItem> goodsDetails = goodsDetailResponse.getGoodsDetails();
                List<PddGoodsDetailResponse.GoodsDetailResponseGoodsDetailsItem> goodsDetailResponseGoodsDetailsItemList = CachedBeanCopierUtils.copyList(goodsDetails, PddGoodsDetailResponse.GoodsDetailResponseGoodsDetailsItem.class);
                pddGoodsDetailResponse = new PddGoodsDetailResponse();
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
        PddCouponInfoResponse pddCouponInfoResponse = null;
        try{
            PddDdkCouponInfoQueryRequest pddDdkCouponInfoQueryRequest = CachedBeanCopierUtils.copy(request, PddDdkCouponInfoQueryRequest.class);
            PddDdkCouponInfoQueryResponse pddDdkCouponInfoQueryResponse = popClient.syncInvoke(pddDdkCouponInfoQueryRequest);
            PddDdkCouponInfoQueryResponse.DdkCouponInfoQueryResponse ddkCouponInfoQueryResponse = pddDdkCouponInfoQueryResponse.getDdkCouponInfoQueryResponse();

            if(ddkCouponInfoQueryResponse != null){
                List<PddDdkCouponInfoQueryResponse.DdkCouponInfoQueryResponseListItem> ddkCouponInfoQueryResponseListItemList = ddkCouponInfoQueryResponse.getList();
                List<PddCouponInfoResponse.CouponInfoResponseItemList> couponInfoResponseItemListList = CachedBeanCopierUtils.copyList(ddkCouponInfoQueryResponseListItemList, PddCouponInfoResponse.CouponInfoResponseItemList.class);
                pddCouponInfoResponse = new PddCouponInfoResponse();
                pddCouponInfoResponse.setCouponInfoResponseItemListList(couponInfoResponseItemListList);
            }
            return GenericResponseExtUtils.buildSuccessWithData(pddCouponInfoResponse);
        }catch (Exception e){
            log.error("查询优惠券信息异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(pddCouponInfoResponse);
        }
    }

    @Override
    public GenericResponseExt<PddGoodsSearchResponse> searchGoods(@Valid PddGoodsSearchRequest request) {
        PddGoodsSearchResponse pddGoodsSearchResponse = null;
        try{
            PddDdkGoodsSearchRequest pddDdkGoodsSearchRequest = CachedBeanCopierUtils.copy(request, PddDdkGoodsSearchRequest.class);
            PddDdkGoodsSearchResponse pddDdkGoodsSearchResponse = popClient.syncInvoke(pddDdkGoodsSearchRequest);
            PddDdkGoodsSearchResponse.GoodsSearchResponse goodsSearchResponse = pddDdkGoodsSearchResponse.getGoodsSearchResponse();
            if(goodsSearchResponse != null){
                pddGoodsSearchResponse = CachedBeanCopierUtils.copy(goodsSearchResponse, PddGoodsSearchResponse.class);
            }
            return GenericResponseExtUtils.buildSuccessWithData(pddGoodsSearchResponse);
        }catch (Exception e){
            log.error("商品查询异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(pddGoodsSearchResponse);
        }
    }

    @Override
    public GenericResponseExt<PddGoodsUnitQueryResponse> findGoodsUnit(@Valid PddGoodsUnitQueryRequest request) {
        PddGoodsUnitQueryResponse response = null;
        try{
            PddDdkGoodsUnitQueryRequest pddDdkGoodsUnitQueryRequest = CachedBeanCopierUtils.copy(request, PddDdkGoodsUnitQueryRequest.class);
            PddDdkGoodsUnitQueryResponse pddDdkGoodsUnitQueryResponse = popClient.syncInvoke(pddDdkGoodsUnitQueryRequest);
            PddDdkGoodsUnitQueryResponse.DdkGoodsUnitQueryResponse ddkGoodsUnitQueryResponse = pddDdkGoodsUnitQueryResponse.getDdkGoodsUnitQueryResponse();

            if(ddkGoodsUnitQueryResponse != null){
                response = CachedBeanCopierUtils.copy(ddkGoodsUnitQueryResponse, PddGoodsUnitQueryResponse.class);
            }
            return GenericResponseExtUtils.buildSuccessWithData(response);
        }catch (Exception e){
            log.error("查询商品的推广计划异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(response);
        }
    }

    @Override
    public GenericResponseExt<PddThemeListResponse> findThemeList(@Valid PddThemeListRequest request) {
        PddThemeListResponse pddThemeListResponse = null;
        try{
            PddDdkThemeListGetRequest pddDdkThemeListGetRequest = new PddDdkThemeListGetRequest();
            pddDdkThemeListGetRequest.setPageSize(request.getPageSize());
            pddDdkThemeListGetRequest.setPage(request.getPage());
            PddDdkThemeListGetResponse response = popClient.syncInvoke(pddDdkThemeListGetRequest);
            PddDdkThemeListGetResponse.ThemeListGetResponse themeListGetResponse = response.getThemeListGetResponse();

            if(themeListGetResponse != null){
                List<PddDdkThemeListGetResponse.ThemeListGetResponseThemeListItem> themeList = themeListGetResponse.getThemeList();
                List<PddThemeListResponse.ThemeListGetResponseThemeItemList> themeListGetResponseThemeItemLists = CachedBeanCopierUtils.copyList(themeList, PddThemeListResponse.ThemeListGetResponseThemeItemList.class);
                pddThemeListResponse = new PddThemeListResponse();
                pddThemeListResponse.setTotal(themeListGetResponse.getTotal());
                pddThemeListResponse.setThemeListGetResponseThemeItemListList(themeListGetResponseThemeItemLists);
            }
            return GenericResponseExtUtils.buildSuccessWithData(pddThemeListResponse);
        }catch (Exception e){
            log.error("主题列表查询异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(pddThemeListResponse);
        }
    }

    @Override
    public GenericResponseExt<PddThemeGoodsSearchResponse> findThemeGoods(@Valid PddThemeGoodsSearchRequest request) {
        PddThemeGoodsSearchResponse pddThemeGoodsSearchResponse = null;
        try{
            PddDdkThemeGoodsSearchRequest pddDdkThemeGoodsSearchRequest = new PddDdkThemeGoodsSearchRequest();
            pddDdkThemeGoodsSearchRequest.setThemeId(request.getThemeId());
            PddDdkThemeGoodsSearchResponse pddDdkThemeGoodsSearchResponse = popClient.syncInvoke(pddDdkThemeGoodsSearchRequest);
            PddDdkThemeGoodsSearchResponse.ThemeListGetResponse themeListGetResponse = pddDdkThemeGoodsSearchResponse.getThemeListGetResponse();

            if(themeListGetResponse != null){
                pddThemeGoodsSearchResponse = CachedBeanCopierUtils.copy(themeListGetResponse, PddThemeGoodsSearchResponse.class);
            }
            return GenericResponseExtUtils.buildSuccessWithData(pddThemeGoodsSearchResponse);
        }catch (Exception e){
            log.error("主题商品查询异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(pddThemeGoodsSearchResponse);
        }
    }

    @Override
    public GenericResponseExt<PddGoodsRecommendGetResponse> findRecommendGoods(@Valid PddGoodsRecommendGetRequest request) {
        PddGoodsRecommendGetResponse pddGoodsRecommendGetResponse = null;
        try{
            PddDdkGoodsRecommendGetRequest pddDdkGoodsRecommendGetRequest = CachedBeanCopierUtils.copy(request, PddDdkGoodsRecommendGetRequest.class);
            PddDdkGoodsRecommendGetResponse pddDdkGoodsRecommendGetResponse = popClient.syncInvoke(pddDdkGoodsRecommendGetRequest);
            PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponse goodsBasicDetailResponse = pddDdkGoodsRecommendGetResponse.getGoodsBasicDetailResponse();

            if(goodsBasicDetailResponse != null){
                pddGoodsRecommendGetResponse = CachedBeanCopierUtils.copy(goodsBasicDetailResponse, PddGoodsRecommendGetResponse.class);
            }
            return GenericResponseExtUtils.buildSuccessWithData(pddGoodsRecommendGetResponse);
        }catch (Exception e){
            log.error("运营频道商品查询异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(pddGoodsRecommendGetResponse);
        }
    }

}
