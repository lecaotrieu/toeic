package vn.webtienganh.core.service.impl;

import vn.webtienganh.core.dto.ExerciseDTO;
import vn.webtienganh.core.dto.ExerciseQuestionDTO;
import vn.webtienganh.core.persistence.entity.ExerciseEntity;
import vn.webtienganh.core.persistence.entity.ExerciseQuestionEntity;
import vn.webtienganh.core.service.ExerciseQuestionService;
import vn.webtienganh.core.service.utils.SingletonDaoUtil;
import vn.webtienganh.core.utils.ExerciseBeanUtil;
import vn.webtienganh.core.utils.ExerciseQuestionBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExerciseQuestionServiceImpl implements ExerciseQuestionService {
    @Override
    public Object[] findExerciseQuestionByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit, Integer exerciseId) {
        List<ExerciseQuestionDTO> result = new ArrayList<ExerciseQuestionDTO>();
        String whereClause = null;
        whereClause = " AND exerciseEntity.exerciseId = " + exerciseId + "";
        Object[] objects = SingletonDaoUtil.getExerciseQuestionDaoImpl().findByProperty(property, sortExpression, sortDirection, offset, limit, whereClause);
        for (ExerciseQuestionEntity item : (List<ExerciseQuestionEntity>) objects[1]) {
            ExerciseQuestionDTO dto = ExerciseQuestionBeanUtil.entity2Dto(item);
            dto.setExercise(ExerciseBeanUtil.entity2Dto(item.getExerciseEntity()));
            result.add(dto);
        }
        objects[1] = result;
        return objects;
    }
}
