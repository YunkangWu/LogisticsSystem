package cdu.logistics.action;

import cdu.logistics.bean.Admin;
import cdu.logistics.bean.User;
import cdu.logistics.service.UserService;
import cdu.logistics.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @description 登录控制器
 */
@Controller
@RequestMapping("/login")
public class LoginAction {
    @Autowired
    private UserService userService;
    // 记住密码

    /**
     * @return 客户主页面
     */
    @RequestMapping("/user")
    public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {


        String userName = request.getParameter("user.userName");
        String password = request.getParameter("user.password");

        //判断前台传来的用户名是否存在
        User user = userService.loginByName(userName);
        //存在
        if (user != null) {
            //判断该账户是否有效
            if (user.getUserCheck() == 1) {
                user = userService.loginByNameAndPass(userName, password);
                //密码是否正确
                if (user != null) {
                    //将user通过session方式传输
                    session.setAttribute("user", user);
                    session.setMaxInactiveInterval(30*60);

                    //判断为企业用户，登录到main.jsp
                    if (user.getUserType() == 2) {
                        return "/user/main";
                    }
                    //判断为个人用户，登录到userMain.jsp
                    else {
                        return "/user/userMain";
                    }
                }
            }

        }
        //不匹配，返回登录界面
        return "redirect:/login.jsp";
    }

    /**
     * 管理员登陆
     *
     * @param request
     * @param session
     * @return 管理员主页面
     */
    @RequestMapping("/admin")
    public String adminLogin(HttpServletRequest request, HttpSession session) {

        String userName = request.getParameter("user.userName");
        String password = request.getParameter("user.password");

        Admin admin = userService.adminLogin(userName, password);
        if (admin != null) {
            session.setAttribute("admin", admin);
            return "/admin/main";
        }

        return "redirect:/admin/login.jsp";

    }

    /**
     * 登出
     *
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //转发方式，request.getRequestDispatcher
        //重定向方式 response.sendRedirect()",springMVC中 return "redirect:",其实是两次request,
        //request.getRequestDispatcher("login.jsp").forward(request,response);


        //return "login";
        return "redirect:/login.jsp";
    }


    /**
     * 生成验证码
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/code")
    public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Object[] objs = ImageUtil.createImage();
        request.getSession().setAttribute("imgCode", objs[0]);
        BufferedImage img = (BufferedImage) objs[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(img, "png", os);
        os.close();
    }

}
