package cn.edu.ncu.meeting.controller;


import cn.edu.ncu.meeting.entity.Conference;
import cn.edu.ncu.meeting.service.ServiceImpl.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;


//全部会议控制器
@Controller
public class TableController {
    @Autowired
    ConferenceService conferenceService;


    //这里为空或者是login都能进入该方法
    @RequestMapping( value = "/table")
    public String getallConference(Model model) {
        ArrayList<Conference> conferenceList = conferenceService.getallConference();
        model.addAttribute("conferenceList",conferenceList);
        System.out.println(conferenceList);
        return "table";
    }


}







