package cdu.logistics.service;

import cdu.logistics.bean.Admin;
import cdu.logistics.bean.User;

import java.util.List;

/**
 * @description 用户增删改查Service接口
 */
public interface UserService{

    //用户是否存在
    public User loginByName(String userName);

    //验证用户名密码
    public User loginByNameAndPass(String userName, String password);

    //管理员登陆验证
    public Admin adminLogin(String admin, String password);

    //获取所有用户
    public List<User> getAllUsers();

    //保存用户
    public void save(User user);

    // 按用户名查询用户的方法:
    public User checkUsername(String username);

    //通过id查询到用户信息
    public User getById(int id);

    //修改的保存
    public void update(User user);

    //通过id数组删除用户数据
    public void deleteByIds(Integer[] ids);

    //分页查询
    public List<User> findByPage(String hql, int pagesize, int offset);

    //条件查询所有得到总数
    public List<User> findAllByPage(String hql);


}
