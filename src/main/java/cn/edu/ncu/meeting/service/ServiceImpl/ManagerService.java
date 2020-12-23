package cn.edu.ncu.meeting.service.ServiceImpl;

import cn.edu.ncu.meeting.dao.IAttendeeDao;
import cn.edu.ncu.meeting.dao.IManagerDao;
import cn.edu.ncu.meeting.entity.Attendee;
import cn.edu.ncu.meeting.entity.Manager;
import cn.edu.ncu.meeting.service.Iservice.IAttendeeService;
import cn.edu.ncu.meeting.service.Iservice.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService implements IManagerService {
    @Autowired
    IManagerDao managerDao;


    @Override
    public Manager findbyu_p(String username, String password) {
        return managerDao.findbyu_p(username,password);
    }
}
