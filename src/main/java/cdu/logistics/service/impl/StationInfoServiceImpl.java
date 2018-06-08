package cdu.logistics.service.impl;

import cdu.logistics.bean.StationInfo;
import cdu.logistics.dao.StationInfoDao;
import cdu.logistics.service.StationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
 * @description 站内信息增删改查ServiceImpl接口实现
 */

@Transactional
@Service("StationInfoService")
public class StationInfoServiceImpl implements StationInfoService {

    @Autowired
    private StationInfoDao stationInfoDao;

    @Override
    public List<StationInfo> getAllStationInfos() {
        return stationInfoDao.getAllStationInfos();
    }

    @Override
    public void save(StationInfo stationInfo) {
        stationInfoDao.save(stationInfo);
    }

    @Override
    public StationInfo getById(int id) {
        return stationInfoDao.getById(id);
    }

    @Override
    public void update(StationInfo stationInfo) {
        stationInfoDao.update(stationInfo);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        stationInfoDao.deleteByIds(ids);
    }
}
