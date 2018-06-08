package cdu.logistics.action;

import cdu.logistics.bean.User;
import cdu.logistics.service.UserService;
import cdu.logistics.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @description 用户信息控制器
 */
@Controller
@RequestMapping("/user")
public class UserAction {

    @Autowired
    private UserService userService;

    //声明在方法外，避免重复
    private User user;

    /**
     * 查询显示所有用户
     *
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String list(HttpServletRequest request,User user) {
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
        String hql = "from User";

        pageModel.setPageSize(10);// 设置页面显示最大 值
        pageModel.setTotalCount(userService.findAllByPage(hql).size()); // 数据总条数
        pageModel.setNum(2); // 设置当前页的前后距离,/**前后各显示5页**/
        // 通过当前页和
        List<User> userList = userService.findByPage(hql,
                pageModel.getPageSize(), pageModel.getPage());

        pageModel.setItems(userList);
        //pageModel.setTotalCount(goodsSupplyList.size());
        request.setAttribute("count", userList.size());// 放置在request中
        request.setAttribute("pageModel", pageModel);
        request.setAttribute("page", pageModel.getPage());
        request.setAttribute("userList", userList);

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
        return "/admin/userList";

    }

    @RequestMapping("/register")
    public String register(User user) {

        //用户默认有效
        user.setUserCheck(1);
        userService.save(user);

        return "redirect:/login.jsp";
    }

    /**
     * AJAX进行异步校验用户名的执行方法
     *
     * @throws IOException
     */
    @RequestMapping("checkUsername")
    public void checkUsername(HttpServletRequest request, HttpServletResponse response, String username) throws IOException {
        // 调用Service进行查询:
        User existUser = userService.checkUsername(username);
        response.setContentType("text/html;charset=UTF-8");
        // 判断
        if (existUser != null) {
            // 查询到该用户:用户名已经存在
            response.getWriter().println("<font color='red'>用户名已经存在</font>");
        } else {
            // 没查询到该用户:用户名可以使用
            response.getWriter().println("<font color='green'>用户名可以使用</font>");
        }
    }

    /**
     * AJAX进行异步请求获得用户设置的问题
     *
     * @throws IOException
     */
    @RequestMapping("getUserQuestion")
    public void getUserQuestion(HttpServletRequest request, HttpServletResponse response, String username) throws IOException {
        // 调用Service进行查询:
        User existUser = userService.checkUsername(username);
        response.setContentType("text/html;charset=UTF-8");
        // 判断用户是否存在
        if (existUser != null) {
            // 查询到该用户:用户名已经存在
            String userQuestion = existUser.getUserQuestion();
            if (userQuestion != null) {
                response.getWriter().println(userQuestion);
            } else {
                response.getWriter().println("该用户未设置问题，请联系管理员");
            }
        } else {
            // 没查询到该用户:用户名可以使用
            response.getWriter().println("该用户未被注册");
        }
    }

    @RequestMapping("getbackPass")
    public String getbackPass(HttpServletRequest request, String userName, String userKey) throws IOException {
        User existUser = userService.checkUsername(userName);
        request.setAttribute("user", existUser);
        return "/user/getbackPassSuccess";
    }


    /**
     * 管理员添加新用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/add")
    public String addUser(User user) {

        //管理员添加，审核状态为1
        user.setUserCheck(1);
        userService.save(user);

        //forward到这个另一个controller方法
        return "forward:/user/list";
    }

    /**
     * 修改按钮，传递了用户的id，数据库查询到内容显示在页面
     */
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, int id) {
        user = userService.getById(id);
        request.setAttribute("user", user);
        return "/admin/editUser";
    }

    /**
     * 修改用户信息保存
     *
     * @param source
     * @return
     */
    @RequestMapping("editUser")
    public String editUser(HttpServletRequest request, User source) {

        User user = userService.getById(source.getId());
        user.setUserType(source.getUserType());
        user.setUserCheck(source.getUserCheck());
        user.setPassword(source.getPassword());
        user.setLocation(source.getLocation());
        user.setTellphone(source.getTellphone());
        user.setEmail(source.getEmail());
        user.setCompanyName(source.getCompanyName());
        user.setCompanyBelong(source.getCompanyBelong());
        user.setCompanyType(source.getCompanyType());
        user.setCompanyIndustry(source.getCompanyIndustry());


        userService.update(user);

        return "forward:/user/list";
    }

    /**
     * 删除用户信息
     *
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    public String delete(@RequestParam("id") Integer[] ids) {

        userService.deleteByIds(ids);
        return "forward:/user/list";
    }

    /**
     * 管理用户信息，判断进入哪个信息管理
     *
     * @return
     */
    @RequestMapping("manage")
    public String manage(HttpSession session) {
        User user = (User) session.getAttribute("user");
        //个人用户，进入发布车源管理
        if (user.getUserType() == 1) {
            return "redirect:/carsSupply/personal";
        } else {
            if (user.getCompanyType() == 1) {
                //企业用户，进入发布货源管理
                return "redirect:/goodsSupply/personal";
            } else if (user.getCompanyType() == 2) {
                //发布专线管理
                return "redirect:/linesSupply/personal";
            } else if (user.getCompanyType() == 3) {
                //发布仓储管理
                return "redirect:/storagesSupply/personal";
            } else {
                //发布招聘管理
                return "redirect:/jobsSupply/personal";
            }
        }
    }

    /**
     * 点击个人中心后，先判断是否设置了问题
     *
     * @param session
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("prCenter")
    public String prCenter(HttpSession session, HttpServletResponse response) throws IOException {
        User user = (User) session.getAttribute("user");
        //没有设置问题，先进行设置问题
        if (user.getUserQuestion() == null || "".equals(user.getUserQuestion())) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<script>alert('请先设置用于找回密码的问题');window.location='setQuestion';window.close();</script>");
            response.getWriter().flush();
            return null;
        } else {
            return "redirect:/user/editInfomation";
        }
    }

    /**
     * 设置问题
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("setQuestion")
    public String setQuestion(HttpSession session,HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        request.setAttribute("user", user);
        return "/user/setQuestion";
    }

    /**
     * 问题设置成功
     * @return
     */
    @RequestMapping("setQuestionSuccess")
    public String setQuestionSuccess(User source) {
        User user = userService.getById(source.getId());
        user.setUserQuestion(source.getUserQuestion());
        user.setUserKey(source.getUserKey());
        userService.update(user);
        return "redirect:/user/editInfomation";
    }

    /**
     * 用户基本信息修改
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("editInfomation")
    public String editInfomation(HttpSession session,HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        request.setAttribute("user",user);
        if (user.getUserType() == 1) {
            //个人用户修改
            return "/user/userInfomation";
        } else {
            //企业用户修改
            return "/user/companyInfomation";
        }
    }

    /**
     * 用户基本信息修改成功
     * @param source
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("editSuccess")
    public String editSuccess(User source,HttpServletRequest request,HttpServletResponse response) throws IOException {
        User user = userService.getById(source.getId());
        user.setPassword(source.getPassword());
        user.setLocation(source.getLocation());
        user.setTellphone(source.getTellphone());
        user.setEmail(source.getEmail());
        user.setCompanyName(source.getCompanyName());
        user.setCompanyBelong(source.getCompanyBelong());
        user.setCompanyType(source.getCompanyType());
        user.setCompanyIndustry(source.getCompanyIndustry());

        userService.update(user);
        request.setAttribute("user", user);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<script>alert('用户信息修改成功！请重新登录');window.close();</script>");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<script>");
        out.println("window.open ('exit','_top')");
        out.println("</script>");
        out.println("</html>");

        response.getWriter().flush();
        return null;
    }

    @RequestMapping("exit")
    public String exit() {
        return "redirect:/login.jsp";
    }
}
