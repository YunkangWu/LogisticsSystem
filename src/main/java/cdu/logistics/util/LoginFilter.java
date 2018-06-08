package cdu.logistics.util;

import cdu.logistics.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @description 登录过滤器
 */
public class LoginFilter implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest hrequest = (HttpServletRequest)request;

        HttpServletResponse hresponse = (HttpServletResponse)response;

        HttpSession session = hrequest.getSession();

        User u = new User();
        System.out.println(u);

        u = (User) session.getAttribute("UserSession");
        if(u != null){
            chain.doFilter(request, response);
        }
        else{
            String msg = "<font color=red>请先登录!</font>";
            hrequest.setAttribute("Error_Msg", msg);
            hrequest.getRequestDispatcher("/login.jsp").forward(hrequest, hresponse);
        }
    }

    public void init(FilterConfig arg0) throws ServletException {

    }

}
