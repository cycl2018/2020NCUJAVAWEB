package cn.edu.ncu.meeting.service.Iservice;

import cn.edu.ncu.meeting.entity.Attendee;
import cn.edu.ncu.meeting.entity.Conference;
import cn.edu.ncu.meeting.entity.Participate;

import java.util.ArrayList;

public interface IPartcipateService {
    void addParticipate(String need, String departtime, String returntime, Attendee a, Conference c);

    ArrayList<Participate> getByattendeeId_Date(Integer attendeeid, String date_format);
}
