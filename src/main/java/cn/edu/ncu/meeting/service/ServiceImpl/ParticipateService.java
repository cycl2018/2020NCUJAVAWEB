package cn.edu.ncu.meeting.service.ServiceImpl;

import cn.edu.ncu.meeting.dao.IParticipateDao;
import cn.edu.ncu.meeting.entity.Attendee;
import cn.edu.ncu.meeting.entity.Conference;
import cn.edu.ncu.meeting.service.Iservice.IPartcipateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipateService implements IPartcipateService {
    @Autowired
    IParticipateDao participateDao;


    //添加一条参会记录
    @Override
    public void addParticipate(String need, String departtime, String returntime, Attendee a, Conference c) {
        Integer attendeeId = a.getId();
        Integer conferenceId = c.getId();
        Integer hotelId = c.getHotelid();
        //添加记录
        participateDao.addParticipate(need,departtime,returntime,attendeeId,conferenceId,hotelId);
    }
}
