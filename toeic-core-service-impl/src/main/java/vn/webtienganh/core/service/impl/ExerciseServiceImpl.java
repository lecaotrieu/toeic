package vn.webtienganh.core.service.impl;

import vn.webtienganh.core.dto.ExerciseDTO;
import vn.webtienganh.core.persistence.entity.ExerciseEntity;
import vn.webtienganh.core.service.ExerciseService;
import vn.webtienganh.core.service.utils.SingletonDaoUtil;
import vn.webtienganh.core.utils.ExerciseBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExerciseServiceImpl implements ExerciseService {
    @Override
    public Object[] findExerciseByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
            List<ExerciseDTO> result = new ArrayList<ExerciseDTO>();
            Object[] objects = SingletonDaoUtil.getExerciseDaoImpl().findByProperty(property, sortExpression, sortDirection, offset, limit,null);
            for (ExerciseEntity item : (List<ExerciseEntity>) objects[1]) {
                ExerciseDTO dto = ExerciseBeanUtil.entity2Dto(item);
                result.add(dto);
            }
            objects[1] = result;
            return objects;
    }
}
