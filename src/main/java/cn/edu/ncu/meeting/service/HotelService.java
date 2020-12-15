package cn.edu.ncu.meeting.service;

import cn.edu.ncu.meeting.entity.Hotel;

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
     */
    void addHotel(String name,String address,String tel,int grade);

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
}
