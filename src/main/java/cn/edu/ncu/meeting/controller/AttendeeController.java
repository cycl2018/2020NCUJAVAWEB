package cn.edu.ncu.meeting.controller;


import cn.edu.ncu.meeting.entity.Attendee;
import cn.edu.ncu.meeting.entity.Conference;
import cn.edu.ncu.meeting.service.ServiceImpl.AttendeeService;
import cn.edu.ncu.meeting.service.ServiceImpl.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.Map;


//这时参会者的控制器
@Controller
public class AttendeeController {
    @Autowired
    AttendeeService attendeeService;


    //这里为空或者是login都能进入该方法
    @RequestMapping({"", "login"})
    public String login() {
        return "attendee_login.html";
    }
    //这里为空或者是login都能进入该方法
    @RequestMapping("loginfail")
    public String loginfail() {
        return "login_fail.html";
    }
    //主界面的映射
    @RequestMapping( value = "/index")
    public String index() {
        return "index.html";
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
            return "index.html";
        }else{
            //登陆失败
            //存放错误消息
            map.put("message","请输入用户名密码");
            return "attendee_login.html";
        }
    }

    //注销接口
    @GetMapping(value = "/logout")
    public String login(HttpSession session){
        session.invalidate();
        return "attendee_login.html";
    }

    //这里为空或者是login都能进入该方法
    @RequestMapping( value = "/chart")
    public String chart() {
        return "chart.html";
    }

    //这里为空或者是login都能进入该方法
    @RequestMapping( value = "/message")
    public String message() {
        return "message.html";
    }



}







