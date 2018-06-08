package cdu.logistics.service.impl;

import cdu.logistics.bean.JobsSupply;
import cdu.logistics.dao.JobsSupplyDao;
import cdu.logistics.service.JobsSupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * /**
 * @description ServiceImpl接口实现
 */

@Transactional
@Service("JobsSupplyService")
public class JobsSupplyServiceImpl implements JobsSupplyService {

    @Autowired
    private JobsSupplyDao jobsSupplyDao;

    /**
     * 用户查询招聘信息，状态为1
     * @return
     */
    @Override
    public List<JobsSupply> getAllJobsSupplys() {
        return jobsSupplyDao.getAllJobsSupplys();
    }

    /**
     * 管理员查询招聘信息
     * @return
     */
    @Override
    public List<JobsSupply> getAll() {
        return jobsSupplyDao.getAll();
    }

    /**
     * 添加招聘信息
     * @param jobsSupply
     */
    @Override
    public void save(JobsSupply jobsSupply) {
        jobsSupplyDao.save(jobsSupply);
    }

    /**
     * 根据id查询招聘信息详情
     * @param id
     * @return
     */
    @Override
    public JobsSupply getById(int id) {
        return jobsSupplyDao.getById(id);
    }

    @Override
    public void changeCheck(int id, int jobCheck) {
        jobsSupplyDao.changeCheck(id, jobCheck);
    }

    @Override
    public List<JobsSupply> getPersonal(int id) {
        return jobsSupplyDao.getPersonal(id);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        jobsSupplyDao.deleteByIds(ids);
    }

    @Override
    public void update(JobsSupply jobsSupply) {
        jobsSupplyDao.update(jobsSupply);
    }

    public List<JobsSupply> findByPage(String hql,int pagesize,int offset){
        return jobsSupplyDao.findByPage(hql, pagesize, offset);
    }

    @Override
    public List<JobsSupply> findAllByPage(String hql) {
        return jobsSupplyDao.findAllByPage(hql);
    }
}
