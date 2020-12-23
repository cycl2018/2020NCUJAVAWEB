package cn.edu.ncu.meeting.service.Iservice;

import cn.edu.ncu.meeting.entity.Conference;

import java.util.ArrayList;
import java.util.List;

public interface IConferenceService {
    ArrayList<Conference> getallConference();

    void addConference(String name, String organizername, String datetime, Integer renshu, Integer hotelid, String about, Integer organizerid);

    Conference getConferenceById(String id);

    void deleteById(String id);
}
