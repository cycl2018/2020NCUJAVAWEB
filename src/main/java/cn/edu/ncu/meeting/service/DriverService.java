package cn.edu.ncu.meeting.service;

import cn.edu.ncu.meeting.entity.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 赖澄宇
 */

public interface DriverService {
    /**
     *
     * @param driverName
     * @return Driver对象列表
     */
    List<Driver> findDriverByName(String driverName);
    List<Driver> findDriverByGrade(String driverGrade);
}
