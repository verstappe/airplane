package com.sky.mapper;

import com.sky.dto.FlightFlyTimeDTO;
import com.sky.dto.FlightNumberDTO;
import com.sky.dto.FlightPriceDTO;
import com.sky.dto.FlightTouristSubmitOrderDTO;
import com.sky.entity.Flight;
import com.sky.vo.FlightVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface FlightManageMapper {
    /**
     * 新增航班信息
     * @param flight
     * @return
     */
    void addFlight(Flight flight);

    /**
     * 修改航班信息
     * @param flight
     */
    void updateFlight(Flight flight);

    /**
     * 根据id查询航班信息
     * @param flightId
     */
    @Select("select * from flight where flight_id = #{flightId}")
    FlightVO getFlight(Integer flightId);

    /**
     *根据id删除航班信息
     * @param flightId
     */
    @Delete("delete from flight where flight_id = #{flightId}")
    void deleteFlight(Integer flightId);

    /**
     * 根据地点始终，机场始终，时间查询航班信息
     */

    List<FlightVO> getFlightMessage(Flight flight);

    Flight getFlightMessage1(Flight flight);

    /**
     * 修改航班的舱位的价位
     * @param flightPriceDTO
     * @return
     */
    void updateFlightPrice(FlightPriceDTO flightPriceDTO);

    /**
     * 修改航班的各舱位的座位数量
     * @param flightNumberDTO
     * @return
     */
    void updateFlightStatusNumber(FlightNumberDTO flightNumberDTO);
    /**
     * 修改航班的起始时间
     * @param flightFlyTimeDTO
     * @return
     */
    void updateFlightStartTime(FlightFlyTimeDTO flightFlyTimeDTO);


    /**
     * 根据航班号查询航班信息
     * @param flightNumber
     * @return
     */
    FlightVO getFlightByFlightNumber(String flightNumber);

//    /**
//     * 航班的时间、地点、票量查询航班信息
//     * @param flightTouristSubmitOrderDTO
//     */
//    void getFlightTimeLocationTicket(FlightTouristSubmitOrderDTO flightTouristSubmitOrderDTO);
}
