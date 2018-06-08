package cdu.logistics.service;

import cdu.logistics.bean.News;

import java.util.List;

/**
 * @description 用户增删改查Service接口
 */
public interface NewsService {

    //查询显示所有站内公告
    public List<News> getAllNews();

    //添加保存公告
    public void save(News news);

    //通过id查询到用户信息
    public News getById(int id);

    //修改的保存
    public void update(News news);

    //通过id数组删除用户数据
    public void deleteByIds(Integer[] ids);

}
