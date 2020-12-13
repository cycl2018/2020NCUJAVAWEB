package cn.edu.ncu.meeting.service.ServiceImpl;

import cn.edu.ncu.meeting.dao.IAttendeeDao;
import cn.edu.ncu.meeting.entity.Attendee;
import cn.edu.ncu.meeting.service.Iservice.IAttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
