package cn.edu.ncu.meeting.controller;


import cn.edu.ncu.meeting.entity.Attendee;
import cn.edu.ncu.meeting.entity.Conference;
import cn.edu.ncu.meeting.entity.Organizer;
import cn.edu.ncu.meeting.service.ServiceImpl.ConferenceService;
import cn.edu.ncu.meeting.service.ServiceImpl.ParticipateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


//日程总览控制器
@Controller
public class ConferenceController {
    @Autowired
    ConferenceService conferenceService;
    @Autowired
    ParticipateService participateService;


    //注册一条会议
    @PostMapping( value = "/addconference")
    public String addconference(@RequestParam("name") String name,
                                @RequestParam("datetime") String datetime,
                                @RequestParam("about") String about,
                                @RequestParam("renshu") String renshu,
                                @RequestParam("hotelid") String hotelid,
                                @RequestParam("empty") String empty,
                                Model model, HttpSession session) {
        Organizer organizer = (Organizer)session.getAttribute("organizer");
        String organizername = organizer.getUsername();
        datetime = datetime.replace("T"," ");
        datetime = datetime+":00";
        Integer organizerid = organizer.getId();
        //增加一条会议
        conferenceService.addConference(name,organizername,datetime,Integer.valueOf(renshu),Integer.valueOf(hotelid),about,organizerid);
        return "form.html";
    }



    //填写参与的详细信息
    @GetMapping(value = "/detail")
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
        return "conference_detail.html";
    }



    //添加一条参会记录
    @PostMapping(value = "/participate")
    public String participate(@RequestParam("need") String need,
                              @RequestParam("departtime") String departtime,
                              @RequestParam("returntime") String returntime,
                              HttpSession session){
        //处理时间
        departtime = departtime.replace("T"," ");
        departtime = departtime + ":00";
        returntime = returntime.replace("T"," ");
        returntime = returntime + ":00";
        Attendee a = (Attendee) session.getAttribute("attendee");
        Conference c = (Conference) session.getAttribute("conference");

        //插入一条记录
        participateService.addParticipate(need,departtime,returntime,a,c);
        return "redirect:/agenda";
    }


}







