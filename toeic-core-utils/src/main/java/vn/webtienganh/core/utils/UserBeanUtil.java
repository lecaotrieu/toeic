package vn.webtienganh.core.utils;

import vn.webtienganh.core.dto.UserDTO;
import vn.webtienganh.core.persistence.entity.UserEntity;

public class UserBeanUtil {
    public static UserDTO entity2Dto(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setUserId(entity.getUserId());
        dto.setName(entity.getName());
        dto.setFullName(entity.getFullName());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setPassword(entity.getPassword());
        dto.setRoleDTO(RoleBeanUtil.entity2Dto(entity.getRole()));
        return dto;
    }
    public static UserEntity dto2Entity(UserDTO dto) {
        UserEntity entity = new UserEntity();
        entity.setUserId(dto.getUserId());
        entity.setName(dto.getName());
        entity.setFullName(dto.getFullName());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setPassword(dto.getPassword());
        entity.setRole(RoleBeanUtil.dto2Entity(dto.getRoleDTO()));
        return entity;
    }
}
