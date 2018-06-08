package cdu.logistics.dao;

import cdu.logistics.bean.StoragesSupply;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description 专线信息增删查改DAO
 */
@Repository
@SuppressWarnings("unchecked")
public class StoragesSupplyDao extends BaseDao<StoragesSupply> {

    //用户查询所有货源，状态为1
    public List<StoragesSupply> getAllStoragesSupplys() {
        String hql = "from StoragesSupply where storageCheck = 1";
        Query query = getSession().createQuery(hql);
        List<StoragesSupply> list = query.list();
        return list;
    }

    //修改信息状态
    public void changeCheck(int id, int storageCheck) {
        String sql = "update storagesSupply set storage_check = :storageCheck where id = :id";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setInteger("storageCheck", storageCheck);
        query.setInteger("id", id);
        query.executeUpdate();
    }

    //管理发布信息，查询该用户发布的仓储信息
    public List<StoragesSupply> getPersonal(int id) {
        String hql = "from StoragesSupply where storageCheck=1 and storageBelong.id=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        List<StoragesSupply> list = query.list();
        return list;
    }

    //分页查询
    public List<StoragesSupply> findByPage(String hql, int pagesize, int offset) {
        List<StoragesSupply> storagesSupplyList = getSession().createQuery(hql)
                .setFirstResult((offset - 1) * pagesize).setMaxResults(pagesize).list();
        return storagesSupplyList;
    }

    //条件查询所有得到总数
    public List<StoragesSupply> findAllByPage(String hql) {
        List<StoragesSupply> list = getSession().createQuery(hql).list();
        return list;
    }
}
