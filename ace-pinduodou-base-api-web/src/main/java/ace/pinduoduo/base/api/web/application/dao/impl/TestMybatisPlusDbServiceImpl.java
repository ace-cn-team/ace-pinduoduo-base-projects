package ace.pinduoduo.base.api.web.application.dao.impl;

import ace.fw.data.model.EntityInfo;
import ace.fw.data.model.PageResponse;
import ace.fw.data.model.entity.Entity;
import ace.fw.data.model.request.resful.PageQueryRequest;
import ace.fw.data.model.request.resful.entity.EntityUpdateForceRequest;
import ace.fw.data.model.request.resful.entity.EntityUpdateRequest;
import ace.fw.mybatis.plus.extension.service.EntityConfigInfoService;
import ace.fw.mybatis.plus.extension.service.MybatisPlusDbService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestMybatisPlusDbServiceImpl< Mapper extends BaseMapper<T>, T extends Entity> extends ServiceImpl<Mapper, T> implements MybatisPlusDbService<T> {


    @Override
    public T getOne(T t) {
        return null;
    }

    @Override
    public boolean saveBatch(List<T> list) {
        return false;
    }

    @Override
    public boolean updateBatchById(List<T> list) {
        return false;
    }

    @Override
    public boolean update(EntityUpdateRequest<T> entityUpdateRequest) {
        return false;
    }

    @Override
    public boolean updateForce(EntityUpdateForceRequest<T> entityUpdateForceRequest) {
        return false;
    }

    @Override
    public PageResponse<T> page(PageQueryRequest pageQueryRequest) {
        return null;
    }

    @Override
    public EntityInfo getEntityInfo() {
        return null;
    }
}
