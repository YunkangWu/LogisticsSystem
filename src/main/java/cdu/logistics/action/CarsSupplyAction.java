package cdu.logistics.action;

import cdu.logistics.bean.CarsSupply;
import cdu.logistics.bean.User;
import cdu.logistics.service.CarsSupplyService;
import cdu.logistics.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @description 货源信息控制器
 */
@Controller
@RequestMapping("/carsSupply")
public class CarsSupplyAction {

    private CarsSupply carsSupply;

    @Autowired
    private CarsSupplyService carsSupplyService;

    /**
     * 查询显示货源信息
     * 条件查询，分页
     *
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
        String hql = "from CarsSupply where carCheck=1";
        String carType = request.getParameter("carType");
        String carCapacity = request.getParameter("carCapacity");
        String carStart = request.getParameter("carStart");
        String carEnd = request.getParameter("carEnd");
        String carTime = request.getParameter("carTime");

        if (carType != null && !"".equals(carType)) {
            hql += " and carType = "+ carType +"";
        }
        if (carCapacity != null && !"".equals(carCapacity)) {
            hql += " and carCapacity like '%" + carCapacity + "%'";
        }
        if (carStart != null && !"".equals(carStart)) {
            hql += " and carStart like '%" + carStart + "%'";
        }
        if (carEnd != null && !"".equals(carEnd)) {
            hql += " and carEnd like '%" + carEnd + "%'";
        }
        if (carTime != null && !"".equals(carTime)) {
            hql += " and carTime = date_format(" + carTime + ",'%y-%m-%d')";
        }
        pageModel.setPageSize(7);// 设置页面显示最大 值
        pageModel.setTotalCount(carsSupplyService.findAllByPage(hql).size()); // 数据总条数
        pageModel.setNum(2); // 设置当前页的前后距离,/**前后各显示5页**/
        // 通过当前页和
        List<CarsSupply> carsSupplyList = carsSupplyService.findByPage(hql,
                pageModel.getPageSize(), pageModel.getPage());

        pageModel.setItems(carsSupplyList);
        request.setAttribute("count", carsSupplyList.size());// 放置在request中
        request.setAttribute("pageModel", pageModel);
        request.setAttribute("page", pageModel.getPage());
        request.setAttribute("carsSupplyList", carsSupplyList);
        request.setAttribute("carType", carType);
        request.setAttribute("carCapacity", carCapacity);
        request.setAttribute("carStart", carStart);
        request.setAttribute("carEnd", carEnd);
        request.setAttribute("carTime", carTime);

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
        return "/user/infoList/carsSupplyList";
    }

    /**
     * 管理员查询显示货源信息
     *
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
        String hql = "from CarsSupply where (carCheck=1 or carCheck=0)";
        String carType = request.getParameter("carType");
        String carCapacity = request.getParameter("carCapacity");
        String carStart = request.getParameter("carStart");
        String carEnd = request.getParameter("carEnd");
        String carTime = request.getParameter("carTime");

        if (carType != null && !"".equals(carType)) {
            hql += " and carType = "+ carType +"";
        }
        if (carCapacity != null && !"".equals(carCapacity)) {
            hql += " and carCapacity like '%" + carCapacity + "%'";
        }
        if (carStart != null && !"".equals(carStart)) {
            hql += " and carStart like '%" + carStart + "%'";
        }
        if (carEnd != null && !"".equals(carEnd)) {
            hql += " and carEnd like '%" + carEnd + "%'";
        }
        if (carTime != null && !"".equals(carTime)) {
            hql += " and carTime = date_format(" + carTime + ",'%y-%m-%d')";
        }
        pageModel.setPageSize(7);// 设置页面显示最大 值
        pageModel.setTotalCount(carsSupplyService.findAllByPage(hql).size()); // 数据总条数
        pageModel.setNum(2); // 设置当前页的前后距离,/**前后各显示5页**/
        // 通过当前页和
        List<CarsSupply> carsSupplyList = carsSupplyService.findByPage(hql,
                pageModel.getPageSize(), pageModel.getPage());

        pageModel.setItems(carsSupplyList);
        request.setAttribute("count", carsSupplyList.size());// 放置在request中
        request.setAttribute("pageModel", pageModel);
        request.setAttribute("page", pageModel.getPage());
        request.setAttribute("carsSupplyList", carsSupplyList);
        request.setAttribute("carType", carType);
        request.setAttribute("carCapacity", carCapacity);
        request.setAttribute("carStart", carStart);
        request.setAttribute("carEnd", carEnd);
        request.setAttribute("carTime", carTime);

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
        return "/admin/infoList/carsSupplyList";
    }

    /**
     * 添加车源信息
     *
     * @param carsSupply
     * @return
     */
    @RequestMapping("add")
    public String addCarsSupply(HttpSession session, CarsSupply carsSupply) {
        //发布时间
        carsSupply.setCreateTime(new Date());
        //发布用户
        carsSupply.setCarBelong((User) session.getAttribute("user"));
        //状态默认为0.未成交
        carsSupply.setCarStatus(0);
        carsSupply.setCarCheck(1);
        carsSupplyService.save(carsSupply);
        return "redirect:/user/addInfo/addCarSupply.jsp";
    }

    /**
     * 查看车源详情
     *
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("detail")
    public String detail(HttpServletRequest request, int id) {
        carsSupply = carsSupplyService.getById(id);
        request.setAttribute("carsSupply", carsSupply);
        return "/user/detail/carsSupplyDetail";
    }

    /**
     * 跳转至修改信息状态
     *
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("toChangeCheck")
    public String toChangeCheck(HttpServletRequest request, int id) {
        carsSupply = carsSupplyService.getById(id);
        request.setAttribute("carsSupply", carsSupply);
        return "/admin/changeCheck/carCheck";
    }

    /**
     * 修改信息状态保存
     *
     * @param id
     * @param carCheck
     * @return
     */
    @RequestMapping("changeCheck")
    public String changeCheck(int id, int carCheck) {
        carsSupplyService.changeCheck(id, carCheck);

        return "forward:/carsSupply/adminList";
    }

    /**
     * 查询本用户发布的车源信息
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("personal")
    public String personal(HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<CarsSupply> carsSupplyList = carsSupplyService.getPersonal(user.getId());

        request.setAttribute("carsSupplyList", carsSupplyList);
        return "/user/manage/carsSupplyManage";
    }

    /**
     * 修改按钮，传递了用户的id，数据库查询到内容显示在页面
     */
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, int id) {
        CarsSupply carsSupply = carsSupplyService.getById(id);
        request.setAttribute("carsSupply", carsSupply);
        return "/user/editInfo/editCarsSupply";
    }

    /**
     * 修改站内信息保存
     *
     * @param source
     * @return
     */
    @RequestMapping("editCarsSupply")
    public String editCarSupply(HttpServletRequest request, CarsSupply source) {

        CarsSupply carsSupply = carsSupplyService.getById(source.getId());
        carsSupply.setCarStart(source.getCarStart());
        carsSupply.setCarEnd(source.getCarEnd());
        carsSupply.setCarType(source.getCarType());
        carsSupply.setCarCapacity(source.getCarCapacity());
        carsSupply.setCarStatus(source.getCarStatus());
        carsSupply.setCarPrice(source.getCarPrice());
        carsSupply.setCarTime(source.getCarTime());

        carsSupplyService.update(carsSupply);

        return "forward:/carsSupply/personal";
    }

    /**
     * 删除站内公告
     *
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    public String delete(@RequestParam("id") Integer[] ids) {

        carsSupplyService.deleteByIds(ids);
        return "forward:/carsSupply/personal";
    }
}
