package cdu.logistics.service;

import cdu.logistics.bean.LinesSupply;

import java.util.List;

/**
 * @description 货源信息接口类
 */
public interface LinesSupplyService {

    //获取所有货源信息
    public List<LinesSupply> getAllLinesSupplys();

    //获取所有货源信息
    public List<LinesSupply> getAll();

    //添加专线信息
    public void save(LinesSupply linesSupply);

    //根据id查询专线信息
    public LinesSupply getById(int id);

    //修改信息状态
    public void changeCheck(int id, int lineCheck);

    //管理发布信息中查询到个人账号发布的信息
    public List<LinesSupply> getPersonal(int id);

    //通过id数组删除货源数据
    public void deleteByIds(Integer[] ids);

    //更新
    public void update(LinesSupply linesSupply);

    //分页查询
    public List<LinesSupply> findByPage(String hql, int pagesize, int offset);

    //条件查询所有得到总数
    public List<LinesSupply> findAllByPage(String hql);
}
