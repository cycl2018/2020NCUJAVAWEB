package cn.edu.ncu.meeting.service;

import cn.edu.ncu.meeting.entity.Room;
import cn.edu.ncu.meeting.entity.RoomNum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 赖澄宇
 */
public interface RoomService {
    /**
     * 增加房间
     * @param type 房间类型
     * @param used 房间是否使用
     * @param price 房间价格
     * @param peopleNum 房价推荐人数
     * @param hotelId 酒店id
     */
    void addRoom(String type,boolean used,int price,int peopleNum,int hotelId);
    /**
     * 通过酒店id查找房间
     * @param hotelId 酒店id
     * @return Room List
     */
    List<Room> findRoomByHotelId(int hotelId);
    /**
     * 查找酒店每种房间的数量
     * @param hotelId 酒店id
     * @return Hotel List
     */
    List<RoomNum> findRoomTypeNum(int hotelId);
    /**
     * 查找酒店每种房间的空闲数量
     * @param hotelId 酒店id
     * @return Hotel List
     */
    List<RoomNum> findRoomTypeFreeNum(@Param("hotelId") int hotelId);
    /**
     * 更新房间使用情况为0
     * @param roomId 房间id
     * @param hotelId 酒店id
     */
    void updateRoomUsedFalse(int roomId,int hotelId);
    /**
     * 更新房间状态为true，预定房间
     * @param type 房间类型
     * @param hotelId 酒店id
     * @return room
     */
    Room updateRoomUsedTrueByType(String type,int hotelId);

    /**
     * 删除房间
     * @param roomId 房间id
     * @param hotelId 酒店id
     */
    void delRoomById(int roomId,int hotelId);
}
