package cdu.logistics.dao;

import cdu.logistics.bean.JobsSupply;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description 招聘信息增删查改DAO
 */
@Repository
@SuppressWarnings("unchecked")
public class JobsSupplyDao extends BaseDao<JobsSupply> {

    //查询所有招聘信息
    public List<JobsSupply> getAllJobsSupplys() {
        String hql = "from JobsSupply where jobCheck = 1";
        Query query = getSession().createQuery(hql);
        List<JobsSupply> list = query.list();
        return list;
    }

    //修改信息状态
    public void changeCheck(int id, int jobCheck) {
        String sql = "update jobsSupply set job_check = :jobCheck where id = :id";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setInteger("jobCheck", jobCheck);
        query.setInteger("id", id);
        query.executeUpdate();
    }

    //管理发布信息，查询该用户发布的招聘信息
    public List<JobsSupply> getPersonal(int id) {
        String hql = "from JobsSupply where jobCheck=1 and jobBelong.id=?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, id);
        List<JobsSupply> list = query.list();
        return list;
    }

    //分页查询
    public List<JobsSupply> findByPage(String hql, int pagesize, int offset) {
        List<JobsSupply> jobsSupplyList = getSession().createQuery(hql)
                .setFirstResult((offset - 1) * pagesize).setMaxResults(pagesize).list();
        return jobsSupplyList;
    }

    //条件查询所有得到总数
    public List<JobsSupply> findAllByPage(String hql) {
        List<JobsSupply> list = getSession().createQuery(hql).list();
        return list;
    }
}
