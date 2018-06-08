package cdu.logistics.service;

import cdu.logistics.bean.StoragesSupply;

import java.util.List;

/**
 * @description 仓储信息接口类
 */
public interface StoragesSupplyService {

    //获取仓储信息
    public List<StoragesSupply> getAllStoragesSupplys();

    //获取仓储信息
    public List<StoragesSupply> getAll();

    //添加仓储信息
    public void save(StoragesSupply storagesSupply);

    //根据id查询仓储详情
    public StoragesSupply getById(int id);

    //修改信息状态
    public void changeCheck(int id, int storageCheck);

    //管理发布信息中查询到个人账号发布的信息
    public List<StoragesSupply> getPersonal(int id);

    //通过id数组删除仓储数据
    public void deleteByIds(Integer[] ids);

    //更新
    public void update(StoragesSupply storagesSupply);

    //分页查询
    public List<StoragesSupply> findByPage(String hql, int pagesize, int offset);

    //条件查询所有得到总数
    public List<StoragesSupply> findAllByPage(String hql);
}
