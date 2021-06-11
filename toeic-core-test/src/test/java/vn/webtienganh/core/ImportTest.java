package vn.webtienganh.core;

import org.junit.Test;
import vn.webtienganh.core.dao.RoleDao;
import vn.webtienganh.core.daoimpl.RoleDaoImpl;
import vn.webtienganh.core.persistence.entity.RoleEntity;

public class ImportTest {
    @Test
    public void TestImport() {
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity entity = roleDao.findEqualUnique("name","USER");
        System.out.println(entity.getName());
    }
}
