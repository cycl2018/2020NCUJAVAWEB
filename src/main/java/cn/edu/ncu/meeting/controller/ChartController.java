package cn.edu.ncu.meeting.controller;


import cn.edu.ncu.meeting.entity.Attendee;
import cn.edu.ncu.meeting.service.ServiceImpl.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;


//图表总览控制器
@Controller
public class ChartController {

    //这里为空或者是login都能进入该方法
    @RequestMapping( value = "/chart")
    public String login() {
        return "chart";
    }


}







