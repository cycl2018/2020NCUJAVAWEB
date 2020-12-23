package cn.edu.ncu.meeting.controller;

import cn.edu.ncu.meeting.entity.Driver;
import cn.edu.ncu.meeting.entity.DriverOrder;
import cn.edu.ncu.meeting.service.DriverService;
import cn.edu.ncu.meeting.utils.Md5Utils;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author 赖澄宇
 *
 */
@Controller
@RequestMapping("/driver")
public class DriverController {
    @Resource(name = "driverServiceImpl")
    private DriverService driverService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public boolean addDriver(String name, String password){
        System.out.println(name);
        System.out.println(password);
        List<Driver> list = driverService.findDriverByName(name);
        if(!list.isEmpty()){
            return false;
        }
        password = Md5Utils.code(password);
        driverService.addDriver(name,password);
        return true;
    }

    @RequestMapping(value = "/register")
    public String register(){
        return "driver/register.html";
    }

    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    void updateDriver(String driverPassword, int driverId){
        driverPassword = Md5Utils.code(driverPassword);
        driverService.updateDriver(driverPassword,driverId);
    }

    @RequestMapping(value = "/goLogin",method = RequestMethod.POST)
    public String login(String name, String password, HttpSession session,
                         Map<String, Object> map){
        password = Md5Utils.code(password);
        System.out.println(name);
        Driver driver = driverService.login(name,password);
        if (driver != null){
            session.setAttribute("driverId",driver.getId());
            session.setAttribute("driverName",driver.getName());
            map.put("name",driver.getName());
            return "driver/index.html";
        }else {
            map.put("mesg","fail");
            return "driver/login.html";
        }
    }

    @RequestMapping(value = "/login")
    public String loginDriver() {
        return "driver/login.html";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "driver/login.html";
    }

    @RequestMapping(value = "/introduce")
    public String introduce(){
        return "driver/introduce.html";
    }

    @RequestMapping(value = "/orderList")
    public String orderList() {
        return "driver/orderList.html";
    }
    @RequestMapping(value = "/acceptedOrderList")
    public String orderList1() {
        return "driver/acceptedOrderList.html";
    }
    @RequestMapping(value = "/finishOrderList")
    public String orderList2() {
        return "driver/finishOrderList.html";
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
