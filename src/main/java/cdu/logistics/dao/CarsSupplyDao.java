package cdu.logistics.dao;

import cdu.logistics.bean.CarsSupply;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description 车源信息增删查改DAO
 */
@Repository
@SuppressWarnings("unchecked")
public class CarsSupplyDao extends BaseDao<CarsSupply> {

    //查询所有货源
    public List<CarsSupply> getAllCarsSupplys() {
        String hql = "from CarsSupply where carCheck=1";
        Query query = getSession().createQuery(hql);
        List<CarsSupply> list = query.list();
        return list;
    }

    //修改信息状态
    public void changeCheck(int id, int carCheck) {
        String sql = "update carsSupply set car_check = :carCheck where id = :id";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setInteger("carCheck", carCheck);
        query.setInteger("id", id);
        query.executeUpdate();
    }

    //管理发布信息，查询该用户发布的车源信息
    public List<CarsSupply> getPersonal(int id) {
        String hql = "from CarsSupply where carCheck=1 and carBelong.id=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        List<CarsSupply> list = query.list();
        return list;
    }

    //分页查询
    public List<CarsSupply> findByPage(String hql, int pagesize, int offset) {
        List<CarsSupply> carsSupplyList = getSession().createQuery(hql)
                .setFirstResult((offset - 1) * pagesize).setMaxResults(pagesize).list();
        return carsSupplyList;
    }

    //条件查询所有得到总数
    public List<CarsSupply> findAllByPage(String hql) {
        List<CarsSupply> list = getSession().createQuery(hql).list();
        return list;
    }
}
