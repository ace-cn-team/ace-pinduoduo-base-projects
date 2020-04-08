package ace.pinduoduo.base.api.web.application.dao.impl;

import ace.fw.mybatis.plus.extension.service.impl.MybatisPlusDbServiceImpl;
import ace.pinduoduo.base.api.web.application.dao.PddOrdersDbService;
import ace.pinduoduo.base.api.web.application.dao.mapper.PddOrdersMapper;
import ace.pinduoduo.define.dao.model.entity.PddOrders;
import org.springframework.stereotype.Service;

/**
 * @author qjunjia
 */
@Service
public class PddOrdersDbServiceImpl
        extends TestMybatisPlusDbServiceImpl<PddOrdersMapper,PddOrders>
        implements PddOrdersDbService {
}
