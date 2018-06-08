package cdu.logistics.action;


import cdu.logistics.bean.News;
import cdu.logistics.service.NewsService;
import cdu.logistics.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsAction {

    @Autowired
    private NewsService newsService;

    /**
     * 显示所有物流新闻
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String list(HttpServletRequest request, News news) {
        Page pageModel = new Page();
        // 获得当前页
        String pageinfo = (String) request.getParameter("page");
        if (pageinfo != null) {
            int page = Integer.parseInt(pageinfo);
            if (page != 0) {
                pageModel.setPage(page);
            }
        } else {
            pageModel.setPage(1);
        }
        String hql = "from News";

        pageModel.setPageSize(7);// 设置页面显示最大 值
        pageModel.setTotalCount(newsService.getAllNews().size()); // 数据总条数
        pageModel.setNum(2); // 设置当前页的前后距离,/**前后各显示5页**/
        // 通过当前页和
        List<News> newsList = newsService.getAllNews();

        pageModel.setItems(newsList);
        //pageModel.setTotalCount(goodsSupplyList.size());
        request.setAttribute("count", newsList.size());// 放置在request中
        request.setAttribute("pageModel", pageModel);
        request.setAttribute("page", pageModel.getPage());
        request.setAttribute("newsList", newsList);

        String obj = request.getQueryString();
        System.out.println("obj:" + obj);
        if (obj != null) {
            String[] fenge = obj.split("[ = & ]");
            String op = "&";
            for (int i = 0; i < fenge.length; i++) {
                if ("page".equals(fenge[i])) {
                    op += fenge[i] + "=" + fenge[++i];
                    break;
                }
            }
            obj = obj.replace(op, "");
        } else {
            obj = "";
        }
        String url = "http://" + request.getServerName() //服务器地址
                + ":"
                + request.getServerPort()           //端口号
                + request.getContextPath()      //项目名称
                + request.getServletPath()      //请求页面或其他地址
                + "?" + (obj); //参数 ;
        request.setAttribute("pageuri", url);

        // List<Person> persons = personService.findAllPerson();
        // req.setAttribute("persons", persons);
        return "/admin/newsList";
    }


    /**
     * 用户查询显示所有物流新闻
     * @param request
     * @return
     */
    @RequestMapping("/userList")
    public String userList(HttpServletRequest request, News news) {
        Page pageModel = new Page();
        // 获得当前页
        String pageinfo = (String) request.getParameter("page");
        if (pageinfo != null) {
            int page = Integer.parseInt(pageinfo);
            if (page != 0) {
                pageModel.setPage(page);
            }
        } else {
            pageModel.setPage(1);
        }
        String hql = "from News";

        pageModel.setPageSize(12);// 设置页面显示最大 值
        pageModel.setTotalCount(newsService.getAllNews().size()); // 数据总条数
        pageModel.setNum(2); // 设置当前页的前后距离,/**前后各显示5页**/
        // 通过当前页和
        List<News> newsList = newsService.getAllNews();

        pageModel.setItems(newsList);
        //pageModel.setTotalCount(goodsSupplyList.size());
        request.setAttribute("count", newsList.size());// 放置在request中
        request.setAttribute("pageModel", pageModel);
        request.setAttribute("page", pageModel.getPage());
        request.setAttribute("newsList", newsList);

        String obj = request.getQueryString();
        System.out.println("obj:" + obj);
        if (obj != null) {
            String[] fenge = obj.split("[ = & ]");
            String op = "&";
            for (int i = 0; i < fenge.length; i++) {
                if ("page".equals(fenge[i])) {
                    op += fenge[i] + "=" + fenge[++i];
                    break;
                }
            }
            obj = obj.replace(op, "");
        } else {
            obj = "";
        }
        String url = "http://" + request.getServerName() //服务器地址
                + ":"
                + request.getServerPort()           //端口号
                + request.getContextPath()      //项目名称
                + request.getServletPath()      //请求页面或其他地址
                + "?" + (obj); //参数 ;
        request.setAttribute("pageuri", url);

        // List<Person> persons = personService.findAllPerson();
        // req.setAttribute("persons", persons);
        return "/user/newsList";
    }

    /**
     * 发布物流新闻
     *
     * @return
     */
    @RequestMapping("add")
    public String addNews(News news) {
        news.setNewsTime(new Date());
        newsService.save(news);
        return "redirect:/admin/addNews.jsp";
    }


    /**
     * 修改按钮，传递了用户的id，数据库查询到内容显示在页面
     */
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, int id) {
        News news = newsService.getById(id);
        request.setAttribute("news", news);
        return "/admin/editNews";
    }

    /**
     * 显示新闻详情
     */
    @RequestMapping("show")
    public String show(HttpServletRequest request, int id) {
        News news = newsService.getById(id);
        request.setAttribute("news", news);
        return "/user/newsDetail";
    }

    /**
     * 修改站内信息保存
     *
     * @param source
     * @return
     */
    @RequestMapping("editNews")
    public String editNews(HttpServletRequest request, News source) {
        News news = newsService.getById(source.getId());
        news.setNewsTitle(source.getNewsTitle());
        news.setNewsType(source.getNewsType());
        news.setNewsFrom(source.getNewsFrom());
        news.setNewsContent(source.getNewsContent());
        newsService.update(news);

        return "forward:/news/list";
    }

    /**
     * 删除站内公告
     *
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    public String delete(@RequestParam("id") Integer[] ids) {

        newsService.deleteByIds(ids);
        return "forward:/stationInfo/list";
    }
}
