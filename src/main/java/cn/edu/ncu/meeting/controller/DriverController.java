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
@RequestMapping("/api")
public class DriverController {
    @Resource(name = "driverServiceImpl")
    private DriverService driverService;
    @RequestMapping(value = "/driver.name", method = RequestMethod.POST)
    public List<Driver> findOneDriver(@RequestParam(value = "driverName") String driverName){
        return driverService.findDriverByName(driverName);
    }
    @RequestMapping(value = "/driver.grade", method = RequestMethod.POST)
    public List<Driver> findDriverByGrade(@RequestParam(value = "driverGrade") String driverGrade){
        return driverService.findDriverByGrade(driverGrade);
    }
}
