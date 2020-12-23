package cn.edu.ncu.meeting.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//发起会议控制器
@Controller
public class FormController {

    //这里为空或者是login都能进入该方法
    @RequestMapping( value = "/form")
    public String login() {
        return "form.html";
    }


}







