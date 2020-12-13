package cn.edu.ncu.meeting.dao;

import cn.edu.ncu.meeting.entity.Organizer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IParticipateDao {

    void addParticipate(String need, String departtime, String returntime, Integer attendeeId, Integer conferenceId, Integer hotelId);
}
















