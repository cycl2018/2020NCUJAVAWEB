package cn.edu.ncu.meeting.entity;


import java.sql.Timestamp;

/**
 * @author 赖澄宇
 */
public class HotelOrder {

  private int id;
  private int hotelId;
  private Timestamp orderTime;
  private Timestamp startTime;
  private Timestamp endTime;
  private int confirm;
  private int finish;
  private int attendeeId;
  private String attendeeTel;
  private int roomId;

  public int getRoomId() {
    return roomId;
  }

  public void setRoomId(int roomId) {
    this.roomId = roomId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getHotelId() {
    return hotelId;
  }

  public void setHotelId(int hotelId) {
    this.hotelId = hotelId;
  }

  public Timestamp getOrderTime() {
    return orderTime;
  }

  public void setOrderTime(Timestamp orderTime) {
    this.orderTime = orderTime;
  }

  public Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(Timestamp startTime) {
    this.startTime = startTime;
  }

  public Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(Timestamp endTime) {
    this.endTime = endTime;
  }

  public int getConfirm() {
    return confirm;
  }

  public void setConfirm(int confirm) {
    this.confirm = confirm;
  }

  public int getFinish() {
    return finish;
  }

  public void setFinish(int finish) {
    this.finish = finish;
  }

  public int getAttendeeId() {
    return attendeeId;
  }

  public void setAttendeeId(int attendeeId) {
    this.attendeeId = attendeeId;
  }

  public String getAttendeeTel() {
    return attendeeTel;
  }

  public void setAttendeeTel(String attendeeTel) {
    this.attendeeTel = attendeeTel;
  }
}
