package ace.pinduoduo.base.api.web.application.controller;

import ace.fw.copier.BeanCopier;
import ace.fw.copier.cglib.impl.CachedBeanCopier;
import ace.fw.copier.cglib.util.CachedBeanCopierUtils;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.GenericResponseExtUtils;
import ace.pinduoduo.base.api.controller.PddGoodsBaseController;
import ace.pinduoduo.define.base.request.PddGoodsBasicDetailRequest;
import ace.pinduoduo.define.base.request.PddTopGoodsListRequest;
import ace.pinduoduo.define.base.response.PddGoodsBasicDetailResponse;
import ace.pinduoduo.define.base.response.PddTopGoodsListResponse;
import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.api.request.PddDdkGoodsBasicInfoGetRequest;
import com.pdd.pop.sdk.http.api.request.PddDdkTopGoodsListQueryRequest;
import com.pdd.pop.sdk.http.api.response.PddDdkGoodsBasicInfoGetResponse;
import com.pdd.pop.sdk.http.api.response.PddDdkTopGoodsListQueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
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

            List<PddDdkTopGoodsListQueryResponse.TopGoodsListGetResponseListItem> topGoodsListGetResponseListItemList = topGoodsListGetResponse.getList();
            List<PddTopGoodsListResponse.TopGoodsListGetResponseListItem> topGoodsListGetResponseListItems = CachedBeanCopierUtils.copyList(topGoodsListGetResponseListItemList, PddTopGoodsListResponse.TopGoodsListGetResponseListItem.class);
            pddTopGoodsListResponse.setList(topGoodsListGetResponseListItems);
            pddTopGoodsListResponse.setListId(topGoodsListGetResponse.getListId());
            pddTopGoodsListResponse.setSearchId(topGoodsListGetResponse.getSearchId());
            pddTopGoodsListResponse.setTotal(topGoodsListGetResponse.getTotal());

            return GenericResponseExtUtils.buildSuccessWithData(pddTopGoodsListResponse);
        }catch (Exception e){
            log.error("查询爆款排行商品异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(pddTopGoodsListResponse);
        }
    }

    @Override
    public GenericResponseExt<PddGoodsBasicDetailResponse> findGoodsBasicDetails(@Valid PddGoodsBasicDetailRequest request) {
        PddGoodsBasicDetailResponse pddGoodsBasicDetailResponse = new PddGoodsBasicDetailResponse();

        try {
            //获取拼多多商品信息
            PddDdkGoodsBasicInfoGetRequest pddDdkGoodsBasicInfoGetRequest = new PddDdkGoodsBasicInfoGetRequest();
            pddDdkGoodsBasicInfoGetRequest.setGoodsIdList(request.getGoodsIdList());
            PddDdkGoodsBasicInfoGetResponse response = popClient.syncInvoke(pddDdkGoodsBasicInfoGetRequest);
            List<PddDdkGoodsBasicInfoGetResponse.GoodsBasicDetailResponseGoodsListItem> goodsList = response.getGoodsBasicDetailResponse().getGoodsList();

            List<PddGoodsBasicDetailResponse.GoodsBasicDetailResponseGoodsListItem> resultList = CachedBeanCopierUtils.copyList(goodsList, PddGoodsBasicDetailResponse.GoodsBasicDetailResponseGoodsListItem.class);
            pddGoodsBasicDetailResponse.setGoodsBasicDetailList(resultList);
            return GenericResponseExtUtils.buildSuccessWithData(pddGoodsBasicDetailResponse);
        }catch (Exception e){
            log.error("查询商品信息异常,请求:[{}],异常:[{}]", request.toString(), e);
            return GenericResponseExtUtils.buildFailureWithData(pddGoodsBasicDetailResponse);
        }
    }
}
