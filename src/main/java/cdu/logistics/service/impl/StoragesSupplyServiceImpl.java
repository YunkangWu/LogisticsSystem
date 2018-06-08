package cdu.logistics.service.impl;

import cdu.logistics.bean.StoragesSupply;
import cdu.logistics.dao.StoragesSupplyDao;
import cdu.logistics.service.StoragesSupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @description ServiceImpl接口实现
 */

@Transactional
@Service("StoragesSupplyService")
public class StoragesSupplyServiceImpl implements StoragesSupplyService {

    @Autowired
    private StoragesSupplyDao storagesSupplyDao;

    /**
     * 查询仓储信息
     * @return
     */
    @Override
    public List<StoragesSupply> getAllStoragesSupplys() {
        return storagesSupplyDao.getAllStoragesSupplys();
    }

    /**
     * 管理员查询仓储信息
     * @return
     */
    @Override
    public List<StoragesSupply> getAll() {
        return storagesSupplyDao.getAll();
    }

    /**
     * 添加仓储信息
     * @param storagesSupply
     */
    @Override
    public void save(StoragesSupply storagesSupply) {
        storagesSupplyDao.save(storagesSupply);
    }

    /**
     * 根据id查询仓储详情
     * @param id
     * @return
     */
    @Override
    public StoragesSupply getById(int id) {
        return storagesSupplyDao.getById(id);
    }

    @Override
    public void changeCheck(int id, int storageCheck) {
        storagesSupplyDao.changeCheck(id, storageCheck);
    }

    @Override
    public List<StoragesSupply> getPersonal(int id) {
        return storagesSupplyDao.getPersonal(id);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        storagesSupplyDao.deleteByIds(ids);
    }

    @Override
    public void update(StoragesSupply storagesSupply) {
        storagesSupplyDao.update(storagesSupply);
    }

    public List<StoragesSupply> findByPage(String hql,int pagesize,int offset){
        return storagesSupplyDao.findByPage(hql, pagesize, offset);
    }

    @Override
    public List<StoragesSupply> findAllByPage(String hql) {
        return storagesSupplyDao.findAllByPage(hql);
    }
}
