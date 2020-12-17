package cn.edu.ncu.meeting.dao;

import cn.edu.ncu.meeting.entity.Hotel;
import cn.edu.ncu.meeting.entity.HotelOrder;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author 赖澄宇
 */
@Mapper
public interface HotelDao {
    /**
     * 增加酒店信息
     * @param name 酒店名
     * @param address 酒店地址
     * @param tel 酒店电话
     * @param grade 酒店等级
     */
    @Insert("INSERT INTO hotel (name,address,tel,grade) " +
            "VALUE(#{name},#{address},#{tel},#{grade})")
    void addHotel(@Param("name") String name,@Param("address")String address,
             @Param("tel") String tel,@Param("grade") int grade);

    /**
     * 查找所有酒店
     * @return Hotel List
     */
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "address",column = "address"),
            @Result(property = "tel",column = "tel"),
            @Result(property = "grade",column = "grade"),
    })
    @Select("SELECT * FROM hotel")
    List<Hotel> findAllHotel();

    /**
     * 按照id查找酒店
     * @param hotelId 酒店id
     * @return Hotel List
     */
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "address",column = "address"),
            @Result(property = "tel",column = "tel"),
            @Result(property = "grade",column = "grade"),
    })
    @Select("SELECT * FROM hotel WHERE id = #{hotelId}")
    List<Hotel> findHotelById(@Param("hotelId") int hotelId);

    /**
     * 参会者向就酒店发送订单
     * @param hotelId 酒店id
     * @param orderTime 预定订单时间
     * @param attendeeId 参会者id
     * @param attendeeTel 参会者电话
     */
    @Insert("INSERT INTO hotelOrder (hotelId,orderTime,attendeeId,attendeeTel)" +
            "VALUE(#{hotelId},#{orderTime},#{attendeeId},#{attendeeTel})")
    void seedHotelOrder(int hotelId, Timestamp orderTime,
                        int attendeeId,String attendeeTel);

    /**
     * 酒店确认订单
     * @param orderId 订单编号
     * @param startTime 确认时间/开始居住时间
     */
    @Update("UPDATE hotelOrder SET confirm = 1, startTime = #{startTime}" +
            "WHERE id = #{orderId}")
    void confirmHotelOrder(int orderId,Timestamp startTime);

    /**
     * 完成订单
     * @param orderId 订单编号
     * @param endTime 结束时间
     */
    @Update("UPDATE hotelOrder SET finish = 1, endTime = #{endTime}" +
            "WHERE id = #{orderId}")
    void finishHotelOrder(int orderId,Timestamp endTime);

    /**
     * 通过酒店id查找订单
     * @param hotelId 酒店id
     * @return 查找到的订单
     */
    @Select("SELECT * FROM hotelOrder WHERE hotelId = #{hotelId}")
    List<HotelOrder> findHotelOrder(int hotelId);
}
