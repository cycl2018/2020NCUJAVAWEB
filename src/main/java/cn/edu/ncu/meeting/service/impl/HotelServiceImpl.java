package cn.edu.ncu.meeting.service.impl;

import cn.edu.ncu.meeting.dao.HotelDao;
import cn.edu.ncu.meeting.entity.Hotel;
import cn.edu.ncu.meeting.service.HotelService;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
