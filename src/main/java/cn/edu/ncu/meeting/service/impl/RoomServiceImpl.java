package cn.edu.ncu.meeting.service.impl;

import cn.edu.ncu.meeting.dao.RoomDao;
import cn.edu.ncu.meeting.entity.Room;
import cn.edu.ncu.meeting.entity.RoomNum;
import cn.edu.ncu.meeting.service.RoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 赖澄宇
 */
@Service
public class RoomServiceImpl implements RoomService {
    @Resource
    private RoomDao roomDao;


    @Override
    public void addRoom(String type, boolean used, int price, int peopleNum, int hotelId) {
        roomDao.addRoom(type,used,price,peopleNum,hotelId);
    }

    @Override
    public List<Room> findRoomByHotelId(int hotelId) {
        return roomDao.findRoomByHotelId(hotelId);
    }

    @Override
    public List<RoomNum> findRoomTypeNum(int hotelId) {
        return roomDao.findRoomTypeNum(hotelId);
    }

    @Override
    public List<RoomNum> findRoomTypeFreeNum(int hotelId) {
        return roomDao.findRoomTypeFreeNum(hotelId);
    }

    @Override
    public void updateRoomUsedFalse(int roomId, int hotelId) {
        roomDao.updateRoomUsedFalse(roomId,hotelId);
    }

    @Override
    public void updateRoomUsedTrueByType(String type, int hotelId) {
        roomDao.updateRoomUsedTrueByType(type,hotelId);
    }
}
