package cdu.logistics.service;

import cdu.logistics.bean.CarsSupply;

import java.util.List;

/**
 * @description 车源信息接口类
 */
public interface CarsSupplyService {

    //获取所有车源信息
    public List<CarsSupply> getAllCarsSupplys();

    //管理员获取所有车源信息
    public List<CarsSupply> getAll();

    //添加车源信息
    public void save(CarsSupply carsSupply);

    //根据id查询车源信息
    public CarsSupply getById(int id);

    //修改信息状态
    public void changeCheck(int id, int carCheck);

    //管理发布信息中查询到个人账号发布的信息
    public List<CarsSupply> getPersonal(int id);

    //通过id数组删除车源数据
    public void deleteByIds(Integer[] ids);

    //修改保存
    public void update(CarsSupply carsSupply);

    //分页查询
    public List<CarsSupply> findByPage(String hql, int pagesize, int offset);

    //条件查询所有得到总数
    public List<CarsSupply> findAllByPage(String hql);
}
