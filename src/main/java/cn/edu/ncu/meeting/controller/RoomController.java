package cn.edu.ncu.meeting.controller;

import cn.edu.ncu.meeting.entity.Hotel;
import cn.edu.ncu.meeting.entity.Room;
import cn.edu.ncu.meeting.entity.RoomNum;
import cn.edu.ncu.meeting.service.HotelService;
import cn.edu.ncu.meeting.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 赖澄宇
 */
@Controller
@RequestMapping("/room")
public class RoomController {
    @Resource(name = "roomServiceImpl")
    private RoomService roomService;
    @Resource(name = "hotelServiceImpl")
    private HotelService hotelService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public boolean addRoom(@RequestParam(value = "type") String type,
                        @RequestParam(value = "price")int price,
                        HttpSession session){
        int peopleNum ;
        if("单人房".equals(type)) {
            peopleNum = 1;
        } else if("双人房".equals(type)){
            peopleNum = 2;
        }else{
            peopleNum = 4;
        }
        Object userInfo = session.getAttribute("hotelId");
        if(userInfo ==  null){
            return false;
        }
        int hotelId =  Integer.parseInt(String.valueOf(userInfo));
        try {
            roomService.addRoom(type, false, price, peopleNum, hotelId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/findRoomByHotelId",method = RequestMethod.POST)
    @ResponseBody
    public List<Room> findRoomByHotelId(HttpSession session){
        Object userInfo = session.getAttribute("hotelId");
        if(userInfo ==  null){
            return null;
        }
        int hotelId =  Integer.parseInt(String.valueOf(userInfo));

        return roomService.findRoomByHotelId(hotelId);
    }

    @RequestMapping(value = "/findRoomTypeNum",method = RequestMethod.POST)
    @ResponseBody
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

    @RequestMapping(value = "/addRoom")
    public String addRoom(){
        return "hotel/addRoom.html";
    }

    @RequestMapping(value = "/delRoom")
    @ResponseBody
    public boolean delRoom(int roomId,HttpSession session){
        System.out.println(roomId);
        Object userInfo = session.getAttribute("hotelId");
        if(userInfo ==  null){
            return false;
        }
        int hotelId =  Integer.parseInt(String.valueOf(userInfo));
        try {
            System.out.println(roomId);
            System.out.println(hotelId);
            roomService.delRoomById(roomId, hotelId);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * 推荐房间
     * @param peopleNum 人数需求
     * @param expectHotelGrade 期望酒店等级
     * @return 推荐的房间，找不到返回空
     */
    @RequestMapping(value = "/roomRecommend",method = RequestMethod.POST)
    @ResponseBody
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
