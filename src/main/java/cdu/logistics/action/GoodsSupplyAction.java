package cdu.logistics.action;

import cdu.logistics.bean.GoodsSupply;
import cdu.logistics.bean.User;
import cdu.logistics.service.GoodsSupplyService;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description 货源信息控制器
 */
@Controller
@RequestMapping("/goodsSupply")
public class GoodsSupplyAction {

    private GoodsSupply goodsSupply;

    @Autowired
    private GoodsSupplyService goodsSupplyService;

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
        String hql = "from GoodsSupply gs where goodCheck=1";
        String goodsName = request.getParameter("goodsName");
        String goodsQuantity = request.getParameter("goodsQuantity");
        String goodsStart = request.getParameter("goodsStart");
        String goodsEnd = request.getParameter("goodsEnd");

        String goodsTimeStart = request.getParameter("goodsTimeStart");
        String goodsTimeEnd = request.getParameter("goodsTimeEnd");
        if (goodsName != null && !"".equals(goodsName)) {
            hql += " and goodsName like '%" + goodsName + "%'";
        }
        if (goodsQuantity != null && !"".equals(goodsQuantity)) {
            hql += " and goodsQuantity like '%" + goodsQuantity + "%'";
        }
        if (goodsStart != null && !"".equals(goodsStart)) {
            hql += " and goodsStart like '%" + goodsStart + "%'";
        }
        if (goodsEnd != null && !"".equals(goodsEnd)) {
            hql += " and goodsEnd like '%" + goodsEnd + "%'";
        }
        if (goodsTimeStart != null && !"".equals(goodsTimeStart)) {
            //将年-月-日转化为年月日纯数字
            String regEx = "[^0-9]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(goodsTimeStart);
            String time = m.replaceAll("").trim();
            hql += " and goodsTime >= date_format(" + time + ",'%y-%m-%d')";
        }
        if (goodsTimeEnd != null && !"".equals(goodsTimeEnd)) {
            //将年-月-日转化为年月日纯数字
            String regEx = "[^0-9]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(goodsTimeEnd);
            String time = m.replaceAll("").trim();
            hql += " and goodsTime <= date_format(" + time + ",'%y-%m-%d')";
        }
        pageModel.setPageSize(7);// 设置页面显示最大 值
        pageModel.setTotalCount(goodsSupplyService.findAllByPage(hql).size()); // 数据总条数
        pageModel.setNum(2); // 设置当前页的前后距离
        // 通过当前页和
        List<GoodsSupply> goodsSupplyList = goodsSupplyService.findByPage(hql,
                pageModel.getPageSize(), pageModel.getPage());

        pageModel.setItems(goodsSupplyList);
        //pageModel.setTotalCount(goodsSupplyList.size());
        request.setAttribute("count", goodsSupplyList.size());
        request.setAttribute("pageModel", pageModel);
        request.setAttribute("page", pageModel.getPage());
        request.setAttribute("goodsSupplyList", goodsSupplyList);
        //将搜索条件显示在结果页面
        request.setAttribute("goodsName", goodsName);
        request.setAttribute("goodsQuantity", goodsQuantity);
        request.setAttribute("goodsStart", goodsStart);
        request.setAttribute("goodsEnd", goodsEnd);
        request.setAttribute("goodsTimeStart", goodsTimeStart);
        request.setAttribute("goodsTimeEnd", goodsTimeEnd);

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
        return "/user/infoList/goodsSupplyList";
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
        String hql = "from GoodsSupply where (goodCheck=1 or goodCheck=0)";
        String goodsName = request.getParameter("goodsName");
        String goodsQuantity = request.getParameter("goodsQuantity");
        String goodsStart = request.getParameter("goodsStart");
        String goodsEnd = request.getParameter("goodsEnd");

        String goodsTimeStart = request.getParameter("goodsTimeStart");
        String goodsTimeEnd = request.getParameter("goodsTimeEnd");
        if (goodsName != null && !"".equals(goodsName)) {
            hql += " and goodsName like '%" + goodsName + "%'";
        }
        if (goodsQuantity != null && !"".equals(goodsQuantity)) {
            hql += " and goodsQuantity like '%" + goodsQuantity + "%'";
        }
        if (goodsStart != null && !"".equals(goodsStart)) {
            hql += " and goodsStart like '%" + goodsStart + "%'";
        }
        if (goodsEnd != null && !"".equals(goodsEnd)) {
            hql += " and goodsEnd like '%" + goodsEnd + "%'";
        }
        if (goodsTimeStart != null && !"".equals(goodsTimeStart)) {
            //将年-月-日转化为年月日纯数字
            String regEx = "[^0-9]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(goodsTimeStart);
            String time = m.replaceAll("").trim();
            hql += " and goodsTime >= date_format(" + time + ",'%y-%m-%d')";
        }
        if (goodsTimeEnd != null && !"".equals(goodsTimeEnd)) {
            //将年-月-日转化为年月日纯数字
            String regEx = "[^0-9]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(goodsTimeEnd);
            String time = m.replaceAll("").trim();
            hql += " and goodsTime <= date_format(" + time + ",'%y-%m-%d')";
        }
        pageModel.setPageSize(7);// 设置页面显示最大 值
        pageModel.setTotalCount(goodsSupplyService.findAllByPage(hql).size()); // 数据总条数
        pageModel.setNum(2); // 设置当前页的前后距离
        // 通过当前页和
        List<GoodsSupply> goodsSupplyList = goodsSupplyService.findByPage(hql,
                pageModel.getPageSize(), pageModel.getPage());

