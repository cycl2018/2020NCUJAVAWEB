package cn.edu.ncu.meeting.entity;

public class Organizer {
    private Integer id;
    private String username;
    private String password;

    public Organizer(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Organizer() {
    }

    @Override
    public String toString() {
        return "attendee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
