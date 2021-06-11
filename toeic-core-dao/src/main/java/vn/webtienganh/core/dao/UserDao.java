package vn.webtienganh.core.dao;

import vn.webtienganh.core.data.dao.GenericDao;
import vn.webtienganh.core.persistence.entity.UserEntity;

import java.util.List;

public interface UserDao extends GenericDao<Integer, UserEntity> {
    Object[] checkLogin(String name,  String password);
    List<UserEntity> findByUsers(List<String> names);

}
