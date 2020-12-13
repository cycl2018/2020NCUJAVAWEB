package cn.edu.ncu.meeting.controller;


import cn.edu.ncu.meeting.entity.Attendee;
import cn.edu.ncu.meeting.entity.Organizer;
import cn.edu.ncu.meeting.service.ServiceImpl.AttendeeService;
import cn.edu.ncu.meeting.service.ServiceImpl.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;


//这时参会者的控制器
@Controller
public class OrganizerController {
    @Autowired
    OrganizerService organizerService;

    //这里为空或者是login都能进入该方法
    @RequestMapping("/organizerlogin")
    public String login() {
        return "organizer_login";
    }

    //登录方法
    @PostMapping("/organizersubmit")
    public String submit(@RequestParam("username") String name,
                         @RequestParam("password")String password,
                         HttpSession session) {
        Organizer o = organizerService.findOrganizerByu_p(name,password);
        if (o != null){
            session.setAttribute("organizer",o);
            return "index";
        }else{
            return "organizer_login";
        }
    }







}







