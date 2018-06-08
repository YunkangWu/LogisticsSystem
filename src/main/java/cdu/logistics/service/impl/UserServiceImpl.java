package cdu.logistics.service.impl;

import cdu.logistics.bean.Admin;
import cdu.logistics.bean.StoragesSupply;
import cdu.logistics.bean.User;
import cdu.logistics.dao.UserDao;
import cdu.logistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @description ServiceImpl接口实现
 */

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

   /* @Override
    @Resource(name = "userDao")
    public UserDao getBaseDao() {
        return (UserDao) super.getBaseDao();
    }

    @Override
    public void setBaseDao(BaseDao<User> baseDao) {
        super.setBaseDao(baseDao);
    }*/

    @Override
    public User loginByName(String userName) {
        return userDao.loginByName(userName);
    }

    @Override
    public User loginByNameAndPass(String userName, String password) {
        return userDao.loginByNameAndPass(userName, password);
    }

    @Override
    public Admin adminLogin(String userName, String password) {
        return userDao.adminLogin(userName, password);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public User checkUsername(String username) {
        return userDao.checkUsername(username);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        userDao.deleteByIds(ids);
    }

    public List<User> findByPage(String hql, int pagesize, int offset){
        return userDao.findByPage(hql, pagesize, offset);
    }

    @Override
    public List<User> findAllByPage(String hql) {
        return userDao.findAllByPage(hql);
    }
}
