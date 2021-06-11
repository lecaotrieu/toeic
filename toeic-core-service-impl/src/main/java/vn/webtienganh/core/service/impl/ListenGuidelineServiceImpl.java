package vn.webtienganh.core.service.impl;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import vn.webtienganh.core.dao.ListenGuidelineDao;
import vn.webtienganh.core.daoimpl.ListenGuidelineDaoImpl;
import vn.webtienganh.core.dto.ListenGuideLineDTO;
import vn.webtienganh.core.persistence.entity.ListenGuideLineEntity;
import vn.webtienganh.core.service.ListenGuidelineService;
import vn.webtienganh.core.service.utils.SingletonDaoUtil;
import vn.webtienganh.core.utils.ListenGuidelineBeanUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListenGuidelineServiceImpl implements ListenGuidelineService {
    private ListenGuidelineDao listenGuideLineDao = new ListenGuidelineDaoImpl();

    @Override
    public Object[] findListenGuideLineByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        List<ListenGuideLineDTO> result = new ArrayList<ListenGuideLineDTO>();
        Object[] objects = SingletonDaoUtil.getListenGuidelineDaoInstance().findByProperty(property, sortExpression, sortDirection, offset, limit,null);
        for (ListenGuideLineEntity item : (List<ListenGuideLineEntity>) objects[1]) {
            ListenGuideLineDTO dto = ListenGuidelineBeanUtil.entity2Dto(item);
            result.add(dto);
        }
        objects[1] = result;
        return objects;
    }

    @Override
    public ListenGuideLineDTO findByListenGuidelineId(int id) throws ObjectNotFoundException {
        ListenGuideLineEntity entity = SingletonDaoUtil.getListenGuidelineDaoInstance().findById(id);
        ListenGuideLineDTO dto = ListenGuidelineBeanUtil.entity2Dto(entity);
        return dto;
    }

    @Override
    public void saveListenGuideline(ListenGuideLineDTO dto) throws ConstraintViolationException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        dto.setCreatedDate(timestamp);
        ListenGuideLineEntity entity = ListenGuidelineBeanUtil.dto2Entity(dto);
        SingletonDaoUtil.getListenGuidelineDaoInstance().save(entity);
    }

    @Override
    public ListenGuideLineDTO updateListenGuideline(ListenGuideLineDTO dto) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        dto.setModifieddate(timestamp);
        ListenGuideLineEntity entity = ListenGuidelineBeanUtil.dto2Entity(dto);
        entity = SingletonDaoUtil.getListenGuidelineDaoInstance().update(entity);
        dto = ListenGuidelineBeanUtil.entity2Dto(entity);
        return dto;
    }

    @Override
    public Integer delete(List<Integer> ids) {
        Integer result = SingletonDaoUtil.getListenGuidelineDaoInstance().delete(ids);
        return result;
    }

}
