package cn.edu.ncu.meeting.dao;
import cn.edu.ncu.meeting.entity.Driver;
import cn.edu.ncu.meeting.entity.DriverOrder;
import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.DomainEvents;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author 赖澄宇
 */
@Mapper
public interface DriverDao {
    /**
     * 查询司机
     * @param driverId 司机id
     * @return Driver List
     */
    @Select("SELECT * FROM driver WHERE id = #{driverId}")
    List<Driver> findDriver(int driverId);

    /**
     * 通过用户名查询司机
     * @param name 用户名
     * @return 结果
     */
    @Select("SELECT * FROM driver WHERE name = #{name}")
    List<Driver> findDriverByName(String name);
    /**
     * 插入司机信息
     * @param name 名字
     * @param password 密码
     */
    @Insert("INSERT INTO driver (name,password) VALUE(#{name},#{password})")
    void addDriver(String name, String password);


    /**
     * 修改密码
     * @param driverPassword 新密码
     * @param driverId 司机id
     */
    @Update("UPDATE driver SET password = #{driverPassword} " +
            "WHERE id = #{driverId}")
    void updateDriver(String driverPassword, int driverId);

    /**
     * 发送订单
     * @param orderTime 订单时间
     * @param attendeeId 参会者id
     * @param attendeeTel 参会者电话
     * @param address 地址
     * @param deadLine 最晚接送时间
     */
    @Insert("INSERT driverOrder (orderTime,attendeeId,attendeeTel,address,deadLine)" +
            "VALUE(#{orderTime},#{attendeeId},#{attendeeTel},#{address},#{deadLine})")
    void sendDriverOrder(Timestamp orderTime,int attendeeId,String attendeeTel,String address, Timestamp deadLine);

    /**
     * 司机确认订单
     * @param id 订单id
     * @param driverId 司机id
     * @param confirmTime 确认时间
     */
    @Update("UPDATE driverOrder SET driverId=#{driverId},confirm = 1,confirmTime=#{confirmTime}" +
            "WHERE id = #{id}")
    void confirmDriverOrder(int id,int driverId,Timestamp confirmTime);

    /**
     * 完成订单
     * @param id 订单id
     * @param finishTime 完成时间
     */
    @Update("UPDATE driverOrder SET finish = 1,finishTime=#{finishTime}" +
            "WHERE id = #{id}")
    void finishDriverOrder(int id,Timestamp finishTime);

    /**
     * 查找空闲的订单
     * @return 所有未确定的订单
     */
    @Select("SELECT * FROM driverOrder WHERE confirm = 0")
    List<DriverOrder> getFreeDriverOrder();

    /**
     * 查找某个司机接受的订单
     * @param driverId 司机id
     * @return 所有接受的还未完成的订单
     */
    @Select("SELECT * FROM driverOrder WHERE driverId = #{driverId} AND finish = 0")
    List<DriverOrder> getConfirmDriverOrder(int driverId);

    /**
     * 查找所有完成的订单
     * @param driverId 司机id
     * @return 订单
     */
    @Select("SELECT * FROM driverOrder WHERE driverId = #{driverId} AND finish = 1")
    List<DriverOrder> getFinishDriverOrder(int driverId);

    /**
     * 评论
     * @param id 订单id
     * @param evaluateScore 评分
     * @param evaluate 评价
     */
    @Update("UPDATE driverOrder SET evaluateScore=#{evaluateScore},evaluate=#{evaluate}" +
            "WHERE id = #{id}")
    void evaluateDriverOrder(int id,int evaluateScore,String evaluate);

    @Select("SELECT * FROM driver")
    List<Driver> findAll();

    @Delete("DELETE FROM driver WHERE id = #{driverId}")
    void deleteDriver(int driverId);
}
