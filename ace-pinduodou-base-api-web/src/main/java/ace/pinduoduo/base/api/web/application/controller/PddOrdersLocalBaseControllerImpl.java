package ace.pinduoduo.base.api.web.application.controller;

import ace.fw.copier.cglib.util.CachedBeanCopierUtils;
import ace.fw.data.model.GenericCondition;
import ace.fw.data.model.PageResponse;
import ace.fw.data.model.Sort;
import ace.fw.data.model.request.resful.PageQueryRequest;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.GenericResponseExtUtils;
import ace.pinduoduo.base.api.controller.PddOrdersLocalBaseController;
import ace.pinduoduo.base.api.web.application.dao.PddOrdersDbService;
import ace.pinduoduo.define.base.request.PddOrdersEntryAccountIdRequest;
import ace.pinduoduo.define.base.request.PddOrdersLocalPageRequest;
import ace.pinduoduo.define.base.request.PddOrdersLocalSaveRequest;
import ace.pinduoduo.define.base.request.PddOrdersNoMemberIdPageRequest;
import ace.pinduoduo.define.base.response.PddOrdersLocalPageResponse;
import ace.pinduoduo.define.base.response.PddOrdersNoMemberIdPageResponse;
import ace.pinduoduo.define.dao.model.entity.PddOrders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * @author qjj
 * @create 2020/4/6 23:14
 * @description 本地订单类(本地数据库存档)
 */
@RestController
@Slf4j
public class PddOrdersLocalBaseControllerImpl
        implements PddOrdersLocalBaseController {

    @Autowired
    private PddOrdersDbService pddOrdersDbService;

    @Override
    public GenericResponseExt<Boolean> savePddOrders(@Valid PddOrdersLocalSaveRequest request) {
        List<PddOrdersLocalSaveRequest.PddOrdersItemRequest> pddOrdersItemRequestList = request.getPddOrdersItemRequestList();
        List<PddOrders> pddOrdersList = CachedBeanCopierUtils.copyList(pddOrdersItemRequestList, PddOrders.class);
        pddOrdersList.forEach(pddOrders -> {
            pddOrders.setId(UUID.randomUUID().toString());
        });
        pddOrdersDbService.saveBatch(pddOrdersList);
        return GenericResponseExtUtils.buildSuccessWithData(Boolean.TRUE);
    }

    @Override
    public GenericResponseExt<PageResponse<PddOrdersLocalPageResponse>> pageByAccountId(@Valid PddOrdersLocalPageRequest request) {

        List<GenericCondition<String>> conditions = new ArrayList();
        GenericCondition<String> accountIdCondition = new GenericCondition<>();
        accountIdCondition.setField("accountId");
        accountIdCondition.setValue(request.getAccountId());
        conditions.add(accountIdCondition);

        PageQueryRequest pageQueryRequest = new PageQueryRequest();
        pageQueryRequest.setPageSize(request.getPageSize());
        pageQueryRequest.setPageIndex(request.getPageIndex());
        pageQueryRequest.setConditions(conditions);

        List<Sort> sortsList = new ArrayList<>();
        Sort sort = new Sort();
        sort.setAsc(false);
        sort.setField("createTime");
        sortsList.add(sort);
        pageQueryRequest.setSorts(sortsList);

        PageResponse<PddOrders> page = pddOrdersDbService.page(pageQueryRequest);
        List<PddOrdersLocalPageResponse> pddOrdersLocalPageResponseList = CachedBeanCopierUtils.copyList(page.getData(), PddOrdersLocalPageResponse.class);

        PageResponse<PddOrdersLocalPageResponse>  pddOrderLocalPageResponsePageResponse = new PageResponse<>();
        pddOrderLocalPageResponsePageResponse.setTotalCount(page.getTotalCount());
        pddOrderLocalPageResponsePageResponse.setTotalPage(page.getTotalPage());
        pddOrderLocalPageResponsePageResponse.setData(pddOrdersLocalPageResponseList);
        return GenericResponseExtUtils.buildSuccessWithData(pddOrderLocalPageResponsePageResponse);
    }

    @Override
    public GenericResponseExt<PageResponse<PddOrdersNoMemberIdPageResponse>> pageNoAccountId(@Valid PddOrdersNoMemberIdPageRequest request) {
        List<GenericCondition<String>> conditions = new ArrayList();
        GenericCondition<String> accountIdCondition = new GenericCondition<>();
        accountIdCondition.setField("accountId");
        accountIdCondition.setValue("");
        conditions.add(accountIdCondition);

        List<Sort> sortsList = new ArrayList<>();
        Sort sort = new Sort();
        sort.setAsc(true);
        sort.setField("createTime");
        sortsList.add(sort);

        PageQueryRequest pageQueryRequest = new PageQueryRequest();
        pageQueryRequest.setPageSize(request.getPageSize());
        pageQueryRequest.setPageIndex(request.getPageIndex());
        pageQueryRequest.setConditions(conditions);
        pageQueryRequest.setSorts(sortsList);

        PageResponse<PddOrders> page = pddOrdersDbService.page(pageQueryRequest);
        List<PddOrdersNoMemberIdPageResponse> pddOrdersNoMemberIdPageResponseList = CachedBeanCopierUtils.copyList(page.getData(), PddOrdersNoMemberIdPageResponse.class);

        PageResponse<PddOrdersNoMemberIdPageResponse>  pddOrdersNoMemberIdPageResponsePageResponse = new PageResponse<>();
        pddOrdersNoMemberIdPageResponsePageResponse.setTotalCount(page.getTotalCount());
        pddOrdersNoMemberIdPageResponsePageResponse.setTotalPage(page.getTotalPage());
        pddOrdersNoMemberIdPageResponsePageResponse.setData(pddOrdersNoMemberIdPageResponseList);
        return GenericResponseExtUtils.buildSuccessWithData(pddOrdersNoMemberIdPageResponsePageResponse);
    }

    @Override
    public GenericResponseExt<Boolean> entryAccountId(@Valid PddOrdersEntryAccountIdRequest request) {
        List<PddOrdersEntryAccountIdRequest.PddOrdersEntryAccountIdItemRequest> pddOrdersEntryAccountIdItemRequestList = request.getPddOrdersEntryAccountIdItemRequestList();
        List<PddOrders> pddOrdersList = CachedBeanCopierUtils.copyList(pddOrdersEntryAccountIdItemRequestList, PddOrders.class);
        pddOrdersDbService.updateBatchAccountIdById(pddOrdersList);
        return GenericResponseExtUtils.buildSuccessWithData(Boolean.TRUE);
    }
}
