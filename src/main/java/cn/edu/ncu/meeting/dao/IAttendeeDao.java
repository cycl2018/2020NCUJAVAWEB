package cn.edu.ncu.meeting.dao;

import cn.edu.ncu.meeting.entity.Attendee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository
public interface IAttendeeDao {

    //初始化的时候，添加一场比赛
    Attendee findbyu_p(@Param("username") String username, @Param("password") String password);

    void register(String username, String password);

    //根据ID查询用户
    Attendee findbyId(Integer attendeeId);
}
















