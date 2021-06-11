package vn.webtienganh.core.utils;

import vn.webtienganh.core.dto.ListenGuideLineDTO;
import vn.webtienganh.core.persistence.entity.ListenGuideLineEntity;

public class ListenGuidelineBeanUtil {
    public static ListenGuideLineDTO entity2Dto(ListenGuideLineEntity entity) {
        ListenGuideLineDTO dto = new ListenGuideLineDTO();
        dto.setListenguidelineid(entity.getListenguidelineid());
        dto.setContent(entity.getContent());
        dto.setTitle(entity.getTitle());
        dto.setImage(entity.getImage());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setModifieddate(entity.getModifieddate());
        return dto;
    }
    public static ListenGuideLineEntity dto2Entity(ListenGuideLineDTO dto) {
        ListenGuideLineEntity entity = new ListenGuideLineEntity();
        entity.setListenguidelineid(dto.getListenguidelineid());
        entity.setContent(dto.getContent());
        entity.setTitle(dto.getTitle());
        entity.setImage(dto.getImage());
        entity.setModifieddate(dto.getModifieddate());
        entity.setCreatedDate(dto.getCreatedDate());
        return entity;
    }
}
