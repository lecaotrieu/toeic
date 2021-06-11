package vn.webtienganh.core.dao;

import vn.webtienganh.core.data.dao.GenericDao;
import vn.webtienganh.core.persistence.entity.RoleEntity;

import java.util.List;

public interface RoleDao extends GenericDao<Integer, RoleEntity> {
    List<RoleEntity> findByRoles(List<String> roles);
}
