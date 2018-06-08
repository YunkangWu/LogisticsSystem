package cdu.logistics.service.impl;

import cdu.logistics.bean.GoodsSupply;
import cdu.logistics.dao.GoodsSupplyDao;
import cdu.logistics.service.GoodsSupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * /**
 * @description ServiceImpl接口实现
 */

@Transactional
@Service("GoodsSupplyService")
public class GoodsSupplyServiceImpl implements GoodsSupplyService {

    @Autowired
    private GoodsSupplyDao goodsSupplyDao;

    /**
     * 查询所有货源信息
     * @return
     */
    @Override
    public List<GoodsSupply> getAll() {
        return goodsSupplyDao.getAll();
    }

    @Override
    public List<GoodsSupply> getAllGoodsSupplys() {
        return goodsSupplyDao.getAllGoodsSupplys();
    }


    /**
     * 添加保存货源信息
     * @param goodsSupply
     */
    @Override
    public void save(GoodsSupply goodsSupply) {
        goodsSupplyDao.save(goodsSupply);
    }

    /**
     * 根据id查询得到货源信息
     */
    @Override
    public GoodsSupply getById(int id) {
        return goodsSupplyDao.getById(id);
    }

    @Override
    public void changeCheck(int id, int goodCheck) {
        goodsSupplyDao.changeCheck(id, goodCheck);
    }

    @Override
    public List<GoodsSupply> getPersonal(int id) {
        return goodsSupplyDao.getPersonal(id);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        goodsSupplyDao.deleteByIds(ids);
    }

    @Override
    public void update(GoodsSupply goodsSupply) {
        goodsSupplyDao.update(goodsSupply);
    }

    public List<GoodsSupply> findByPage(String hql,int pagesize,int offset){
        return goodsSupplyDao.findByPage(hql, pagesize, offset);
    }

    @Override
    public List<GoodsSupply> findAllByPage(String hql) {
        return goodsSupplyDao.findAllByPage(hql);
    }

}
