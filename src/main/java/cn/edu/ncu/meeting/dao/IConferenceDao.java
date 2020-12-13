package cn.edu.ncu.meeting.dao;

import cn.edu.ncu.meeting.entity.Attendee;
import cn.edu.ncu.meeting.entity.Conference;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository
public interface IConferenceDao {

    //初始化的时候，添加一场比赛
    ArrayList<Conference> getallConference();

    void addConference(String name, String organizername, String datetime, Integer renshu, Integer hotelid, String about, Integer organizerid);

    //根据id查询会议
    Conference getConferenceById(String id);
}
















