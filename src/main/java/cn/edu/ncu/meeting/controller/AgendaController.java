package cn.edu.ncu.meeting.controller;


import cn.edu.ncu.meeting.entity.Attendee;
import cn.edu.ncu.meeting.entity.Participate;
import cn.edu.ncu.meeting.service.ServiceImpl.ParticipateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


//日程总览控制器
@Controller
public class AgendaController {
    @Autowired
    ParticipateService participateService;

    @RequestMapping( value = "/agenda")
    public String agenda(HttpSession session, Model model) {
        Attendee a = (Attendee) session.getAttribute("attendee");
        Integer attendeeid = a.getId();
        //获取当前时间
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String date_format = formatter.format(date);
        //根据时间和个人id查询某个人的会议记录
        ArrayList<Participate> p_list = participateService.getByattendeeId_Date(attendeeid,date_format);
        model.addAttribute("p_list",p_list);
        System.out.println(p_list);
        return "agenda";
    }


}







