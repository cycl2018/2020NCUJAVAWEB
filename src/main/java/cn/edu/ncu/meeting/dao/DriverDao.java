package cn.edu.ncu.meeting.dao;
import cn.edu.ncu.meeting.entity.Driver;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 赖澄宇
 */
@Mapper
public interface DriverDao {
    /**
     * 按照名字查询司机
     * @param driverName 司机名字 string
     * @return Driver List
     */
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "grade",column = "grade"),
            @Result(property = "used",column = "used"),
    })
    @Select("SELECT * FROM driver WHERE name = #{driverName}")
    List<Driver> findDriverByName(@Param("driverName") String driverName);

    /**
     * 按照等级查询司机
     * @param driverGrade 司机等级 int
     * @return Driver List
     */
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "grade",column = "grade"),
            @Result(property = "used",column = "used"),
    })
    @Select("SELECT * FROM driver WHERE grade = #{driverGrade}")
    List<Driver> findDriverByGrade(@Param("driverGrade") String driverGrade);

    /**
     * 按照空闲状态查找司机
     * @param  driverUsed 司机空闲状态 0/1
     * @return Driver List
     */
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "grade",column = "grade"),
            @Result(property = "used",column = "used"),
    })
    @Select("SELECT * FROM driver WHERE used = #{driverUsed}")
    List<Driver> findDriverByUsed(@Param("driverUsed") String driverUsed);


    /**
     * 插入司机信息
     * @param name 名字
     * @param grade 等级 1 - 3
     */
    @Insert("INSERT INTO driver (name,grade,used) VALUE(#{name},#{grade},0)")
    void addDriver(@Param("name") String name,@Param("grade") int grade);

    /**
     * 更新司机信息
     * @param name 司机姓名
     * @param driverGrade 司机等级
     * @param driverUsed 司机空闲状态
     * @param driverId 司机ID
     */
    @Update("UPDATE driver SET name = #{driverName} grade = #{driverGrade} used = #{driverUsed} " +
            "WHERE id = #{driverId}")
    void updateDriver(@Param("driverName") String name,@Param("driverGrade") int driverGrade,
                      @Param("driverUsed") int driverUsed,@Param("driverId") int driverId);
}
