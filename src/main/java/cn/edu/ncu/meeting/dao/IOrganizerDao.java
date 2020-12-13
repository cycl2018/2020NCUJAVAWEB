package cn.edu.ncu.meeting.dao;

import cn.edu.ncu.meeting.entity.Attendee;
import cn.edu.ncu.meeting.entity.Organizer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IOrganizerDao {

    //查询数据库，登录信息
    Organizer findOrganizerByu_p(@Param("name") String name, @Param("password") String password);

    void register(String username, String password);
}
















