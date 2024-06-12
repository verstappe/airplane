package com.sky.service.impl;

import com.sky.dto.FlightFlyTimeDTO;
import com.sky.dto.FlightNumberDTO;
import com.sky.dto.FlightPriceDTO;
import com.sky.dto.FlightTouristSubmitOrderDTO;
import com.sky.entity.Flight;
import com.sky.exception.FlightException;
import com.sky.mapper.FlightManageMapper;
import com.sky.service.FlightManageService;
import com.sky.vo.FlightVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FlightManageServiceImpl implements FlightManageService {
    @Autowired
    private FlightManageMapper flightManageMapper;

    /**
     * 添加航班信息
     * @param flight
     */
    @Override
    public void addFlight(Flight flight) {

        flightManageMapper.addFlight(flight);
    }

    /**
     * 修改航班信息
     * @param flight
     */
    @Override
    public void updateFlight(Flight flight) {
        flightManageMapper.updateFlight(flight);
    }

    /**
     * 根据id查询航班信息
     * @param flightId
     */
    @Override
    public FlightVO getFlight(Integer flightId) {
        return flightManageMapper.getFlight(flightId);

    }

    /**
     * 根据id删除航班信息
     * @param flightId
     */
    @Override
    public void deleteFlight(Integer flightId) {
        flightManageMapper.deleteFlight(flightId);
    }

    @Override
    public List<FlightVO> getFlightMessage(Flight flight) {
        return flightManageMapper.getFlightMessage(flight);

    }
    /**
     * 修改航班的舱位的价位
     * @param flightPriceDTO
     * @return
     */
    @Override
    public void updateFlightPrice(FlightPriceDTO flightPriceDTO) {
        if (flightPriceDTO.getFlightId() == null){
            throw new FlightException("航班ID未填写");
        }
        if (flightPriceDTO.getFlightNumber() == null){
            throw new FlightException("航班号未填写");
        }
        flightManageMapper.updateFlightPrice(flightPriceDTO);
    }

    /**
     * 修改航班的各舱位的座位数量
     * @param flightNumberDTO
     * @return
     */
    @Override
    public void updateFlightStatusNumber(FlightNumberDTO flightNumberDTO) {
        if (flightNumberDTO.getFlightId() == null){
            throw new FlightException("航班ID未填写");
        }
        if (flightNumberDTO.getFlightNumber() == null){
            throw new FlightException("航班号未填写");
        }
        flightManageMapper.updateFlightStatusNumber(flightNumberDTO);
    }
    /**
     * 修改航班的起始时间
     * @param flightFlyTimeDTO
     * @return
     */
    @Override
    public void updateFlightStartTime(FlightFlyTimeDTO flightFlyTimeDTO) {
        if (flightFlyTimeDTO.getFlightId() == null){
            throw new FlightException("航班ID未填写");
        }
        if (flightFlyTimeDTO.getFlightNumber() == null){
            throw new FlightException("航班号未填写");
        }
        flightManageMapper.updateFlightStartTime(flightFlyTimeDTO);
    }
    /**
     * 根据航班号查询航班信息
     * @param flightNumber
     * @return
     */
    @Override
    public FlightVO getFlightByFlightNumber(String flightNumber) {

       FlightVO flightVO = flightManageMapper.getFlightByFlightNumber(flightNumber);
          if(flightVO == null){
              throw new FlightException("航班号不存在");
          }
          return flightVO;
    }

//    /**
//     * 航班的时间、地点、票量查询航班信息
//     * @param flightTouristSubmitOrderDTO
//     * @return
//     */
//    @Override
//    public FlightVO getFlightTimeLocationTicket(FlightTouristSubmitOrderDTO flightTouristSubmitOrderDTO) {
//        flightManageMapper.getFlightTimeLocationTicket(flightTouristSubmitOrderDTO);
//    }
}
