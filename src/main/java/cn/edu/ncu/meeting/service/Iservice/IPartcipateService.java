package cn.edu.ncu.meeting.service.Iservice;

import cn.edu.ncu.meeting.entity.Attendee;
import cn.edu.ncu.meeting.entity.Conference;

public interface IPartcipateService {
    void addParticipate(String need, String departtime, String returntime, Attendee a, Conference c);
}
