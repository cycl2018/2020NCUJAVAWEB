package cn.edu.ncu.meeting.controller;

import cn.edu.ncu.meeting.entity.Driver;
import cn.edu.ncu.meeting.service.DriverService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 赖澄宇
 *
 */
@RestController
@RequestMapping("/driver")
public class DriverController {
    @Resource(name = "driverServiceImpl")
    private DriverService driverService;
    @RequestMapping(value = "/name", method = RequestMethod.POST)
    public List<Driver> findOneDriver(@RequestParam(value = "driverName") String driverName){
        return driverService.findDriverByName(driverName);
    }
    @RequestMapping(value = "/grade", method = RequestMethod.POST)
    public List<Driver> findDriverByGrade(@RequestParam(value = "driverGrade") String driverGrade){
        return driverService.findDriverByGrade(driverGrade);
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addDriver(@RequestParam(value = "driverName") String driverName,
                          @RequestParam(value = "driverGrade") int driverGrade){
        System.out.println(driverName);
        System.out.println(driverGrade);
        driverService.addDriver(driverName,driverGrade);
    }
}
