package cn.edu.ncu.meeting.service;

import cn.edu.ncu.meeting.entity.Driver;
import cn.edu.ncu.meeting.entity.DriverOrder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author 赖澄宇
 */

public interface DriverService {
    /**
     * 查询司机
     * @param driverId 司机id
     * @return Driver List
     */
    List<Driver> findDriver(int driverId);

    List<Driver> findDriverByName(String name);
    /**
     * 插入司机信息
     * @param name 名字
     * @param password 密码
     */
    void addDriver(String name, String password);
    /**
     * 修改密码
     * @param driverPassword 新密码
     * @param driverId 司机id
     */
    void updateDriver(String driverPassword, int driverId);

    /**
     * 登录
     * @param name 用户名
     * @param password 密码
     * @return 是否正确
     */
    Driver login(String name,String password);
    /**
     * 发送订单
     * @param attendeeId 参会者id
     * @param attendeeTel 参会者电话
     * @param address 地址
     * @param deadLine 最晚接送时间
     */
    void sendDriverOrder(int attendeeId, String attendeeTel, String address, Timestamp deadLine);
    /**
     * 司机确认订单
     * @param id 订单id
     * @param driverId 司机id
     */
    void confirmDriverOrder(int id,int driverId);

    /**
     * 完成订单
     * @param id 订单id
     */
    void finishDriverOrder(int id);
    /**
     * 查找空闲的订单
     * @return 所有未确定的订单
     */
    List<DriverOrder> getFreeDriverOrder();
    /**
     * 查找某个司机接受的订单
     * @param driverId 司机id
     * @return 所有接受的还未完成的订单
     */
    List<DriverOrder> getConfirmDriverOrder(int driverId);
    /**
     * 查找所有完成的订单
     * @param driverId 司机id
     * @return 订单
     */
    List<DriverOrder> getFinishDriverOrder(int driverId);
    /**
     * 评论
     * @param id 订单id
     * @param evaluateScore 评分
     * @param evaluate 评价
     */
    void evaluateDriverOrder(int id,int evaluateScore,String evaluate);


    List<Driver> findAll();

    void deleteDriver(int driverId);
}
