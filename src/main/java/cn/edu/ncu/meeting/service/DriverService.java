package cn.edu.ncu.meeting.service;

import cn.edu.ncu.meeting.entity.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 赖澄宇
 */

public interface DriverService {
    /**
     *通过名字查找司机
     * @param driverName Sting
     * @return Driver对象列表
     */
    List<Driver> findDriverByName(String driverName);

    /**
     * 通过等级查找司机
     * @param driverGrade String
     * @return Driver List
     */
    List<Driver> findDriverByGrade(String driverGrade);

    /**
     * 增加司机信息
     * @param name 名字 String
     * @param grade 等级 int
     */
    void addDriver(String name,int grade);
}
