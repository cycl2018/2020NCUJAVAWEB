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

    //增加一条会议
    @Override
    public void addConference(String name, String organizername, String datetime, Integer renshu, Integer hotelid, String about, Integer organizerid) {
        conferenceDao.addConference(name,organizername,datetime, renshu,hotelid,about,organizerid);
    }

    @Override
    public Conference getConferenceById(String id) {
        return conferenceDao.getConferenceById(id);
    }

    //删除一条会议
    @Override
    public void deleteById(String id) {
        conferenceDao.deleteById(id);
    }
}
