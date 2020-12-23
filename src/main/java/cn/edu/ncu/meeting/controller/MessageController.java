package cn.edu.ncu.meeting.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//消息总览控制器
@Controller
public class MessageController {

    //这里为空或者是login都能进入该方法
    @RequestMapping( value = "/message")
    public String login() {
        return "message.html";
    }


}







