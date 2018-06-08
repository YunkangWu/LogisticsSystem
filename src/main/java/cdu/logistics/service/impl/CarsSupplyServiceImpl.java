package cdu.logistics.service.impl;

import cdu.logistics.bean.CarsSupply;
import cdu.logistics.bean.GoodsSupply;
import cdu.logistics.dao.CarsSupplyDao;
import cdu.logistics.service.CarsSupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * /**
 * @description ServiceImpl接口实现
 */

@Transactional
@Service("CarsSupplyService")
public class CarsSupplyServiceImpl implements CarsSupplyService {

    @Autowired
    private CarsSupplyDao carsSupplyDao;

    /**
     * 查询显示车辆信息
     * @return
     */
    @Override
    public List<CarsSupply> getAllCarsSupplys() {
        return carsSupplyDao.getAllCarsSupplys();
    }

    @Override
    public List<CarsSupply> getAll() {
        return carsSupplyDao.getAll();
    }

    @Override
    public void save(CarsSupply carsSupply) {
        carsSupplyDao.save(carsSupply);
    }

    @Override
    public CarsSupply getById(int id) {
        return carsSupplyDao.getById(id);
    }

    @Override
    public void changeCheck(int id, int carCheck) {
        carsSupplyDao.changeCheck(id, carCheck);
    }

    @Override
    public List<CarsSupply> getPersonal(int id) {
        return carsSupplyDao.getPersonal(id);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        carsSupplyDao.deleteByIds(ids);
    }

    @Override
    public void update(CarsSupply carsSupply) {
        carsSupplyDao.update(carsSupply);
    }

    public List<CarsSupply> findByPage(String hql, int pagesize, int offset){
        return carsSupplyDao.findByPage(hql, pagesize, offset);
    }

    @Override
    public List<CarsSupply> findAllByPage(String hql) {
        return carsSupplyDao.findAllByPage(hql);
    }
}
