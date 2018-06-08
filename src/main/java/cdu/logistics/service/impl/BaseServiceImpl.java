package cdu.logistics.service.impl;

import cdu.logistics.dao.BaseDao;
import cdu.logistics.service.BaseService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @description 基本接口实现
 *
 */
@Transactional
public class BaseServiceImpl<T> implements BaseService<T> {

    private BaseDao<T> baseDao;

    /**
     * 子类必须重写这个方法, 并且注入对应的BaseDao
     * (OrderService需注入BaseDao<Order>)
     * @param baseDao
     */
    protected void setBaseDao(BaseDao<T> baseDao) {
        this.baseDao = baseDao;
    }

    protected BaseDao<T> getBaseDao() {
        return baseDao;
    }


    @Override
    public void save(T entity) {
        baseDao.save(entity);
    }

    @Override
    public void update(T entity) {
        baseDao.update(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        baseDao.saveOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {
        baseDao.delete(entity);
    }

    @Override
    public int deleteById(int id) {
        return baseDao.deleteById(id);
    }

    @Override
    public int deleteByIds(Integer[] ids) {
        return baseDao.deleteByIds(ids);
    }

    @Override
    public T getById(int id) {
        return baseDao.getById(id);
    }

    @Override
    public T getByCode(String code) {
        return baseDao.getByCode(code);
    }

    @Override
    public List<T> getByIds(Integer[] ids) {
        return baseDao.getByIds(ids);
    }

    @Override
    public List<T> getAll() {
        return baseDao.getAll();
    }
}