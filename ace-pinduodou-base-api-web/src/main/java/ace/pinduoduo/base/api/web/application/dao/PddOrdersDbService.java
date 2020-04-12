package ace.pinduoduo.base.api.web.application.dao;

import ace.fw.mybatis.plus.extension.service.MybatisPlusDbService;
import ace.pinduoduo.define.dao.model.entity.PddOrders;

import java.util.Collection;

/**
 * @author qjunjia
 */
public interface PddOrdersDbService extends MybatisPlusDbService<PddOrders> {

    /**
     * 录入accountId
     * @param entityList
     * @return
     */
    public boolean updateBatchAccountIdById(Collection<PddOrders> entityList);

}
