package cn.edu.ncu.meeting.interceptor;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * @author cycl
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 拦截处理代码

        //静态资源不被拦截器拦截
        String uri = request.getRequestURI();
        if (uri.endsWith("js")||uri.endsWith("css")||uri.endsWith("jpg")||uri.endsWith("svg")||uri.endsWith("jpg")||uri.endsWith("png")){
            return true ;
        }
        HttpSession session = request.getSession();
        // 获取用户信息，如果没有用户信息直接返回提示信息
        Object userInfo = session.getAttribute("loginUser");
        if (userInfo == null) {
            request.setAttribute("msg","请先登录！");
            request.getRequestDispatcher("logging").forward(request, response);
            return false;
        }

        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}