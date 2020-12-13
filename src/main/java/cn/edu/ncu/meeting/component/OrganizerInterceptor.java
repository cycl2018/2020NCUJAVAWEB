package cn.edu.ncu.meeting.component;

import cn.edu.ncu.meeting.entity.Attendee;
import cn.edu.ncu.meeting.entity.Organizer;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 会议组织者的拦截器
 */
public class OrganizerInterceptor implements HandlerInterceptor {
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Organizer organizer = (Organizer) request.getSession().getAttribute("organizer");
//        System.out.println("organizer"+request.getRequestURL());
        if(organizer == null){
            //未登录，滚回登录页
            response.sendRedirect("/organizerlogin");
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
