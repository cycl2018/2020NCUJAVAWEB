package cn.edu.ncu.meeting.service.impl;

import cn.edu.ncu.meeting.dao.DriverDao;
import cn.edu.ncu.meeting.entity.Driver;
import cn.edu.ncu.meeting.service.DriverService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 赖澄宇
 */
@Service
public class DriverServiceImpl implements DriverService {
    @Resource
    private DriverDao driverDao;

    @Override
    public List<Driver> findDriverByName(String driverName) {
        return driverDao.findDriverByName(driverName);
    }

    @Override
    public List<Driver> findDriverByGrade(String driverGrade) {
        return driverDao.findDriverByGrade(driverGrade);
    }

    @Override
    public void addDriver(String driverName, int driverGrade) {
        driverDao.addDriver(driverName,driverGrade);
    }

}
