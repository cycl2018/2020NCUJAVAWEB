package cn.edu.ncu.meeting.controller;

import cn.edu.ncu.meeting.entity.Hotel;
import cn.edu.ncu.meeting.entity.Room;
import cn.edu.ncu.meeting.entity.RoomNum;
import cn.edu.ncu.meeting.service.HotelService;
import cn.edu.ncu.meeting.service.RoomService;
import org.springframework.web.bind.annotation.*;

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
    @Resource(name = "hotelServiceImpl")
    private HotelService hotelService;

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

    /**
     * 推荐房间
     * @param peopleNum 人数需求
     * @param expectHotelGrade 期望酒店等级
     * @return 推荐的房间，找不到返回空
     */
    @RequestMapping(value = "/roomRecommend",method = RequestMethod.POST)
    public Room roomRecommend(@RequestParam("peopleNum") int peopleNum,
                             @RequestParam("expectHotelGrade") int expectHotelGrade){
        String recommendType;
        int firstType = 1;
        int secondType = 2;
        if(peopleNum <= firstType){
            recommendType = "单人房";
        }else if (peopleNum == secondType) {
            recommendType = "双人房";
        }else{
            recommendType = "豪华套房";
        }
        List<Hotel> list = hotelService.findAllHotel();
        Room ans = null;
        for(Hotel hotel:list){
            //不符合酒店期望等级
            if(hotel.getGrade()!=expectHotelGrade){
                continue;
            }
            List<RoomNum> roomList = roomService.findRoomTypeNum(hotel.getId());
            boolean flag = false;
            for(RoomNum roomNum:roomList){
                if(roomNum.getType().equals(recommendType) && roomNum.getNum()>0){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                continue;
            }
            List<Room> roomList1 = roomService.findRoomByHotelId(hotel.getId());
            for(Room room:roomList1){
                if(!room.isUsed() && room.getType().equals(recommendType)){
                    ans = room;
                    break;
                }
            }
            if(ans != null){
                break;
            }
        }
        return ans;
    }

}
