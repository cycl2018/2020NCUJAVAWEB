package cn.edu.ncu.meeting.controller;

import cn.edu.ncu.meeting.entity.Driver;
import cn.edu.ncu.meeting.entity.DriverOrder;
import cn.edu.ncu.meeting.service.DriverService;
import cn.edu.ncu.meeting.utils.Md5Utils;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    void addDriver(String name, String password){
        password = Md5Utils.code(password);
        driverService.addDriver(name,password);
    }

    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    void updateDriver(String driverPassword, int driverId){
        driverPassword = Md5Utils.code(driverPassword);
        driverService.updateDriver(driverPassword,driverId);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String name, String password, HttpSession session){
        password = Md5Utils.code(password);
        Driver driver = driverService.login(name,password);
        if (driver != null){
            session.setAttribute("driverId",driver.getId());
            session.setAttribute("driverName",driver.getName());
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

    @RequestMapping(value = "/sendDriverOrder",method = RequestMethod.POST)
    void sendDriverOrder(int attendeeId, String attendeeTel, String address, Timestamp deadLine){
        driverService.sendDriverOrder(attendeeId,attendeeTel,address,deadLine);
    }

    @RequestMapping(value = "/confirmDriverOrder",method = RequestMethod.POST)
    void confirmDriverOrder(int id,int driverId){
        driverService.confirmDriverOrder(id,driverId);
    }
    @RequestMapping(value = "/finishDriverOrder",method = RequestMethod.POST)
    void finishDriverOrder(int id){
        driverService.findDriver(id);
    }
    @RequestMapping(value = "/getFreeDriverOrder",method = RequestMethod.POST)
    List<DriverOrder> getFreeDriverOrder(){
        return driverService.getFreeDriverOrder();
    }
    @RequestMapping(value = "/getConfirmDriverOrder",method = RequestMethod.POST)
    List<DriverOrder> getConfirmDriverOrder(int driverId){
        return driverService.getConfirmDriverOrder(driverId);
    }
    @RequestMapping(value = "/getFinishDriverOrder",method = RequestMethod.POST)
    List<DriverOrder> getFinishDriverOrder(int driverId){
        return driverService.getFinishDriverOrder(driverId);
    }
    @RequestMapping(value = "/evaluateDriverOrder",method = RequestMethod.POST)
    void evaluateDriverOrder(int id,int evaluateScore,String evaluate){
        driverService.evaluateDriverOrder(id,evaluateScore,evaluate);
    }

}
