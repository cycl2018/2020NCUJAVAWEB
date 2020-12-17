package cn.edu.ncu.meeting.controller;

import cn.edu.ncu.meeting.entity.Hotel;
import cn.edu.ncu.meeting.entity.HotelOrder;
import cn.edu.ncu.meeting.service.HotelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 赖澄宇
 */
@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Resource(name = "hotelServiceImpl")
    private HotelService hotelService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    void addHotel(@RequestParam(value = "name") String name,
                  @RequestParam(value = "address") String address,
                  @RequestParam(value = "tel") String tel,
                  @RequestParam(value = "grade") int grade){
        System.out.println(name);
        System.out.println(address);
        System.out.println(tel);
        System.out.println(grade);
        hotelService.addHotel(name,address,tel,grade);
    }

    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    List<Hotel> findAllHotel(){
        return hotelService.findAllHotel();
    }

    @RequestMapping(value = "/findById",method = RequestMethod.POST)
    List<Hotel> findHotelById(@RequestParam(value = "id") int id){
        return hotelService.findHotelById(id);
    }

    @RequestMapping(value = "/seedHotelOrder",method = RequestMethod.POST)
    public void seedHotelOrder(int hotelId, int attendeeId, String attendeeTel){
        System.out.println(hotelId);
        System.out.println(attendeeId);
        System.out.println(attendeeTel);
        hotelService.seedHotelOrder(hotelId,attendeeId,attendeeTel);
    }

    @RequestMapping(value = "/confirmHotelOrder",method = RequestMethod.POST)
    public void confirmHotelOrder(int orderId){
        hotelService.confirmHotelOrder(orderId);
    }

    @RequestMapping(value = "/finishHotelOrder",method = RequestMethod.POST)
    public void finishHotelOrder(int orderId){
        System.out.println(orderId);
        hotelService.finishHotelOrder(orderId);
    }

    @RequestMapping(value = "/findHotelOrder",method = RequestMethod.POST)
    public List<HotelOrder> findHotelOrder(int hotelId) {
        return hotelService.findHotelOrder(hotelId);
    }
}
