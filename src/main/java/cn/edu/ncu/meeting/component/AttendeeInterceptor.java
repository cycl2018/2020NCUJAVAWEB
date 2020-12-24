package cn.edu.ncu.meeting.component;

import cn.edu.ncu.meeting.entity.Attendee;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 会议参与者的拦截器
 */
public class AttendeeInterceptor implements HandlerInterceptor {
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Attendee attendee = (Attendee) request.getSession().getAttribute("attendee");
//        System.out.println("attendee"+request.getRequestURL());
        if(attendee == null){
            //未登录，滚回登录页
            response.sendRedirect("/loginfail");
            return false;
        }else{
            //已登录，放行请求
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
