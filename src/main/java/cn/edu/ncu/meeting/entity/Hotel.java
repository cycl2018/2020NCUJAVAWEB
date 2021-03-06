package cn.edu.ncu.meeting.entity;

/**
 * @author 赖澄宇
 *酒店实体
 */
public class Hotel {

    private int id;
    private String name;
    private String address;
    private String tel;
    private int grade;
    private String hotelUserName;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getHotelUserName() {
        return hotelUserName;
    }

    public void setHotelUserName(String hotelUserName) {
        this.hotelUserName = hotelUserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
