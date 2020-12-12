package cn.edu.ncu.meeting.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//日程总览控制器
@Controller
public class AgendaController {

    @RequestMapping( value = "/agenda")
    public String login() {
        return "agenda";
    }


}







