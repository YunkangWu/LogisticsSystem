package cdu.logistics.dao;

import cdu.logistics.bean.StationInfo;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description 站内公告增删查改DAO
 */
@Repository
@SuppressWarnings("unchecked")
public class StationInfoDao extends BaseDao<StationInfo>{

    //查询所有站内信息
    public List<StationInfo> getAllStationInfos() {
        String hql = "from StationInfo";
        Query query = getSession().createQuery(hql);
        List<StationInfo> list = query.list();
        return list;
    }
}
