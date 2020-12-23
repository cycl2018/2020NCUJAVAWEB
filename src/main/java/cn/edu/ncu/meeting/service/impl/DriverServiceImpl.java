package cn.edu.ncu.meeting.service.impl;

import cn.edu.ncu.meeting.dao.DriverDao;
import cn.edu.ncu.meeting.entity.Driver;
import cn.edu.ncu.meeting.entity.DriverOrder;
import cn.edu.ncu.meeting.service.DriverService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author 赖澄宇
 */
@Service
public class DriverServiceImpl implements DriverService {
    @Resource
    private DriverDao driverDao;


    @Override
    public List<Driver> findDriver(int driverId) {
        return driverDao.findDriver(driverId);
    }

    @Override
    public List<Driver> findDriverByName(String name) {
        return driverDao.findDriverByName(name);
    }

    @Override
    public void addDriver(String name, String password) {
        driverDao.addDriver(name,password);
    }

    @Override
    public void updateDriver(String driverPassword, int driverId) {
        driverDao.updateDriver(driverPassword,driverId);
    }

    @Override
    public Driver login(String name, String password) {
        List<Driver> list = driverDao.findDriverByName(name);
        for(Driver driver : list){
            if(driver.getPassword().equals(password)) {
                return driver;
            }
        }
        return null;
    }

    @Override
    public void sendDriverOrder(int attendeeId, String attendeeTel, String address, Timestamp deadLine) {
        Timestamp orderTime = new Timestamp(System.currentTimeMillis());
        driverDao.sendDriverOrder(orderTime,attendeeId,attendeeTel,address,deadLine);
    }

    @Override
    public void confirmDriverOrder(int id, int driverId) {
        Timestamp confirmTime = new Timestamp(System.currentTimeMillis());
        driverDao.confirmDriverOrder(id,driverId,confirmTime);
    }

    @Override
    public void finishDriverOrder(int id) {
        Timestamp finishTime = new Timestamp(System.currentTimeMillis());
        driverDao.finishDriverOrder(id,finishTime);
    }

    @Override
    public List<DriverOrder> getFreeDriverOrder() {
        return driverDao.getFreeDriverOrder();
    }

    @Override
    public List<DriverOrder> getConfirmDriverOrder(int driverId) {
        return driverDao.getConfirmDriverOrder(driverId);
    }

    @Override
    public List<DriverOrder> getFinishDriverOrder(int driverId) {
        return driverDao.getFinishDriverOrder(driverId);
    }

    @Override
    public void evaluateDriverOrder(int id, int evaluateScore, String evaluate) {
        driverDao.evaluateDriverOrder(id,evaluateScore,evaluate);
    }
}