        pageModel.setItems(goodsSupplyList);
        //pageModel.setTotalCount(goodsSupplyList.size());
        request.setAttribute("count", goodsSupplyList.size());
        request.setAttribute("pageModel", pageModel);
        request.setAttribute("page", pageModel.getPage());
        request.setAttribute("goodsSupplyList", goodsSupplyList);
        //将搜索条件显示在结果页面
        request.setAttribute("goodsName", goodsName);
        request.setAttribute("goodsQuantity", goodsQuantity);
        request.setAttribute("goodsStart", goodsStart);
        request.setAttribute("goodsEnd", goodsEnd);
        request.setAttribute("goodsTimeStart", goodsTimeStart);
        request.setAttribute("goodsTimeEnd", goodsTimeEnd);

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
        return "/admin/infoList/goodsSupplyList";
    }

    /**
     * 添加货源信息
     *
     * @param goodsSupply
     * @return
     */
    @RequestMapping("add")
    public String addGoodsSupply(HttpSession session, GoodsSupply goodsSupply) {
        //发布时间
        goodsSupply.setCreateTime(new Date());
        //发布用户
        goodsSupply.setGoodsBelong((User) session.getAttribute("user"));
        //状态默认为0.未成交
        goodsSupply.setGoodsStatus(0);
        goodsSupply.setGoodCheck(1);
        goodsSupplyService.save(goodsSupply);
        return "redirect:/user/addInfo/addGoodsSupply.jsp";
    }

    /**
     * 查看货源详情
     *
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("detail")
    public String detail(HttpServletRequest request, int id) {
        goodsSupply = goodsSupplyService.getById(id);
        request.setAttribute("goodsSupply", goodsSupply);
        return "/user/detail/goodsSupplyDetail";
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
        goodsSupply = goodsSupplyService.getById(id);
        request.setAttribute("goodsSupply", goodsSupply);
        return "/admin/changeCheck/goodsCheck";
    }

    /**
     * 修改信息状态保存
     *
     * @param id
     * @param goodCheck
     * @return
     */
    @RequestMapping("changeCheck")
    public String changeCheck(int id, int goodCheck) {
        goodsSupplyService.changeCheck(id, goodCheck);

        return "forward:/goodsSupply/adminList";
    }

    /**
     * 判断是否有权限发布该信息
     *
     * @return
     */
    @RequestMapping("addInfo")
    public String addInfo(HttpSession session, HttpServletResponse response, User user) throws IOException {
        user = (User) session.getAttribute("user");
        if (user.getCompanyType() == 1) {
            return "redirect:/user/addInfo/addGoodsSupply.jsp";
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('您没有该权限，网页将自动跳转到已发布的货源信息');window.location='list';window.close();</script>");
            response.getWriter().flush();
            return null;
        }
    }

    /**
     * 查询本用户发布的货源信息
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("personal")
    public String personal(HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<GoodsSupply> goodsSupplyList = goodsSupplyService.getPersonal(user.getId());

        request.setAttribute("goodsSupplyList", goodsSupplyList);
        return "/user/manage/goodsSupplyManage";
    }

    @RequestMapping("edit")
    public String edit(HttpServletRequest request, int id) {
        GoodsSupply goodsSupply = goodsSupplyService.getById(id);
        request.setAttribute("goodsSupply", goodsSupply);
        return "/user/editInfo/editGoodsSupply";
    }


    /**
     * 修改站内信息保存
     *
     * @param source
     * @return
     */
    @RequestMapping("editGoodsSupply")
    public String editGoodsSupply(HttpServletRequest request, GoodsSupply source) {

        GoodsSupply goodsSupply = goodsSupplyService.getById(source.getId());
        goodsSupply.setGoodsStart(source.getGoodsStart());
        goodsSupply.setGoodsEnd(source.getGoodsEnd());
        goodsSupply.setGoodsName(source.getGoodsName());
        goodsSupply.setGoodsQuantity(source.getGoodsQuantity());
        goodsSupply.setGoodsTime(source.getGoodsTime());
        goodsSupply.setGoodsPrice(source.getGoodsPrice());
        goodsSupply.setGoodsCarType(source.getGoodsCarType());
        goodsSupply.setGoodsStatus(source.getGoodsStatus());
        goodsSupplyService.update(goodsSupply);


        return "forward:/goodsSupply/personal";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam("id") Integer[] ids) {
        goodsSupplyService.deleteByIds(ids);
        return "forward:/goodsSupply/personal";
    }

}

