package vn.webtienganh.core.utils;

import vn.webtienganh.core.dto.ExerciseDTO;
import vn.webtienganh.core.persistence.entity.ExerciseEntity;

public class ExerciseBeanUtil {
    public static ExerciseDTO entity2Dto(ExerciseEntity entity) {
        ExerciseDTO dto = new ExerciseDTO();
        dto.setExerciseId(entity.getExerciseId());
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        dto.setCreatedDate(entity.getCreateddate());
        dto.setModifiedDate(entity.getModifieddate());
        return dto;
    }
    public static ExerciseEntity dto2Entity(ExerciseDTO dto) {
        ExerciseEntity entity = new ExerciseEntity();
        entity.setExerciseId(dto.getExerciseId());
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setCreateddate(dto.getCreatedDate());
        entity.setModifieddate(dto.getModifiedDate());
        return entity;
    }
}
