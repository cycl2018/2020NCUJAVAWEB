package cn.edu.ncu.meeting.service.ServiceImpl;

import cn.edu.ncu.meeting.dao.IOrganizerDao;
import cn.edu.ncu.meeting.entity.Organizer;
import cn.edu.ncu.meeting.service.Iservice.IOrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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

    //查询所有组织者
    @Override
    public ArrayList<Organizer> getallOrganizer() {
        return organizerDao.getallOrganizer();
    }
}
