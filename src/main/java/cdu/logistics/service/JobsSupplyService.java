package cdu.logistics.service;

import cdu.logistics.bean.JobsSupply;

import java.util.List;

/**
 * @description 招聘信息接口类
 */
public interface JobsSupplyService {

    //获取招聘信息
    public List<JobsSupply> getAllJobsSupplys();

    //获取招聘信息
    public List<JobsSupply> getAll();

    //添加招聘信息
    public void save(JobsSupply jobsSupply);

    //根据id查询招聘信息详情
    public JobsSupply getById(int id);

    //修改信息状态
    public void changeCheck(int id, int jobCheck);

    //管理发布信息中查询到个人账号发布的信息
    public List<JobsSupply> getPersonal(int id);

    //通过id数组删除货源数据
    public void deleteByIds(Integer[] ids);

    //更新
    public void update(JobsSupply jobsSupply);

    //分页查询
    public List<JobsSupply> findByPage(String hql, int pagesize, int offset);

    //条件查询所有得到总数
    public List<JobsSupply> findAllByPage(String hql);
}
