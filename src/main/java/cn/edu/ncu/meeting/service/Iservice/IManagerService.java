package cn.edu.ncu.meeting.service.Iservice;

import cn.edu.ncu.meeting.entity.Manager;

public interface IManagerService {
    Manager findbyu_p(String username, String password);
}
