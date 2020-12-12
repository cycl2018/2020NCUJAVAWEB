package cn.edu.ncu.meeting.controller;


import cn.edu.ncu.meeting.entity.Attendee;
import cn.edu.ncu.meeting.service.ServiceImpl.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//这时参会者的控制器
@Controller
public class AttendeeController {
    @Autowired
    AttendeeService attendeeService;

    //这里为空或者是login都能进入该方法
    @RequestMapping({"", "login"})
    public String login() {
        return "attendee_login";
    }
    //主界面的映射
    @RequestMapping( value = "/index")
    public String index() {
        return "index";
    }



    //与会者登录
    @PostMapping(value = "/attendee_login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        //查找
        Attendee a = attendeeService.findbyu_p(username,password);
        if(a != null){
            //登录成功,为了防止表单重复提交，可以重定向到主页
            session.setAttribute("attendee",a);
            //使用重定向可以将一个控制器调用另一个控制器
            return "index";
        }else{
            //登陆失败
            //存放错误消息
            map.put("message","请输入用户名密码");
            return "attendee_login";
        }
    }


}







