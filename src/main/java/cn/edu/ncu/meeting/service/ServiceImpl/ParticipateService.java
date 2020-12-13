package cn.edu.ncu.meeting.service.ServiceImpl;

import cn.edu.ncu.meeting.dao.IAttendeeDao;
import cn.edu.ncu.meeting.dao.IConferenceDao;
import cn.edu.ncu.meeting.dao.IParticipateDao;
import cn.edu.ncu.meeting.entity.Attendee;
import cn.edu.ncu.meeting.entity.Conference;
import cn.edu.ncu.meeting.entity.Participate;
import cn.edu.ncu.meeting.service.Iservice.IPartcipateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ParticipateService implements IPartcipateService {
    @Autowired
    IParticipateDao participateDao;
    @Autowired
    IAttendeeDao attendeeDao;
    @Autowired
    IConferenceDao conferenceDao;


    //添加一条参会记录
    @Override
    public void addParticipate(String need, String departtime, String returntime, Attendee a, Conference c) {
        Integer attendeeId = a.getId();
        Integer conferenceId = c.getId();
        Integer hotelId = c.getHotelid();
        //会议开始时间
        String datetime = c.getDatetime();
        //添加记录
        participateDao.addParticipate(need,departtime,returntime,attendeeId,conferenceId,hotelId,datetime);
    }

    //根据时间和id查询记录
    @Override
    public ArrayList<Participate> getByattendeeId_Date(Integer attendeeid, String date_format) {
        //先更具id来查询所有的记录
        ArrayList<Participate> p_list_first = participateDao.getByattendeeId(attendeeid);
        ArrayList<Participate> p_list = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //过滤掉过期了的会议
        for(Participate p : p_list_first){
            //先将类型转化
            String date_ = p.getDatetime();
            try {
                Date date_parse = simpleDateFormat.parse(date_);
                Date now = new Date();
                if(now.getTime() < date_parse.getTime()){
                    p.setAttendee(attendeeDao.findbyId(p.getAttendeeId()));
                    p.setConference(conferenceDao.getConferenceById(Integer.toString(p.getConferenceId())));
                    p_list.add(p);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.println(p_list_first);
        return p_list;
    }
}







