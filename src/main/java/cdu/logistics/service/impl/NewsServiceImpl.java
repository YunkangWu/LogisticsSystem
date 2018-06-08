package cdu.logistics.service.impl;

import cdu.logistics.bean.News;
import cdu.logistics.dao.NewsDao;
import cdu.logistics.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("NewsService")
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public List<News> getAllNews() {
        return newsDao.getAll();
    }

    @Override
    public void save(News news) {
        newsDao.save(news);
    }

    @Override
    public News getById(int id) {
        return newsDao.getById(id);
    }

    @Override
    public void update(News news) {
        newsDao.update(news);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        newsDao.deleteByIds(ids);
    }
}
