package cn.edu.ncu.meeting.dao;

import cn.edu.ncu.meeting.entity.Hotel;
import org.apache.ibatis.annotations.*;

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
}
