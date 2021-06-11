package vn.webtienganh.core.service.impl;

import vn.webtienganh.core.dto.ExaminationQuestionDTO;
import vn.webtienganh.core.persistence.entity.ExaminationQuestionEntity;
import vn.webtienganh.core.service.ExaminationQuestionService;
import vn.webtienganh.core.service.utils.SingletonDaoUtil;
import vn.webtienganh.core.utils.ExaminationBeanUtil;
import vn.webtienganh.core.utils.ExaminationQuestionBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExaminationQuestionServiceImpl implements ExaminationQuestionService {
    @Override
    public Object[] findExaminationQuestionByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, Integer examinationId) {
        List<ExaminationQuestionDTO> result = new ArrayList<ExaminationQuestionDTO>();
        String whereClause = null;
        whereClause = " AND examinationEntity.examinationId = " + examinationId + "";
        Object[] objects = SingletonDaoUtil.getExaminationQuestionDaoImpl().findByProperty(property, sortExpression, sortDirection, offset, limit, whereClause);
        int count = 1;
        for (ExaminationQuestionEntity item : (List<ExaminationQuestionEntity>) objects[1]) {
            ExaminationQuestionDTO dto = ExaminationQuestionBeanUtil.entity2Dto(item);
            if (item.getParagraph() == null) {
                dto.setNumber(count);
                count++;
            }
            dto.setExamination(ExaminationBeanUtil.entity2Dto(item.getExaminationEntity()));
            result.add(dto);
        }
        objects[1] = result;
        return objects;
    }
}
