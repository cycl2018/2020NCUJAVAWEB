package cn.edu.ncu.meeting.service.ServiceImpl;

import cn.edu.ncu.meeting.dao.IOrganizerDao;
import cn.edu.ncu.meeting.entity.Organizer;
import cn.edu.ncu.meeting.service.Iservice.IOrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizerService implements IOrganizerService {
    @Autowired
    IOrganizerDao organizerDao;


    @Override
    public Organizer findOrganizerByu_p(String name, String password) {
        return organizerDao.findOrganizerByu_p(name,password);
    }

    //注册模块
    @Override
    public void register(String username, String password) {
        organizerDao.register(username,password);
    }
}
