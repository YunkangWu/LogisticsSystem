package cdu.logistics.service;

import java.util.List;

/**
 * @param <T> 泛型
 * @description 所有Service的父接口, 继承BaseService将拥有增删改查和分页查询功能
 * XXService需要继承BaseService
 * XXServiceImpl需要继承BaseServiceImpl实现XXService注入相应的Dao
 */
public interface BaseService<T> {

    /**
     * 保存实体
     *
     * @param entity 实体
     */
    public void save(T entity);

    /**
     * 更新实体
     *
     * @param entity 实体
     */
    public void update(T entity);

    /**
     * 保存或者更新实体(id == 0是保存, id != 0是更新)
     *
     * @param entity 实体
     */
    public void saveOrUpdate(T entity);


    /**
     * 删除实体
     *
     * @param entity 实体
     */
    public void delete(T entity);

    /**
     * 通过id删除实体
     *
     * @param id 主键
     * @return 受到影响的行数
     */
    public int deleteById(int id);

    /**
     * 通过id数组删除实体
     *
     * @param ids 主键数组
     * @return 受到影响的行数
     */
    public int deleteByIds(Integer[] ids);

    /**
     * 通过id获取实体
     *
     * @param id 主键
     * @return 实体
     */
    public T getById(int id);

    /**
     * 慎重使用, 通过代码获取实体, 如果没有code字段(Field)或者code的类型不是String会报错!
     *
     * @param code 主代码
     * @return 实体
     */
    public T getByCode(String code);

    /**
     * 通过id数组获取实体
     *
     * @param ids 主键数组
     * @return 实体List集合
     */
    public List<T> getByIds(Integer[] ids);

    /**
     * 查询所有实体
     *
     * @return 所有实体
     */
    public List<T> getAll();

}