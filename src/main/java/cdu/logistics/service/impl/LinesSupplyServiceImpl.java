package cdu.logistics.service.impl;

import cdu.logistics.bean.GoodsSupply;
import cdu.logistics.bean.LinesSupply;
import cdu.logistics.dao.LinesSupplyDao;
import cdu.logistics.service.LinesSupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * /**
 * @description ServiceImpl接口实现
 */

@Transactional
@Service("LinesSupplyService")
public class LinesSupplyServiceImpl implements LinesSupplyService {

    @Autowired
    private LinesSupplyDao linesSupplyDao;

    @Override
    public List<LinesSupply> getAllLinesSupplys() {
        return linesSupplyDao.getAllLinesSupplys();
    }

    @Override
    public List<LinesSupply> getAll() {
        return linesSupplyDao.getAll();
    }

    @Override
    public void save(LinesSupply linesSupply) {
        linesSupplyDao.save(linesSupply);
    }

    @Override
    public LinesSupply getById(int id) {
        return linesSupplyDao.getById(id);
    }

    @Override
    public void changeCheck(int id, int lineCheck) {
        linesSupplyDao.changeCheck(id, lineCheck);
    }

    @Override
    public List<LinesSupply> getPersonal(int id) {
        return linesSupplyDao.getPersonal(id);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        linesSupplyDao.deleteByIds(ids);
    }

    @Override
    public void update(LinesSupply linesSupply) {
        linesSupplyDao.update(linesSupply);
    }

    public List<LinesSupply> findByPage(String hql,int pagesize,int offset){
        return linesSupplyDao.findByPage(hql, pagesize, offset);
    }

    @Override
    public List<LinesSupply> findAllByPage(String hql) {
        return linesSupplyDao.findAllByPage(hql);
    }
}
