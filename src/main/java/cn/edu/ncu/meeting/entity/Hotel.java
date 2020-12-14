package cn.edu.ncu.meeting.entity;

/**
 * @author 赖澄宇
 *
 */
public class Hotel {

    private int id;
    private String name;
    private String address;
    private int maxRoomName;
    private int usedRoomNum;

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

    public int getMaxRoomName() {
        return maxRoomName;
    }

    public void setMaxRoomName(int maxRoomName) {
        this.maxRoomName = maxRoomName;
    }

    public int getUsedRoomNum() {
        return usedRoomNum;
    }

    public void setUsedRoomNum(int usedRoomNum) {
        this.usedRoomNum = usedRoomNum;
    }
}
