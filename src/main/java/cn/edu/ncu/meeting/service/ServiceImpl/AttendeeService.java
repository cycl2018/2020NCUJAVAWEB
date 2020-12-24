package cn.edu.ncu.meeting.service.ServiceImpl;

import cn.edu.ncu.meeting.dao.IAttendeeDao;
import cn.edu.ncu.meeting.entity.Attendee;
import cn.edu.ncu.meeting.service.Iservice.IAttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AttendeeService implements IAttendeeService {
    @Autowired
    IAttendeeDao attendeeDao;


    @Override
    public Attendee findbyu_p(String username, String password) {
        return attendeeDao.findbyu_p(username,password);
    }

    //注册
    @Override
    public void register(String username, String password) {
        attendeeDao.register(username,password);
    }

    //查询所有参会者
    @Override
    public ArrayList<Attendee> getallAttendee() {
        return attendeeDao.getallAttendee();
    }
}
