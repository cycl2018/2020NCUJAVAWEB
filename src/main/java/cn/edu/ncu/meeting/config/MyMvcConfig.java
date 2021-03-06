package cn.edu.ncu.meeting.config;

import cn.edu.ncu.meeting.component.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    //配置静态资源解析器
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }


    //视图解析器，默认来到首页
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {

            //登录拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源已经做好了映射，不需要再设置
                registry.addInterceptor(new AttendeeInterceptor()).addPathPatterns("/agenda","/index","/chart","/detail","/message","/table","/hotel/seed","/driver/seed");
                registry.addInterceptor(new OrganizerInterceptor()).addPathPatterns("/index_organizer","/form","/addconference");
                registry.addInterceptor(new DriverInterceptor()).addPathPatterns("/driver/**").excludePathPatterns("/driver/login","/driver/register","/driver/goLogin","/driver/seed","/driver/sendDriverOrder");
                registry.addInterceptor(new HotelInterceptor()).addPathPatterns("/hotel/**").excludePathPatterns("/hotel/index","/hotel/register","/hotel/seed","/hotel/login","/hotel/hotelRecommend","/hotel/seedHotelOrder");
                registry.addInterceptor(new ManagerInterceptor()).addPathPatterns("/detail_delete","/deletesubmit","/chartmanager","/indexmanager","/messagemanager","/tablemanager");
            }
        };
        return adapter;
    }

}








