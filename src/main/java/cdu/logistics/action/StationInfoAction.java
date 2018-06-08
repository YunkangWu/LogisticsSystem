package cdu.logistics.action;

import cdu.logistics.bean.StationInfo;
import cdu.logistics.service.StationInfoService;
import cdu.logistics.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * @description 站内公告控制器
 */
@Controller
@RequestMapping("/stationInfo")
public class StationInfoAction {

    @Autowired
    private StationInfoService stationInfoService;

    /**
     * 查询显示所有站内公告
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String list(HttpServletRequest request, StationInfo stationInfo) {
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
        String hql = "from StationInfo";

        pageModel.setPageSize(7);// 设置页面显示最大 值
        pageModel.setTotalCount(stationInfoService.getAllStationInfos().size()); // 数据总条数
        pageModel.setNum(2); // 设置当前页的前后距离,/**前后各显示5页**/
        // 通过当前页和
        List<StationInfo> stationInfoList = stationInfoService.getAllStationInfos();

        pageModel.setItems(stationInfoList);
        //pageModel.setTotalCount(goodsSupplyList.size());
        request.setAttribute("count", stationInfoList.size());// 放置在request中
        request.setAttribute("pageModel", pageModel);
        request.setAttribute("page", pageModel.getPage());
        request.setAttribute("stationInfoList", stationInfoList);

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
        return "/admin/stationInfoList";
    }

    /**
     * 用户查询显示所有站内公告
     * @param request
     * @return
     */
    @RequestMapping("/userList")
    public String userList(HttpServletRequest request) {
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
        String hql = "from StationInfo";

        pageModel.setPageSize(12);// 设置页面显示最大 值
        pageModel.setTotalCount(stationInfoService.getAllStationInfos().size()); // 数据总条数
        pageModel.setNum(2); // 设置当前页的前后距离,/**前后各显示5页**/
        // 通过当前页和
        List<StationInfo> stationInfoList = stationInfoService.getAllStationInfos();

        pageModel.setItems(stationInfoList);
        //pageModel.setTotalCount(goodsSupplyList.size());
        request.setAttribute("count", stationInfoList.size());// 放置在request中
        request.setAttribute("pageModel", pageModel);
        request.setAttribute("page", pageModel.getPage());
        request.setAttribute("stationInfoList", stationInfoList);

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
        return "/user/stationInfoList";
    }

    /**
     * 发布站内信息
     * @return
     */
    @RequestMapping("add")
    public String addStationInfo(StationInfo stationInfo) {
        stationInfo.setInfoTime(new Date());
        stationInfoService.save(stationInfo);
        return "redirect:/admin/addStationInfo.jsp";
    }


    /**
     * 修改按钮，传递了用户的id，数据库查询到内容显示在页面
     */
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, int id) {
        StationInfo stationInfo = stationInfoService.getById(id);
        request.setAttribute("stationInfo", stationInfo);
        return "/admin/editStationInfo";
    }

    /**
     * 显示详情
     */
    @RequestMapping("show")
    public String show(HttpServletRequest request, int id) {
        StationInfo stationInfo = stationInfoService.getById(id);
        request.setAttribute("stationInfo", stationInfo);
        return "/user/stationInfoDetail";
    }

    /**
     * 修改站内信息保存
     *
     * @param source
     * @return
     */
    @RequestMapping("editStationInfo")
    public String editStationInfo(HttpServletRequest request, StationInfo source) {
        StationInfo stationInfo = stationInfoService.getById(source.getId());
        stationInfo.setInfoTitle(source.getInfoTitle());
        stationInfo.setInfoFrom(source.getInfoFrom());
        stationInfo.setInfoContent(source.getInfoContent());
        stationInfoService.update(stationInfo);

        return "forward:/stationInfo/list";
    }

    /**
     * 删除站内公告
     *
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    public String delete(@RequestParam("id") Integer[] ids) {

        stationInfoService.deleteByIds(ids);
        return "forward:/stationInfo/list";
    }

}