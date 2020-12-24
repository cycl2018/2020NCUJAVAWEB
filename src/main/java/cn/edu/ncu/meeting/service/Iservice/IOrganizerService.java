package cn.edu.ncu.meeting.service.Iservice;

import cn.edu.ncu.meeting.entity.Organizer;

import java.util.ArrayList;

public interface IOrganizerService {
    Organizer findOrganizerByu_p(String name, String password);

    void register(String username, String password);

    ArrayList<Organizer> getallOrganizer();

}
