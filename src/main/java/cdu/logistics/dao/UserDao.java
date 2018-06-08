package cdu.logistics.dao;

import cdu.logistics.bean.Admin;
import cdu.logistics.bean.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description 用户增删查改DAO
 */
@Repository
@SuppressWarnings("unchecked")
public class UserDao extends BaseDao<User> {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * @param userName 用户名
     * @return
     */
    public User loginByName(String userName) {
        String hql = "FROM User WHERE userName = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, userName);
        List<User> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    /**
     * 判断密码是否正确
     *
     * @param userName 登录名
     * @param password 密码
     * @return 用户
     */
    public User loginByNameAndPass(String userName, String password) {
        String hql = "from User where userName = ? and password = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, userName);
        query.setParameter(1, password);
        List<User> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    /**
     * 判断管理员登录
     *
     * @param userName
     * @param password
     * @return
     */
    public Admin adminLogin(String userName, String password) {
        String hql = "from Admin where admin = ? and password = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, userName);
        query.setParameter(1, password);
        List<Admin> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    //查询所有用户
    public List<User> getAllUsers() {
        String hql = "from User";
        Query query = getSession().createQuery(hql);
        List<User> list = query.list();
        return list;
    }

    //AJAX进行异步校验用户名的执行方法
    public User checkUsername(String userName) {
        String hql = "from User where userName = ? ";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, userName);
        List<User> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    //分页查询
    public List<User> findByPage(String hql, int pagesize, int offset) {
        List<User> userList = getSession().createQuery(hql)
                .setFirstResult((offset - 1) * pagesize).setMaxResults(pagesize).list();
        return userList;
    }

    //条件查询所有得到总数
    public List<User> findAllByPage(String hql) {
        List<User> list = getSession().createQuery(hql).list();
        return list;
    }
}
