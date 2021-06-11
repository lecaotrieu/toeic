package vn.webtienganh.core.service.impl;

import vn.webtienganh.core.dao.RoleDao;
import vn.webtienganh.core.daoimpl.RoleDaoImpl;
import vn.webtienganh.core.dto.RoleDTO;
import vn.webtienganh.core.persistence.entity.RoleEntity;
import vn.webtienganh.core.service.RoleService;
import vn.webtienganh.core.utils.RoleBeanUtil;

import java.util.ArrayList;
import java.util.List;

public class RoleServiceImpl implements RoleService {
    RoleDao roleDao = new RoleDaoImpl();
    @Override
    public List<RoleDTO> findAll() {
        List<RoleEntity> entities = roleDao.findAll();
        List<RoleDTO> dtos = new ArrayList<>();
        for (RoleEntity entity: entities) {
            RoleDTO dto = RoleBeanUtil.entity2Dto(entity);
            dtos.add(dto);
        }
        return dtos;
    }
}
