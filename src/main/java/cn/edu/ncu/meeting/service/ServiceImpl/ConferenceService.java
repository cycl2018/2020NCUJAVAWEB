package cn.edu.ncu.meeting.service.ServiceImpl;

import cn.edu.ncu.meeting.dao.IConferenceDao;
import cn.edu.ncu.meeting.entity.Conference;
import cn.edu.ncu.meeting.service.Iservice.IConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConferenceService implements IConferenceService {
    @Autowired
    IConferenceDao conferenceDao;

    @Override
    public ArrayList<Conference> getallConference() {
        return conferenceDao.getallConference();
    }
}
