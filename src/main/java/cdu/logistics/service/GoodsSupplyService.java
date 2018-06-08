package cdu.logistics.service;

import cdu.logistics.bean.GoodsSupply;

import java.util.List;

/**
 * @description 货源信息接口类
 */
public interface GoodsSupplyService {

    //获取所有货源信息
    public List<GoodsSupply> getAll();

    //用户获取所有货源信息
    public List<GoodsSupply> getAllGoodsSupplys();

    //添加货源信息
    public void save(GoodsSupply goodsSupply);

    //通过id查询得到货源信息
    public GoodsSupply getById(int id);

    //修改信息状态
    public void changeCheck(int id, int goodCheck);

    //管理发布信息中查询到个人账号发布的信息
    public List<GoodsSupply> getPersonal(int id);

    //通过id数组删除货源数据
    public void deleteByIds(Integer[] ids);

    //更新
    public void update(GoodsSupply goodsSupply);

    //分页查询
    public List<GoodsSupply> findByPage(String hql,int pagesize,int offset);

    //条件查询所有得到总数
    public List<GoodsSupply> findAllByPage(String hql);

}
