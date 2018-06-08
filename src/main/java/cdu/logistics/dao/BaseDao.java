package cdu.logistics.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @param <T> 泛型
 * @description 所有dao的父类, 继承BaseDao将会拥有基础的增删改查方法和条件查询方法
 */
@SuppressWarnings("unchecked")
public abstract class BaseDao<T> {

    @Resource
    private SessionFactory sessionFactory;

    /**
     * T的真实际类型
     */
    public Class<T> clazz;
    /**
     * T的简单类名(不是全限定名)
     */
    public String className;

    // 默认构造方法(在创建子类对象的时候调用)
    public BaseDao() {
        // 获取当前类(子类)的泛型化父类
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        // 获取泛型化父类的类型参数数组的第一个, 强转为Class<T> 注意: (Map<String, Object>的泛型有两个所以是数组)
        clazz = (Class<T>) type.getActualTypeArguments()[0];
        // 获取简单类名(不是全限定名)
        className = clazz.getSimpleName();
    }

    /**
     * 获取当前session
     *
     * @return session
     */
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 保存实体
     *
     * @param entity 实体
     */
    public void save(T entity) {
        getSession().save(entity);
    }

    /**
     * 更新实体
     *
     * @param entity 实体
     */
    public void update(T entity) {
        getSession().update(entity);
        getSession().flush();
    }

    /**
     * 保存或者更新实体(id == 0是保存, id != 0是更新)
     *
     * @param entity 实体
     */
    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    /**
     * 删除实体
     *
     * @param entity 实体
     */
    public void delete(T entity) {
        getSession().delete(entity);
    }

    /**
     * 通过id删除实体
     *
     * @param id 主键
     * @return 受到影响的行数
     */
    public int deleteById(int id) {
        return getSession().createQuery("DELETE FROM " + className + " WHERE id=?").setParameter(0, id).executeUpdate();
    }

    /**
     * 通过id数组删除实体
     *
     * @param ids 主键数组
     * @return 受到影响的行数
     */
    public int deleteByIds(Integer[] ids) {
        return getSession().createQuery("DELETE FROM " + className + " WHERE id IN(:ids)").setParameterList("ids", ids).executeUpdate();
    }

    /**
     * 通过id获取实体
     *
     * @param id 主键
     * @return 实体
     */
    public T getById(int id) {
        // return (T) getSession().get(clazz, id);
        Query query = getSession().createQuery("FROM " + className + " WHERE id=?").setParameter(0, id);
        List<T> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    /**
     * 慎重使用, 通过代码获取实体, 如果没有code字段(Field)或者code的类型不是String会报错!
     *
     * @param code 主代码
     * @return 实体
     */
    public T getByCode(String code) {
        try {
            Field field = clazz.getDeclaredField("code");
            field.getName();
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }
        Query query = getSession().createQuery("FROM " + className + " WHERE code=?").setParameter(0, code);
        List<T> list = query.list();
        return list.size() > 0 ? list.get(0) : null;
    }

    /**
     * 通过id数组获取实体
     *
     * @param ids 主键数组
     * @return 实体List集合
     */
    public List<T> getByIds(Integer[] ids) {
        return getSession().createQuery("FROM " + className + " WHERE id IN(:ids)").setParameterList("ids", ids).list();
    }

    /**
     * 查询所有实体
     *
     * @return 所有实体
     */
    public List<T> getAll() {
        return getSession().createQuery("FROM " + className).list();
    }

    public int getTotalCount() {
        Query query = getSession().createQuery("SELECT COUNT(*) FROM " + className);
        return ((Long) query.uniqueResult()).intValue();
    }

}
