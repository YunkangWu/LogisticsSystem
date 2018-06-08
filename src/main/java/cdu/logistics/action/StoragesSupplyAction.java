package cdu.logistics.action;

import cdu.logistics.bean.StoragesSupply;
import cdu.logistics.bean.User;
import cdu.logistics.service.StoragesSupplyService;
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
 * @description 货源信息控制器
 */
@Controller
@RequestMapping("/storagesSupply")
public class StoragesSupplyAction {

    private StoragesSupply storagesSupply;

    @Autowired
    private StoragesSupplyService storagesSupplyService;

    /**
     * 查询显示所有仓储信息
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String list(HttpServletRequest request, StoragesSupply storagesSupply) {
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
        String hql = "from StoragesSupply where storageCheck=1";
        String storagesCity = request.getParameter("storagesCity");
        String capacity = request.getParameter("capacity");
        String storageType = request.getParameter("storageType");

        if (storageType != null && !"".equals(storageType)) {
            hql += " and storageType = "+ storageType +"";
        }
        if (storagesCity != null && !"".equals(storagesCity)) {
            hql += " and storagesCity like '%" + storagesCity + "%'";
        }
        if (capacity != null && !"".equals(capacity)) {
            hql += " and capacity like '%" + capacity + "%'";
        }

        pageModel.setPageSize(7);// 设置页面显示最大 值
        pageModel.setTotalCount(storagesSupplyService.findAllByPage(hql).size()); // 数据总条数
        pageModel.setNum(2); // 设置当前页的前后距离,/**前后各显示5页**/
        // 通过当前页和
        List<StoragesSupply> storagesSupplyList = storagesSupplyService.findByPage(hql,
                pageModel.getPageSize(), pageModel.getPage());

        pageModel.setItems(storagesSupplyList);
        //pageModel.setTotalCount(goodsSupplyList.size());
        request.setAttribute("count", storagesSupplyList.size());// 放置在request中
        request.setAttribute("pageModel", pageModel);
        request.setAttribute("page", pageModel.getPage());
        request.setAttribute("storagesSupplyList", storagesSupplyList);
        request.setAttribute("storagesCity",storagesCity);
        request.setAttribute("capacity",capacity);
        request.setAttribute("storageType",storageType);

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
        return "/user/infoList/storagesSupplyList";
    }

    /**
     * 管理员查询显示所有仓储信息
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
        String hql = "from StoragesSupply where (storageCheck=1 or storageCheck=0)";
        String storagesCity = request.getParameter("storagesCity");
        String capacity = request.getParameter("capacity");
        String storageType = request.getParameter("storageType");

        if (storageType != null && !"".equals(storageType)) {
            hql += " and storageType = "+ storageType +"";
        }
        if (storagesCity != null && !"".equals(storagesCity)) {
            hql += " and storagesCity like '%" + storagesCity + "%'";
        }
        if (capacity != null && !"".equals(capacity)) {
            hql += " and capacity like '%" + capacity + "%'";
        }

        pageModel.setPageSize(7);// 设置页面显示最大 值
        pageModel.setTotalCount(storagesSupplyService.findAllByPage(hql).size()); // 数据总条数
        pageModel.setNum(2); // 设置当前页的前后距离,/**前后各显示5页**/
        // 通过当前页和
        List<StoragesSupply> storagesSupplyList = storagesSupplyService.findByPage(hql,
                pageModel.getPageSize(), pageModel.getPage());

        pageModel.setItems(storagesSupplyList);
        //pageModel.setTotalCount(goodsSupplyList.size());
        request.setAttribute("count", storagesSupplyList.size());// 放置在request中
        request.setAttribute("pageModel", pageModel);
        request.setAttribute("page", pageModel.getPage());
        request.setAttribute("storagesSupplyList", storagesSupplyList);
        request.setAttribute("storagesCity",storagesCity);
        request.setAttribute("capacity",capacity);
        request.setAttribute("storageType",storageType);

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
        return "/admin/infoList/storagesSupplyList";
    }

    @RequestMapping("add")
    public String addStoragesSupply(HttpSession session) {
        //发布时间
        storagesSupply.setCreateTime(new Date());
        storagesSupply.setStorageCheck(1);
        //发布用户
        storagesSupply.setStorageBelong((User) session.getAttribute("user"));
        storagesSupplyService.save(storagesSupply);
        return "redirect:/user/addInfo/addStorageSupply.jsp";
    }

    /**
     * 查看仓储详情
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("detail")
    public String detail(HttpServletRequest request, int id) {
        storagesSupply = storagesSupplyService.getById(id);
        request.setAttribute("storagesSupply",storagesSupply);
        return "/user/detail/storagesSupplyDetail";
    }

    /**
     * 跳转至修改信息状态
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("toChangeCheck")
    public String toChangeCheck(HttpServletRequest request, int id) {
        storagesSupply = storagesSupplyService.getById(id);
        request.setAttribute("storagesSupply", storagesSupply);
        return "/admin/changeCheck/storageCheck";
    }

    /**
     * 修改信息状态保存
     * @param id
     * @param storageCheck
     * @return
     */
    @RequestMapping("changeCheck")
    public String changeCheck(int id,int storageCheck) {
        storagesSupplyService.changeCheck(id,storageCheck);

        return "forward:/storagesSupply/adminList";
    }

    /**
     * 判断是否有权限发布该信息
     *
     * @return
     */
    @RequestMapping("addInfo")
    public String addInfo(HttpSession session, HttpServletResponse response, User user) throws IOException {
        user = (User) session.getAttribute("user");
        if (user.getCompanyType() == 3) {
            return "redirect:/user/addInfo/addStorageSupply.jsp";
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('您没有该权限，网页将自动跳转到已发布的仓储信息');window.location='list';window.close();</script>");
            response.getWriter().flush();
            return null;
        }
    }

    /**
     * 查询本用户发布的车源信息
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("personal")
    public String personal(HttpServletRequest request,HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<StoragesSupply> storagesSupplyList = storagesSupplyService.getPersonal(user.getId());

        request.setAttribute("storagesSupplyList", storagesSupplyList);
        return "/user/manage/storagesSupplyManage";
    }

    /**
     * 修改按钮，传递了用户的id，数据库查询到内容显示在页面
     */
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, int id) {
        StoragesSupply storagesSupply = storagesSupplyService.getById(id);
        request.setAttribute("storagesSupply", storagesSupply);
        return "/user/editInfo/editStoragesSupply";
    }

    /**
     * 修改站内信息保存
     *
     * @param source
     * @return
     */
    @RequestMapping("editStoragesSupply")
    public String editCarSupply(HttpServletRequest request, StoragesSupply source) {

        StoragesSupply storagesSupply = storagesSupplyService.getById(source.getId());
        storagesSupply.setStoragesCity(source.getStoragesCity());
        storagesSupply.setStoragesLocation(source.getStoragesLocation());
        storagesSupply.setStorageType(source.getStorageType());
        storagesSupply.setCapacity(source.getCapacity());
        storagesSupply.setStoragePrice(source.getStoragePrice());

        storagesSupplyService.update(storagesSupply);

        return "forward:/storagesSupply/personal";
    }

    /**
     * 删除站内公告
     *
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    public String delete(@RequestParam("id") Integer[] ids) {

        storagesSupplyService.deleteByIds(ids);
        return "forward:/storagesSupply/personal";
    }

}
