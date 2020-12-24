package cn.edu.ncu.meeting.controller;


import cn.edu.ncu.meeting.entity.*;
import cn.edu.ncu.meeting.service.HotelService;
import cn.edu.ncu.meeting.service.Iservice.IManagerService;
import cn.edu.ncu.meeting.service.ServiceImpl.AttendeeService;
import cn.edu.ncu.meeting.service.ServiceImpl.ConferenceService;
import cn.edu.ncu.meeting.service.ServiceImpl.ManagerService;
import cn.edu.ncu.meeting.service.ServiceImpl.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class ManagerController {
    @Autowired
    ManagerService managerService;
    @Autowired
    ConferenceService conferenceService;
    @Autowired
    OrganizerService organizerService;
    @Autowired
    AttendeeService attendeeService;
    @Resource(name = "hotelServiceImpl")
    private HotelService hotelService;


    //这里为空或者是login都能进入该方法
    @RequestMapping( value = "/manager_login")
    public String login() {
        return "manager/manager_login.html";
    }


    //管理员登录提交
    @PostMapping(value = "/dologin")
    public String login_ma(@RequestParam("username") String username,
                           @RequestParam("password") String password,
                           Model model, HttpSession session){
        Manager m = managerService.findbyu_p(username,password);
        if(m != null){
            //登录成功,为了防止表单重复提交，可以重定向到主页
            session.setAttribute("manager",m);
            //使用重定向可以将一个控制器调用另一个控制器
            return "manager/index_manager.html";
        }else{
            //登陆失败
            //存放错误消息
            model.addAttribute("message","用户名密码错误");
            return "manager/manager_login.html";
        }
    }

    //填写参与的详细信息
    @GetMapping(value = "/detail_delete")
    public String detail(@RequestParam("id") String id,
                         Model model,
                         HttpSession session){
        Conference c_detail = conferenceService.getConferenceById(id);
        //将会议信息存进session
        session.setAttribute("conference",c_detail);
        Attendee a = (Attendee) session.getAttribute("attendee");
        //将会议信息带到页面上
        model.addAttribute("c_detail",c_detail);
        model.addAttribute("attendee",a);
        return "/manager/conference_detail_delete.html";
    }

    //删除会议信息
    @PostMapping(value = "/deletesubmit")
    public String deletesubmit(@RequestParam("id") String id){
        conferenceService.deleteById(id);
        return "redirect:/tablemanager";
    }


    //图表总览
    @RequestMapping( value = "/chartmanager")
    public String chart() {
        return "manager/chart_manager.html";
    }

    //管理员主界面
    @RequestMapping( value = "/indexmanager")
    public String indexmanager() {
        return "manager/index_manager.html";
    }

    //消息总览
    @RequestMapping( value = "/messagemanager")
    public String message() {
        return "manager/message_manager.html";
    }


    //这里为空或者是login都能进入该方法
    @RequestMapping( value = "/tablemanager")
    public String getallConference(Model model) {
        //查询所有会议
        ArrayList<Conference> conferenceList = conferenceService.getallConference();
        //查询所有组织者，参与者，旅馆，司机
        ArrayList<Organizer> organizerList = organizerService.getallOrganizer();
        ArrayList<Attendee> attendeeList = attendeeService.getallAttendee();
        List<Hotel> hotelList = hotelService.findAllHotel();
        model.addAttribute("conferenceList",conferenceList);
        model.addAttribute("organizerList",organizerList);
        model.addAttribute("attendeeList",attendeeList);
        model.addAttribute("hotelList",hotelList);
        System.out.println(conferenceList);
        return "manager/table_manager.html";
    }
}
















