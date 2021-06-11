package vn.webtienganh.core.utils;

import vn.webtienganh.core.dto.ExerciseQuestionDTO;
import vn.webtienganh.core.persistence.entity.ExerciseQuestionEntity;

public class ExerciseQuestionBeanUtil {
    public static ExerciseQuestionDTO entity2Dto(ExerciseQuestionEntity entity) {
        ExerciseQuestionDTO dto = new ExerciseQuestionDTO();
        dto.setExerciseQuestionId(entity.getExerciseQuestionId());
        dto.setAudio(entity.getAudio());
        dto.setImage(entity.getImage());
        dto.setCorrectAnswer(entity.getCorrectAnswer());
        dto.setQuestion(entity.getQuestion());
        dto.setOption1(entity.getOption1());
        dto.setOption2(entity.getOption2());
        dto.setOption3(entity.getOption3());
        dto.setOption4(entity.getOption4());
        dto.setCreatedDate(entity.getCreateddate());
        dto.setModifiedDate(entity.getModifieddate());
        return dto;
    }
    public static ExerciseQuestionEntity dto2Entity(ExerciseQuestionDTO dto) {
        ExerciseQuestionEntity entity = new ExerciseQuestionEntity();
        entity.setExerciseQuestionId(dto.getExerciseQuestionId());
        entity.setAudio(dto.getAudio());
        entity.setImage(dto.getImage());
        entity.setCorrectAnswer(dto.getCorrectAnswer());
        entity.setQuestion(dto.getQuestion());
        entity.setOption1(dto.getOption1());
        entity.setOption2(dto.getOption2());
        entity.setOption3(dto.getOption3());
        entity.setOption4(dto.getOption4());
        entity.setCreateddate(dto.getCreatedDate());
        entity.setModifieddate(dto.getModifiedDate());
        return entity;
    }
}
