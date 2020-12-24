package cn.edu.ncu.meeting.service.Iservice;

import cn.edu.ncu.meeting.entity.Attendee;

import java.util.ArrayList;

public interface IAttendeeService {
    Attendee findbyu_p(String username, String password);

    void register(String username, String password);

    ArrayList<Attendee> getallAttendee();
}
