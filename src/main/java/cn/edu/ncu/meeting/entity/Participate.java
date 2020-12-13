package cn.edu.ncu.meeting.entity;


//参会记录
public class Participate {
    Integer id;
    Integer conferenceId;
    Integer attendeeId;
    //旅馆号
    Integer hotelId;
    //司机号
    Integer driverId;
    //房间号
    Integer roomId;
    String departtime;
    String returntime;
    String need;

    public Participate(Integer conferenceId, Integer attendeeId, Integer hotelId, String departtime, String returntime, String need) {
        this.conferenceId = conferenceId;
        this.attendeeId = attendeeId;
        this.hotelId = hotelId;
        this.departtime = departtime;
        this.returntime = returntime;
        this.need = need;
    }

    public Participate() {
    }

    @Override
    public String toString() {
        return "Participate{" +
                "id=" + id +
                ", conferenceId=" + conferenceId +
                ", attendeeId=" + attendeeId +
                ", hotelId=" + hotelId +
                ", driverId=" + driverId +
                ", roomId=" + roomId +
                ", departtime='" + departtime + '\'' +
                ", returntime='" + returntime + '\'' +
                ", need='" + need + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(Integer conferenceId) {
        this.conferenceId = conferenceId;
    }

    public Integer getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(Integer attendeeId) {
        this.attendeeId = attendeeId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Integer getDriverId() {
        return driverId;
    }

    public void setDriverId(Integer driverId) {
        this.driverId = driverId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getDeparttime() {
        return departtime;
    }

    public void setDeparttime(String departtime) {
        this.departtime = departtime;
    }

    public String getReturntime() {
        return returntime;
    }

    public void setReturntime(String returntime) {
        this.returntime = returntime;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }
}
