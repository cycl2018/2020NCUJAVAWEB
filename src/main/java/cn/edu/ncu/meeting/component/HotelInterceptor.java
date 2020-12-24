package cn.edu.ncu.meeting.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author cycl
 */
public class HotelInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        HttpSession session = request.getSession();
        Object userInfo = session.getAttribute("hotelId");
        if(userInfo ==  null){
            response.sendRedirect("/hotel/index");
            return false;
        }
        return true;
    }
}
