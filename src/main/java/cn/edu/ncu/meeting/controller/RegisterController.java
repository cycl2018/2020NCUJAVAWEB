package cn.edu.ncu.meeting.controller;


import cn.edu.ncu.meeting.entity.Organizer;
import cn.edu.ncu.meeting.service.ServiceImpl.AttendeeService;
import cn.edu.ncu.meeting.service.ServiceImpl.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//图表总览控制器
@Controller
public class RegisterController {
    @Autowired
    AttendeeService attendeeService;
    @Autowired
    OrganizerService organizerService;

    //这里为空或者是login都能进入该方法
    @RequestMapping( value = "/register")
    public String register() {
        return "register";
    }

    @PostMapping("/registersubmit")
    public String registersubmit(@RequestParam("username")String username,
                                 @RequestParam("password")String password,
                                 @RequestParam("type")String type){
        if(type.equals("attendee")){
            //参会者注册
            attendeeService.register(username,password);
            return "redirect:/";
        }else if (type.equals("organizer")){
            //组织者注册
            organizerService.register(username,password);
            return "redirect:/organizerlogin";
        }else{
            return "redirect:/register";
        }
    }

}







