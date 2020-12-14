package cn.edu.ncu.meeting.dao;
import cn.edu.ncu.meeting.entity.Driver;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 赖澄宇
 */
@Mapper
public interface DriverDao {
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "grade",column = "grade"),
            @Result(property = "used",column = "used"),
    })
    @Select("SELECT * FROM driver WHERE name = #{driverName}")
    List<Driver> findDriverByName(@Param("driverName") String driverName);

    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "grade",column = "grade"),
            @Result(property = "used",column = "used"),
    })
    @Select("SELECT * FROM driver WHERE grade = #{driverGrade}")
    List<Driver> findDriverByGrade(@Param("driverGrade") String driverGrade);

    @Insert("INSERT INTO driver (name,grade) VALUE(#{name},#{grade})")
    void addDriver(@Param("name") String name,@Param("grade") int grade);


}
