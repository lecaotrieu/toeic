package vn.webtienganh.core.service.impl;

import vn.webtienganh.core.dto.ExaminationDTO;
import vn.webtienganh.core.persistence.entity.ExaminationEntity;
import vn.webtienganh.core.service.ExaminationService;
import vn.webtienganh.core.service.utils.SingletonDaoUtil;
import vn.webtienganh.core.utils.ExaminationBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExaminationServiceImpl implements ExaminationService {
    @Override
    public Object[] findExaminationByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
        List<ExaminationDTO> result = new ArrayList<ExaminationDTO>();
        Object[] objects = SingletonDaoUtil.getExaminationDaoImpl().findByProperty(property, sortExpression, sortDirection, offset, limit,null);
        for (ExaminationEntity item : (List<ExaminationEntity>) objects[1]) {
            ExaminationDTO dto = ExaminationBeanUtil.entity2Dto(item);
            result.add(dto);
        }
        objects[1] = result;
        return objects;
    }
}
