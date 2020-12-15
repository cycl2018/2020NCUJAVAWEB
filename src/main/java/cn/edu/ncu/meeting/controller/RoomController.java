package cn.edu.ncu.meeting.controller;

import cn.edu.ncu.meeting.entity.Room;
import cn.edu.ncu.meeting.entity.RoomNum;
import cn.edu.ncu.meeting.service.RoomService;
import org.springframework.stereotype.Service;
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
@RequestMapping("/room")
public class RoomController {
    @Resource(name = "roomServiceImpl")
    private RoomService roomService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void addRoom(@RequestParam(value = "type") String type,
                        @RequestParam(value = "used") boolean used,
                        @RequestParam(value = "price")int price,
                        @RequestParam(value = "peopleNum") int peopleNum,
                        @RequestParam(value = "hotelId") int hotelId){
        roomService.addRoom(type,used,price,peopleNum,hotelId);
    }

    @RequestMapping(value = "/findRoomByHotelId",method = RequestMethod.POST)
    public List<Room> findRoomByHotelId(@RequestParam("hotelId") int hotelId){
        System.out.println(hotelId);
        return roomService.findRoomByHotelId(hotelId);
    }

    @RequestMapping(value = "/findRoomTypeNum",method = RequestMethod.POST)
    public List<RoomNum> findRoomTypeNum(@RequestParam("hotelId") int hotelId) {
        return roomService.findRoomTypeNum(hotelId);
    }

    @RequestMapping(value = "/findRoomTypeFreeNum",method = RequestMethod.POST)
    public List<RoomNum> findRoomTypeFreeNum(@RequestParam("hotelId")int hotelId) {
        return roomService.findRoomTypeFreeNum(hotelId);
    }

    @RequestMapping(value = "/updateRoomUsedFalse",method = RequestMethod.POST)
    public void updateRoomUsedFalse(@RequestParam("roomId")int roomId,@RequestParam("hotelId") int hotelId) {
        roomService.updateRoomUsedFalse(roomId,hotelId);
    }

    @RequestMapping(value = "/updateRoomUsedTrueByType",method = RequestMethod.POST)
    public void updateRoomUsedTrueByType(@RequestParam("type") String type,@RequestParam("hotelId") int hotelId) {
        roomService.updateRoomUsedTrueByType(type,hotelId);
    }
}
