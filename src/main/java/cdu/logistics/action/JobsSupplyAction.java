package cdu.logistics.action;

import cdu.logistics.bean.JobsSupply;
import cdu.logistics.bean.User;
import cdu.logistics.service.JobsSupplyService;
import cdu.logistics.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @description 招聘信息控制器
 */
@Controller
@RequestMapping("/jobsSupply")
public class JobsSupplyAction {

    private JobsSupply jobsSupply;

    @Autowired
    private JobsSupplyService jobsSupplyService;

    /**
     * 查询显示已审核的招聘信息
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
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
        String hql = "from JobsSupply where jobCheck=1";
        String city = request.getParameter("city");
        String jobTitle = request.getParameter("jobTitle");


        if (city != null && !"".equals(city)) {
            hql += " and city like '%" + city + "%'";
        }
        if (jobTitle != null && !"".equals(jobTitle)) {
            hql += " and jobTitle like '%" + jobTitle + "%'";
        }

        pageModel.setPageSize(7);// 设置页面显示最大 值
        pageModel.setTotalCount(jobsSupplyService.findAllByPage(hql).size()); // 数据总条数
        pageModel.setNum(2); // 设置当前页的前后距离,/**前后各显示5页**/
        // 通过当前页和
        List<JobsSupply> jobsSupplyList = jobsSupplyService.findByPage(hql,
                pageModel.getPageSize(), pageModel.getPage());

        pageModel.setItems(jobsSupplyList);
        //pageModel.setTotalCount(goodsSupplyList.size());
        request.setAttribute("count", jobsSupplyList.size());// 放置在request中
        request.setAttribute("pageModel", pageModel);
        request.setAttribute("page", pageModel.getPage());
        request.setAttribute("jobsSupplyList", jobsSupplyList);
        request.setAttribute("city", city);
        request.setAttribute("jobTitle", jobTitle);

        String obj = request.getQueryString();
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
        return "/user/infoList/jobsSupplyList";
    }

    /**
     * 查询显示已审核的招聘信息
     * @param request
     * @return
     */
    @RequestMapping("/adminList")
    public String adminList(HttpServletRequest request) {
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
        String hql = "from JobsSupply where(jobCheck=1 or jobCheck=0)";
        String city = request.getParameter("city");
        String jobTitle = request.getParameter("jobTitle");


        if (city != null && !"".equals(city)) {
            hql += " and city like '%" + city + "%'";
        }
        if (jobTitle != null && !"".equals(jobTitle)) {
            hql += " and jobTitle like '%" + jobTitle + "%'";
        }

        pageModel.setPageSize(7);// 设置页面显示最大 值
        pageModel.setTotalCount(jobsSupplyService.findAllByPage(hql).size()); // 数据总条数
        pageModel.setNum(2); // 设置当前页的前后距离,/**前后各显示5页**/
        // 通过当前页和
        List<JobsSupply> jobsSupplyList = jobsSupplyService.findByPage(hql,
                pageModel.getPageSize(), pageModel.getPage());

        pageModel.setItems(jobsSupplyList);
        //pageModel.setTotalCount(goodsSupplyList.size());
        request.setAttribute("count", jobsSupplyList.size());// 放置在request中
        request.setAttribute("pageModel", pageModel);
        request.setAttribute("page", pageModel.getPage());
        request.setAttribute("jobsSupplyList", jobsSupplyList);
        request.setAttribute("city", city);
        request.setAttribute("jobTitle", jobTitle);

        String obj = request.getQueryString();
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
        return "/admin/infoList/jobsSupplyList";
    }

    @RequestMapping("add")
    public String addJobsSupply(HttpSession session, JobsSupply jobsSupply) {
        //发布时间
        jobsSupply.setCreateTime(new Date());
        jobsSupply.setJobCheck(1);
        //发布用户
        jobsSupply.setJobBelong((User) session.getAttribute("user"));
        jobsSupplyService.save(jobsSupply);
        return "redirect:/user/addInfo/addJobSupply.jsp";
    }

    /**
     * 查看招聘信息详情
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("detail")
    public String detail(HttpServletRequest request, int id) {
        jobsSupply = jobsSupplyService.getById(id);
        request.setAttribute("jobsSupply",jobsSupply);
        return "/user/detail/jobsSupplyDetail";
    }

    /**
     * 跳转至修改信息状态
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("toChangeCheck")
    public String toChangeCheck(HttpServletRequest request, int id) {
        jobsSupply = jobsSupplyService.getById(id);
        request.setAttribute("jobsSupply", jobsSupply);
        return "/admin/changeCheck/jobCheck";
    }

    /**
     * 修改信息状态保存
     * @param id
     * @param jobCheck
     * @return
     */
    @RequestMapping("changeCheck")
    public String changeCheck(int id,int jobCheck) {
        jobsSupplyService.changeCheck(id,jobCheck);

        return "forward:/jobsSupply/adminList";
    }

    /**
     * 判断是否有权限发布该信息
     *
     * @return
     */
    @RequestMapping("addInfo")
    public String addInfo(HttpSession session, HttpServletResponse response) throws IOException {
        User user = (User) session.getAttribute("user");
        if (user.getCompanyType() == 4) {
            return "redirect:/user/addInfo/addJobSupply.jsp";
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('您没有该权限，网页将自动跳转到已发布的招聘信息');window.location='list';window.close();</script>");
            response.getWriter().flush();
            return null;
        }
    }


    /**
     * 查询本用户发布的招聘信息
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("personal")
    public String personal(HttpServletRequest request,HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<JobsSupply> jobsSupplyList = jobsSupplyService.getPersonal(user.getId());

        request.setAttribute("jobsSupplyList", jobsSupplyList);
        return "/user/manage/jobsSupplyManage";
    }

    /**
     * 修改按钮，传递了用户的id，数据库查询到内容显示在页面
     */
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, int id) {
        JobsSupply jobsSupply = jobsSupplyService.getById(id);
        request.setAttribute("jobsSupply", jobsSupply);
        return "/user/editInfo/editJobsSupply";
    }

    /**
     * 修改站内信息保存
     *
     * @param source
     * @return
     */
    @RequestMapping("editJobsSupply")
    public String editCarSupply(HttpServletRequest request, JobsSupply source) {

        JobsSupply jobsSupply = jobsSupplyService.getById(source.getId());
        jobsSupply.setJobTitle(source.getJobTitle());
        jobsSupply.setCompanyName(source.getCompanyName());
        jobsSupply.setCity(source.getCity());
        jobsSupply.setSalary(source.getSalary());

        jobsSupplyService.update(jobsSupply);

        return "forward:/jobsSupply/personal";
    }

    /**
     * 删除站内公告
     *
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    public String delete(@RequestParam("id") Integer[] ids) {

        jobsSupplyService.deleteByIds(ids);
        return "forward:/jobsSupply/personal";
    }

}
