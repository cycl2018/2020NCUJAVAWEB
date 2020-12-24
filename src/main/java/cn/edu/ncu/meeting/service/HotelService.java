package cn.edu.ncu.meeting.service;

import cn.edu.ncu.meeting.entity.Driver;
import cn.edu.ncu.meeting.entity.Hotel;
import cn.edu.ncu.meeting.entity.HotelOrder;
import org.apache.ibatis.annotations.Insert;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author 赖澄宇
 */
public interface HotelService {
    /**
     * 增加酒店信息
     * @param name 酒店名
     * @param address 酒店地址
     * @param tel 酒店电话
     * @param grade 酒店等级
     * @param hotelUserName 登录用户名
     * @param password 密码
     */
    void addHotel(String name,String address,String tel,int grade,
                  String hotelUserName,String password);
    /**
     * 查找所有酒店
     * @return Hotel List
     */
    List<Hotel> findAllHotel();

    /**
     * 通过id查找酒店
     * @param hotelId 酒店id
     * @return Hotel List
     */
    List<Hotel> findHotelById(int hotelId);

    /**
     * 参会者向就酒店发送订单
     * @param hotelId 酒店id
     * @param attendeeId 参会者id
     * @param attendeeTel 参会者电话
     */
    void seedHotelOrder(int hotelId,int attendeeId,String attendeeTel);
    /**
     * 酒店确认订单
     * @param orderId 订单编号
     * @param roomId 房间号
     */
    void confirmHotelOrder(int orderId,int roomId);

    /**
     * 完成订单
     * @param orderId 订单编号
     */
    void finishHotelOrder(int orderId);

    /**
     * 通过酒店id查找订单
     * @param hotelId 酒店id
     * @return 查找到的订单
     */
    List<HotelOrder> findHotelOrder(int hotelId);

    /**
     * 登录
     * @param name 用户名
     * @param password 密码
     * @return hotel
     */
    Hotel login(String name, String password);

    void deleteHotel(int hotelId);
}
