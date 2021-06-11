package vn.webtienganh.core.utils;


import vn.webtienganh.core.dto.ExaminationDTO;
import vn.webtienganh.core.persistence.entity.ExaminationEntity;

/**
 * Created by Admin on 3/12/2017.
 */
public class ExaminationBeanUtil {
	public static ExaminationDTO entity2Dto(ExaminationEntity entity) {
		ExaminationDTO dto = new ExaminationDTO();
		dto.setExaminationId(entity.getExaminationId());
		dto.setName(entity.getName());
		dto.setCreatedDate(entity.getCreateddate());
		dto.setModifiedDate(entity.getModifieddate());
		return dto;
	}
	public static ExaminationEntity dto2Entity(ExaminationDTO dto) {
		ExaminationEntity entity = new ExaminationEntity();
		entity.setExaminationId(dto.getExaminationId());
		entity.setName(dto.getName());
		entity.setCreateddate(dto.getCreatedDate());
		entity.setModifieddate(dto.getModifiedDate());
		return entity;
	}
}
