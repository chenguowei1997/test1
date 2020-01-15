package cn.itcast.interceptor;

import cn.itcast.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrivilegeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //逻辑判断用户是否登录,本质就是判断session中是否有user
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user==null){
            //用户没有登录
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return false;
        }

        return true;
    }
}
