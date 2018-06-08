package cdu.logistics.dao;

import cdu.logistics.bean.GoodsSupply;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description 货源信息增删查改DAO
 */
@Repository
@SuppressWarnings("unchecked")
public class GoodsSupplyDao extends BaseDao<GoodsSupply> {

    //用户查询所有货源,信息状态为1
    public List<GoodsSupply> getAllGoodsSupplys() {
        String hql = "from GoodsSupply where goodCheck=1";
        Query query = getSession().createQuery(hql);
        List<GoodsSupply> list = query.list();
        return list;
    }

    //修改信息状态
    public void changeCheck(int id, int goodCheck) {
        String sql = "update goodsSupply set goods_check = :goodCheck where id = :id";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setInteger("goodCheck", goodCheck);
        query.setInteger("id", id);
        query.executeUpdate();
    }

    //管理发布信息，查询该用户发布的货源信息
    public List<GoodsSupply> getPersonal(int id) {
        String hql = "from GoodsSupply where goodCheck=1 and goodsBelong.id=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        List<GoodsSupply> list = query.list();
        return list;
    }

    //分页查询
    public List<GoodsSupply> findByPage(String hql, int pagesize, int offset) {
        List<GoodsSupply> goodsSupplyList = getSession().createQuery(hql)
                .setFirstResult((offset - 1) * pagesize).setMaxResults(pagesize).list();
        return goodsSupplyList;
    }

    //条件查询所有得到总数
    public List<GoodsSupply> findAllByPage(String hql) {
        List<GoodsSupply> list = getSession().createQuery(hql).list();
        return list;
    }
}
