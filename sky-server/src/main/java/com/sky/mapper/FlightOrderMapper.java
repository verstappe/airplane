package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.FlightOrderDTO;
import com.sky.dto.FlightOrderUpdateDTO;
import com.sky.dto.FlightTouristSubmitOrderDTO;
import com.sky.entity.Flight;
import com.sky.entity.FlightOrder;
import com.sky.enumeration.OperationType;
import com.sky.vo.FlightOrderVO;

import com.sky.vo.FlightTouristSubmitOrderVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 林先生
 * @version 1.0
 */
@Mapper
public interface FlightOrderMapper {

    /**
     * 根据乘客的身份证来查询订单
     */
    @Select("select * from flight_order where person_id = #{personId}")
    FlightOrderVO getOrderByPersonId(String personId);
    /**
     * 根据id查询订单信息
     * @param orderId
     * @return
     */
    @Select("select * from flight_order where order_id = #{orderId}")
    FlightOrderVO getOrderById(Integer orderId);

    /**
     * 根据id删除订单信息
     * @param orderId
     */
    @Delete("delete from flight_order where order_id = #{orderId}")
    void deleteOrderById(Integer orderId);

    /**
     *根据id批量删除订单
     * @param orderIds
     */
    void deleteOrderByIds(List<Integer> orderIds);


    /**
     * 根据页码查询页码
     * @param flightOrderDTO
     */
    Page<FlightOrderVO> getOrderByPage(FlightOrderDTO flightOrderDTO);

    /**
     * 更改订单的日期
     * @param flightOrder1
     */
    @AutoFill(value = OperationType.UPDATE)
    void updateOrderMessage( FlightOrder flightOrder1);

    /**
     * 退票
     * @param flightOrderDTO
     */
    void deleteOrder(FlightOrderDTO flightOrderDTO);

    /**
     * 订票
     * @param flightTouristSubmitOrderDTO
     * @return
     */
    List<FlightTouristSubmitOrderVO> getFlightMessage(FlightTouristSubmitOrderDTO flightTouristSubmitOrderDTO);

    @AutoFill(value = OperationType.INSERT)
    void insertTicketOrder(FlightOrder flightOrder);
}
