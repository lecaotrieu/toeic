package vn.webtienganh.core.utils;

import vn.webtienganh.core.dto.ExaminationQuestionDTO;
import vn.webtienganh.core.persistence.entity.ExaminationQuestionEntity;

/**
 * Created by Admin on 3/12/2017.
 */
public class ExaminationQuestionBeanUtil {
	public static ExaminationQuestionDTO entity2Dto(ExaminationQuestionEntity entity) {
		ExaminationQuestionDTO dto = new ExaminationQuestionDTO();
		dto.setExaminationQuestionId(entity.getExaminationQuestionId());
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
		dto.setType(entity.getType());
		dto.setParagraph(entity.getParagraph());
		return dto;
	}
	public static ExaminationQuestionEntity dto2Entity(ExaminationQuestionDTO dto) {
		ExaminationQuestionEntity entity = new ExaminationQuestionEntity();
		entity.setExaminationQuestionId(dto.getExaminationQuestionId());
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
		entity.setType(dto.getType());
		entity.setParagraph(dto.getParagraph());
		return entity;
	}
}
