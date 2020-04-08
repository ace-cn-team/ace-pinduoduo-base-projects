package ace.pinduoduo.base.api.web.application.controller;

import ace.fw.copier.cglib.util.CachedBeanCopierUtils;
import ace.fw.data.model.PageResponse;
import ace.fw.model.response.GenericResponseExt;
import ace.fw.util.GenericResponseExtUtils;
import ace.pinduoduo.base.api.controller.PddOrdersLocalBaseController;
import ace.pinduoduo.base.api.web.application.dao.PddOrdersDbService;
import ace.pinduoduo.define.base.request.PddOrdersLocalPageRequest;
import ace.pinduoduo.define.base.request.PddOrdersLocalSaveRequest;
import ace.pinduoduo.define.base.response.PddOrderLocalPageResponse;
import ace.pinduoduo.define.dao.model.entity.PddOrders;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
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
        LocalDateTime localDateTime = LocalDateTime.now();
        pddOrdersList.forEach(pddOrders -> {
            pddOrders.setId(UUID.randomUUID().toString());
            pddOrders.setCreateTime(localDateTime);
            pddOrders.setUpdateTime(localDateTime);
            //todo 补账号id
            pddOrders.setAccountId("");
        });
        pddOrdersDbService.saveBatch(pddOrdersList);
        return GenericResponseExtUtils.buildSuccessWithData(Boolean.TRUE);
    }

    @Override
    public GenericResponseExt<PageResponse<PddOrderLocalPageResponse>> pagePddOrdersLocal(@Valid PddOrdersLocalPageRequest request) {
//        pddOrdersDbService.page()
        return null;
    }
}
