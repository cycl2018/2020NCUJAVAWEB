package cn.edu.ncu.meeting.service.Iservice;

import cn.edu.ncu.meeting.entity.Attendee;

public interface IAttendeeService {
    Attendee findbyu_p(String username, String password);
}
