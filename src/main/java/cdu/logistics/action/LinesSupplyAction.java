package cdu.logistics.action;

import cdu.logistics.bean.LinesSupply;
import cdu.logistics.bean.User;
import cdu.logistics.service.LinesSupplyService;
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
 * @description 专线信息控制器
 */
@Controller
@RequestMapping("/linesSupply")
public class LinesSupplyAction {

    private LinesSupply linesSupply;

    @Autowired
    private LinesSupplyService linesSupplyService;

    /**
     * 查询显示专线信息
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
        String hql = "from LinesSupply where lineCheck=1";
        String lineStart = request.getParameter("lineStart");
        String lineEnd = request.getParameter("lineEnd");
        String companyName = request.getParameter("companyName");

        if (lineStart != null && !"".equals(lineStart)) {
            hql += " and lineStart like '%" + lineStart + "%'";
        }
        if (lineEnd != null && !"".equals(lineEnd)) {
            hql += " and lineEnd like '%" + lineEnd + "%'";
        }
        if (companyName != null && !"".equals(companyName)) {
            hql += " and lineBelong.companyName like '%" + companyName + "%'";
        }

        pageModel.setPageSize(7);// 设置页面显示最大 值
        pageModel.setTotalCount(linesSupplyService.findAllByPage(hql).size()); // 数据总条数
        pageModel.setNum(2); // 设置当前页的前后距离,/**前后各显示5页**/
        // 通过当前页和
        List<LinesSupply> linesSupplyList = linesSupplyService.findByPage(hql,
                pageModel.getPageSize(), pageModel.getPage());

        pageModel.setItems(linesSupplyList);
        //pageModel.setTotalCount(goodsSupplyList.size());
        request.setAttribute("count", linesSupplyList.size());// 放置在request中
        request.setAttribute("pageModel", pageModel);
        request.setAttribute("page", pageModel.getPage());
        request.setAttribute("linesSupplyList", linesSupplyList);
        request.setAttribute("lineStart", lineStart);
        request.setAttribute("lineEnd", lineEnd);
        request.setAttribute("companyName", companyName);

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
        return "/user/infoList/linesSupplyList";
    }

    /**
     * 管理员查询显示专线信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/adminList")
    public String adminList(HttpServletRequest request, LinesSupply linesSupply) {
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
        String hql = "from LinesSupply where (lineCheck=1 or lineCheck=0)";

        String lineStart = request.getParameter("lineStart");
        String lineEnd = request.getParameter("lineEnd");
        String companyName = request.getParameter("companyName");

        if (lineStart != null && !"".equals(lineStart)) {
            hql += " and lineStart like '%" + lineStart + "%'";
        }
        if (lineEnd != null && !"".equals(lineEnd)) {
            hql += " and lineEnd like '%" + lineEnd + "%'";
        }
        if (companyName != null && !"".equals(companyName)) {
            hql += " and lineBelong.companyName like '%" + companyName + "%'";
        }

        pageModel.setPageSize(7);// 设置页面显示最大 值
        pageModel.setTotalCount(linesSupplyService.findAllByPage(hql).size()); // 数据总条数
        pageModel.setNum(2); // 设置当前页的前后距离,/**前后各显示5页**/
        // 通过当前页和
        List<LinesSupply> linesSupplyList = linesSupplyService.findByPage(hql,
                pageModel.getPageSize(), pageModel.getPage());

        pageModel.setItems(linesSupplyList);
        //pageModel.setTotalCount(goodsSupplyList.size());
        request.setAttribute("count", linesSupplyList.size());// 放置在request中
        request.setAttribute("pageModel", pageModel);
        request.setAttribute("page", pageModel.getPage());
        request.setAttribute("linesSupplyList", linesSupplyList);
        request.setAttribute("lineStart", lineStart);
        request.setAttribute("lineEnd", lineEnd);
        request.setAttribute("companyName", companyName);

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
        return "/admin/infoList/linesSupplyList";
    }

    /**
     * 添加专线信息
     *
     * @param session
     * @param linesSupply
     * @return
     */
    @RequestMapping("add")
    public String addLinesSupply(HttpSession session, LinesSupply linesSupply) {
        //发布时间
        linesSupply.setCreateTime(new Date());
        linesSupply.setLineCheck(1);
        //发布用户
        linesSupply.setLineBelong((User) session.getAttribute("user"));
        linesSupplyService.save(linesSupply);
        return "redirect:/user/addInfo/addLineSupply.jsp";
    }

    /**
     * 查看专线信息详情
     *
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("detail")
    public String detail(HttpServletRequest request, int id) {
        linesSupply = linesSupplyService.getById(id);
        request.setAttribute("linesSupply", linesSupply);
        return "/user/detail/linesSupplyDetail";
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
        linesSupply = linesSupplyService.getById(id);
        request.setAttribute("linesSupply", linesSupply);
        return "/admin/changeCheck/lineCheck";
    }

    /**
     * 修改信息状态保存
     *
     * @param id
     * @param lineCheck
     * @return
     */
    @RequestMapping("changeCheck")
    public String changeCheck(int id, int lineCheck) {
        linesSupplyService.changeCheck(id, lineCheck);

        return "forward:/linesSupply/adminList";
    }

    /**
     * 判断是否有权限发布该信息
     *
     * @return
     */
    @RequestMapping("addInfo")
    public String addInfo(HttpSession session, HttpServletResponse response, User user) throws IOException {
        user = (User) session.getAttribute("user");
        if (user.getCompanyType() == 2) {
            return "redirect:/user/addInfo/addLineSupply.jsp";
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('您没有该权限，网页将自动跳转到已发布的专线信息');window.location='list';window.close();</script>");
            //response.getWriter().write("<script>alert('网页将跳转到test.do'); window.location='test.do' ;window.close();</script>");
            response.getWriter().flush();
            return null;
        }
    }

    /**
     * 查询本用户发布的专线信息
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("personal")
    public String personal(HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("user");
        System.out.println(user.getId());
        List<LinesSupply> linesSupplyList = linesSupplyService.getPersonal(user.getId());

        request.setAttribute("linesSupplyList", linesSupplyList);
        return "/user/manage/linesSupplyManage";
    }

    @RequestMapping("edit")
    public String edit(HttpServletRequest request, int id) {
        LinesSupply linesSupply = linesSupplyService.getById(id);
        request.setAttribute("linesSupply", linesSupply);
        return "/user/editInfo/editLinesSupply";
    }


    /**
     * 修改站内信息保存
     *
     * @param source
     * @return
     */
    @RequestMapping("editLinesSupply")
    public String editLineSupply(HttpServletRequest request, LinesSupply source) {

        LinesSupply linesSupply = linesSupplyService.getById(source.getId());
        linesSupply.setLineStart(source.getLineStart());
        linesSupply.setLineEnd(source.getLineEnd());
        linesSupply.setLineFrequency(source.getLineFrequency());
        linesSupply.setLineTransportTime(source.getLineTransportTime());
        linesSupply.setLinePrice(source.getLinePrice());
        linesSupplyService.update(linesSupply);
        return "forward:/linesSupply/personal";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam("id") Integer[] ids) {
        linesSupplyService.deleteByIds(ids);
        return "forward:/linesSupply/personal";
    }

}
