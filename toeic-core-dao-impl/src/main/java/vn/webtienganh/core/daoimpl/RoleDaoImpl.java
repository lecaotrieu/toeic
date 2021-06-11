package vn.webtienganh.core.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.webtienganh.core.common.utils.HibernateUtils;
import vn.webtienganh.core.dao.RoleDao;
import vn.webtienganh.core.data.daoimpl.AbstractDao;
import vn.webtienganh.core.persistence.entity.RoleEntity;
import vn.webtienganh.core.persistence.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl extends AbstractDao<Integer, RoleEntity> implements RoleDao {
    @Override
    public List<RoleEntity> findByRoles(List<String> roles) {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<RoleEntity> roleEntities = new ArrayList<>();
        try {
            StringBuilder sql = new StringBuilder(" FROM RoleEntity re WHERE re.name IN (:roles) ");
            Query query = session.createQuery(sql.toString());
            query.setParameterList("roles",roles);
            roleEntities = query.list();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
        return roleEntities;
    }
}
