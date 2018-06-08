package cdu.logistics.dao;

import cdu.logistics.bean.LinesSupply;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description 专线信息增删查改DAO
 */
@Repository
@SuppressWarnings("unchecked")
public class LinesSupplyDao extends BaseDao<LinesSupply> {

    //查询所有货源
    public List<LinesSupply> getAllLinesSupplys() {
        String hql = "from LinesSupply where lineCheck = 1";
        Query query = getSession().createQuery(hql);
        List<LinesSupply> list = query.list();
        return list;
    }

    //修改信息状态
    public void changeCheck(int id, int lineCheck) {
        String sql = "update linesSupply set line_check = :lineCheck where id = :id";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setInteger("lineCheck", lineCheck);
        query.setInteger("id", id);
        query.executeUpdate();
    }

    //管理发布信息，查询该用户发布的专线信息
    public List<LinesSupply> getPersonal(int id) {
        String hql = "from LinesSupply where lineCheck=1 and lineBelong.id=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        List<LinesSupply> list = query.list();
        return list;
    }

    //分页查询
    public List<LinesSupply> findByPage(String hql, int pagesize, int offset) {
        List<LinesSupply> linesSupplyList = getSession().createQuery(hql)
                .setFirstResult((offset - 1) * pagesize).setMaxResults(pagesize).list();
        return linesSupplyList;
    }

    //条件查询所有得到总数
    public List<LinesSupply> findAllByPage(String hql) {
        List<LinesSupply> list = getSession().createQuery(hql).list();
        return list;
    }
}
