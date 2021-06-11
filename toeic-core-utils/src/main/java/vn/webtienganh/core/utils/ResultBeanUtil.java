package vn.webtienganh.core.utils;

import vn.webtienganh.core.dto.ResultDTO;
import vn.webtienganh.core.persistence.entity.ResultEntity;

/**
 * Created by Admin on 3/12/2017.
 */
public class ResultBeanUtil {
	public static ResultDTO entity2Dto(ResultEntity entity) {
		ResultDTO dto = new ResultDTO();
		dto.setResultId(entity.getResultId());
		dto.setListenScore(entity.getListensCore());
		dto.setReadingScore(entity.getReadingsCore());
		dto.setCreatedDate(entity.getCreateddate());
		return dto;
	}
	public static ResultEntity dto2Entity(ResultDTO dto) {
		ResultEntity entity = new ResultEntity();
		entity.setResultId(dto.getResultId());
		entity.setReadingsCore(dto.getReadingScore());
		entity.setListensCore(dto.getListenScore());
		entity.setCreateddate(dto.getCreatedDate());
		return entity;
	}
}
