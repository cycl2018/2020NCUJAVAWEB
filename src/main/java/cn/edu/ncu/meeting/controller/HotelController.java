package cn.edu.ncu.meeting.controller;

import cn.edu.ncu.meeting.entity.Hotel;
import cn.edu.ncu.meeting.entity.HotelOrder;
import cn.edu.ncu.meeting.entity.Room;
import cn.edu.ncu.meeting.entity.RoomNum;
import cn.edu.ncu.meeting.service.HotelService;
import cn.edu.ncu.meeting.service.RoomService;
import cn.edu.ncu.meeting.utils.Md5Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author 赖澄宇
 */
@Controller
@RequestMapping("/hotel")
public class HotelController {
    @Resource(name = "hotelServiceImpl")
    private HotelService hotelService;
    @Resource(name = "roomServiceImpl")
    private RoomService roomService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    boolean addHotel(String name,String address,String tel,int grade,
                  String hotelUserName,String password){
        List<Hotel> list = hotelService.findAllHotel();
        for(Hotel hotel:list){
            if(hotel.getHotelUserName().equals(hotelUserName)){
                return false;
            }
        }
        password = Md5Utils.code(password);
        hotelService.addHotel(name,address,tel,grade,hotelUserName,password);
        return true;
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    @ResponseBody
    List<Hotel> findAllHotel(){
        return hotelService.findAllHotel();
    }

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    List<Hotel> findHotelById(@RequestParam(value = "id") int id){
        return hotelService.findHotelById(id);
    }

    @RequestMapping(value = "/seedHotelOrder",method = RequestMethod.POST)
    @ResponseBody
    public void seedHotelOrder(int hotelId, int attendeeId, String attendeeTel){
        System.out.println(hotelId);
        System.out.println(attendeeId);
        System.out.println(attendeeTel);
        hotelService.seedHotelOrder(hotelId,attendeeId,attendeeTel);
    }

    @RequestMapping(value = "/confirmHotelOrder",method = RequestMethod.POST)
    @ResponseBody
    public boolean confirmHotelOrder(int orderId,String roomType,HttpSession session){
        System.out.println(orderId);
        System.out.println(roomType);
        Object userInfo = session.getAttribute("hotelId");
        if(userInfo ==  null){
            return false;
        }
        int hotelId =  Integer.parseInt(String.valueOf(userInfo));
        List<RoomNum> roomNums = roomService.findRoomTypeFreeNum(hotelId);
        for(RoomNum roomNum:roomNums){
            System.out.println(roomNum);
            if(roomType.equals(roomNum.getType())){
                if(roomNum.getNum()<=0){
                    return false;
                }else{
                    break;
                }
            }
        }
        System.out.println(hotelId);
        Room room = roomService.updateRoomUsedTrueByType(roomType,hotelId);
        hotelService.confirmHotelOrder(orderId,room.getId());
        return true;
    }

    @RequestMapping(value = "/finishHotelOrder",method = RequestMethod.POST)
    @ResponseBody
    public boolean finishHotelOrder(int orderId){
        System.out.println(orderId);
        try {
            hotelService.finishHotelOrder(orderId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/findHotelOrder",method = RequestMethod.POST)
    @ResponseBody
    public List<HotelOrder> findHotelOrder(HttpSession session) {
        Object userInfo = session.getAttribute("hotelId");
        if(userInfo ==  null){
            return null;
        }
        int hotelId =  Integer.parseInt(String.valueOf(userInfo));

        return hotelService.findHotelOrder(hotelId);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String hotelLogin(String name, String password, HttpSession session,
                             Map<String, Object> map){
        System.out.println(name);
        System.out.println(password);
        password = Md5Utils.code(password);
        Hotel hotel = hotelService.login(name,password);
        if (hotel != null){
            session.setAttribute("hotelId",hotel.getId());
            session.setAttribute("hotelName",hotel.getName());
            session.setAttribute("hotelUserName",hotel.getHotelUserName());
            System.out.println("success");
            map.put("name",hotel.getName());
            map.put("hotelId",hotel.getId());
            return "hotel/index.html";
        }else {
            System.out.println("fail");
            map.put("mesg","fail");
            return "hotel/login.html";
        }
    }
    @RequestMapping(value = "/logout")
    public String hotelLogout(HttpSession session) {
        System.out.println("logout");
        session.invalidate();
        return "hotel/login.html";
    }

    /**
     * 主页
     * @return ，，。
     */
    @RequestMapping("/index")
    public String index(){
        return "hotel/login.html";
    }

    @RequestMapping("/register")
    public String register(){
        return "hotel/register.html";
    }

    @RequestMapping("/hotel_list")
    public String hotelList(){
        return "hotel/hotel-list.html";
    }
    @RequestMapping("/hotel_order_list")
    public String hotelOrderList(){
        return "hotel/hotel-order-list.html";
    }
    @RequestMapping("/addHotelOrder")
    public String sendHotelOrder(){
        return "hotel/hotel-order-add.html";
    }
}
