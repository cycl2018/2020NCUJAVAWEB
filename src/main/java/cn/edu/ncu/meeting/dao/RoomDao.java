package cn.edu.ncu.meeting.dao;

import cn.edu.ncu.meeting.entity.Room;
import cn.edu.ncu.meeting.entity.RoomNum;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 赖澄宇
 */
@Mapper
public interface RoomDao {

    /**
     * 增加房间
     * @param type 房间类型
     * @param used 房间是否使用
     * @param price 房间价格
     * @param peopleNum 房价推荐人数
     * @param hotelId 酒店id
     */
    @Insert("INSERT INTO room (roomType,used,price,peopleNum,hotelId)" +
            "VALUE(#{type},#{used},#{price},#{peopleNum},#{hotelId})")
    void addRoom(@Param("type") String type,@Param("used") boolean used,
                 @Param("price") int price,@Param("peopleNum") int peopleNum,
                 @Param("hotelId") int hotelId);

    /**
     * 通过酒店id查找房间
     * @param hotelId 酒店id
     * @return Room List
     */
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "type",column = "roomType"),
            @Result(property = "used",column = "used"),
            @Result(property = "price",column = "price"),
            @Result(property = "peopleNum",column = "peopleNum"),
            @Result(property = "hotelId",column = "hotelId"),
    })
    @Select("SELECT * FROM room WHERE hotelId = #{hotelId}")
    List<Room> findRoomByHotelId(@Param("hotelId") int hotelId);

    /**
     * 查找酒店每种房间的数量
     * @param hotelId 酒店id
     * @return Hotel List
     */
    @Results({
            @Result(property = "type",column = "roomType"),
            @Result(property = "num",column = "COUNT(id)"),
    })
    @Select("SELECT roomType,COUNT(id) FROM room WHERE hotelId = #{hotelId} GROUP BY roomType")
    List<RoomNum> findRoomTypeNum(@Param("hotelId") int hotelId);

    /**
     * 查找酒店每种房间的空闲数量
     * @param hotelId 酒店id
     * @return Hotel List
     */
    @Results({
            @Result(property = "type",column = "roomType"),
            @Result(property = "num",column = "COUNT(id)"),
    })
    @Select("SELECT roomType,COUNT(id) FROM room " +
            "WHERE hotelId = #{hotelId} AND used = 0 GROUP BY roomType " )
    List<RoomNum> findRoomTypeFreeNum(@Param("hotelId") int hotelId);

    /**
     * 更新房间使用情况为0
     * @param roomId 房间id
     * @param hotelId 酒店id
     */
    @Update("UPDATE room SET used = 0 " +
            "WHERE id = #{roomId} AND hotelId = #{hotelId}")
    void updateRoomUsedFalse(@Param("roomId") int roomId,
                        @Param("hotelId") int hotelId);

    /**
     * 更新房间状态为true，预定房间
     * @param roomId 房间类型
     * @param hotelId 酒店id
     */

    @Update("UPDATE room SET used = 1 " +
            "WHERE id = #{roomId} AND hotelId = #{hotelId}")
    void updateRoomUsedTrueByType(@Param("roomId") int roomId,
                                  @Param("hotelId") int hotelId);

    @Select("SELECT * FROM room WHERE roomType = #{type} " +
            "AND used = 0 AND hotelId = #{hotelId}")
    List<Room> findFreeRoomId(String type,int hotelId);
    /**
     * 删除房间
     * @param roomId 房间id
     * @param hotelId 酒店id
     */
    @Delete("Delete FROM room WHERE id = #{roomId} AND hotelID = #{hotelId}")
    void delRoomById(int roomId,int hotelId);
}
