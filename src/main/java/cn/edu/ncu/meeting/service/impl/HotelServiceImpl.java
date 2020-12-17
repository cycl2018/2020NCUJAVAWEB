package cn.edu.ncu.meeting.service.impl;

import cn.edu.ncu.meeting.dao.HotelDao;
import cn.edu.ncu.meeting.entity.Hotel;
import cn.edu.ncu.meeting.entity.HotelOrder;
import cn.edu.ncu.meeting.service.HotelService;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author 赖澄宇
 */
@Service
public class HotelServiceImpl implements HotelService {
    @Resource
    private HotelDao hotelDao;

    @Override
    public void addHotel(String name, String address, String tel, int grade) {
        hotelDao.addHotel(name,address,tel,grade);
    }

    @Override
    public List<Hotel> findAllHotel() {
        return hotelDao.findAllHotel();
    }

    @Override
    public List<Hotel> findHotelById(int hotelId) {
        return hotelDao.findHotelById(hotelId);
    }

    @Override
    public void seedHotelOrder(int hotelId, int attendeeId, String attendeeTel) {
        Timestamp orderTime = new Timestamp(System.currentTimeMillis());
        hotelDao.seedHotelOrder(hotelId,orderTime,attendeeId,attendeeTel);
    }

    @Override
    public void confirmHotelOrder(int orderId) {
        Timestamp startTime = new Timestamp(System.currentTimeMillis());
        hotelDao.confirmHotelOrder(orderId,startTime);
    }

    @Override
    public void finishHotelOrder(int orderId) {
        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        System.out.println(orderId);
        System.out.println(endTime);
        hotelDao.finishHotelOrder(orderId,endTime);
    }

    @Override
    public List<HotelOrder> findHotelOrder(int hotelId) {
        return hotelDao.findHotelOrder(hotelId);
    }
}
