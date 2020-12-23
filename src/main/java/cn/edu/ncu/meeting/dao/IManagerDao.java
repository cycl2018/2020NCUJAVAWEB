package cn.edu.ncu.meeting.dao;

import cn.edu.ncu.meeting.entity.Attendee;
import cn.edu.ncu.meeting.entity.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IManagerDao {

    //初始化的时候，添加一场比赛
    Manager findbyu_p(@Param("username") String username, @Param("password") String password);

}
















