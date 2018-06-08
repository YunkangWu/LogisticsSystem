package cdu.logistics.service;

import cdu.logistics.bean.StationInfo;

import java.util.List;

/**
 * @description 站内信息增删改查Service接口
 */
public interface StationInfoService {

    //查询显示所有站内公告
    public List<StationInfo> getAllStationInfos();

    //添加保存公告
    public void save(StationInfo stationInfo);

    //通过id查询到用户信息
    public StationInfo getById(int id);

    //修改的保存
    public void update(StationInfo stationInfo);

    //通过id数组删除用户数据
    public void deleteByIds(Integer[] ids);

}
