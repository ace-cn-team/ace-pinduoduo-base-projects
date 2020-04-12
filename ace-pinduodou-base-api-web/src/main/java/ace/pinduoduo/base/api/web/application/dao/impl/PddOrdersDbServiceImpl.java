package ace.pinduoduo.base.api.web.application.dao.impl;

import ace.fw.mybatis.plus.extension.service.impl.MybatisPlusDbServiceImpl;
import ace.pinduoduo.base.api.web.application.dao.PddOrdersDbService;
import ace.pinduoduo.base.api.web.application.dao.mapper.PddOrdersMapper;
import ace.pinduoduo.define.dao.model.entity.PddOrders;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import org.apache.ibatis.binding.MapperMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author qjunjia
 */
@Service
public class PddOrdersDbServiceImpl
        extends MybatisPlusDbServiceImpl<PddOrders,PddOrdersMapper>
        implements PddOrdersDbService {

    private final String MAPPER_STATEMENT_NAME = "updateBatchAccountIdById";

    private final int BATCH_SIZE = 1000;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean updateBatchAccountIdById(Collection<PddOrders> entityList) {
        Assert.notEmpty(entityList, "error: entityList must not be empty", new Object[0]);
        String sqlStatement = MAPPER_STATEMENT_NAME;
        int size = entityList.size();
        this.executeBatch((sqlSession) -> {
            int i = 1;
            for(Iterator var6 = entityList.iterator(); var6.hasNext(); ++i) {
                PddOrders anEntityList = (PddOrders)var6.next();
                MapperMethod.ParamMap<PddOrders> param = new MapperMethod.ParamMap();
                param.put("et", anEntityList);
                sqlSession.update(sqlStatement, param);
                if (i % BATCH_SIZE == 0 || i == size) {
                    sqlSession.flushStatements();
                }
            }

        });
        return true;
    }
}
