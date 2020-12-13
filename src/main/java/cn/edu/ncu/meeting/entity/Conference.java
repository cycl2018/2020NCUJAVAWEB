package cn.edu.ncu.meeting.entity;

//一个会议的总览表
public class Conference {

    private Integer id;
    private String name;
    private String organizername;
    private String datetime;
    private Integer renshu;
    private Integer hotelid;
    private String about;
    private Integer organizerid;


    public Conference(String name, String organizername, String datetime, Integer renshu, Integer hotelid, String about, Integer organizerid) {
        this.name = name;
        this.organizername = organizername;
        this.datetime = datetime;
        this.renshu = renshu;
        this.hotelid = hotelid;
        this.about = about;
        this.organizerid = organizerid;
    }

    public Conference() {
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", organizername='" + organizername + '\'' +
                ", datetime='" + datetime + '\'' +
                ", renshu=" + renshu +
                ", hotelid=" + hotelid +
                ", about='" + about + '\'' +
                ", organizerid=" + organizerid +
                '}';
    }

    public Integer getOrganizerid() {
        return organizerid;
    }

    public void setOrganizerid(Integer organizerid) {
        this.organizerid = organizerid;
    }

    public String getOrganizername() {
        return organizername;
    }

    public void setOrganizername(String organizername) {
        this.organizername = organizername;
    }

    public Integer getHotelid() {
        return hotelid;
    }

    public void setHotelid(Integer hotelid) {
        this.hotelid = hotelid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Integer getRenshu() {
        return renshu;
    }

    public void setRenshu(Integer renshu) {
        this.renshu = renshu;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
