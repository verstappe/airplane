package com.sky.service;

import com.sky.dto.FlightOrderDTO;
import com.sky.dto.FlightOrderUpdateDTO;
import com.sky.dto.FlightTouristSubmitOrderDTO;
import com.sky.entity.FlightOrder;
import com.sky.result.PageResult;
import com.sky.vo.FlightOrderVO;

import java.util.List;


public interface FlightOrderService {
    /**
     * 根据id查询订单信息
     */
    public FlightOrderVO getOrderById(Integer orderId);

    /**
     * 根据id删除订单信息
     */
    public void deleteOrderById(Integer orderId);

    /**
     * 根据id批量删除订单
     * @param orderIds
     */
    void deleteOrderByIds(List<Integer> orderIds);

    /**
     * 根据页码查询页码
     * @param flightOrderDTO
     */
    PageResult getOrderByPage(FlightOrderDTO flightOrderDTO);

    /**
     * 更改订单的日期
     * @param flightOrderUpdateDTO
     */
    void updateOrderMessage(FlightOrderUpdateDTO flightOrderUpdateDTO);

    /**
     * 退票
     * @param flightOrderDTO
     */
    void deleteOrder(FlightOrderDTO flightOrderDTO);

    /**
     * 订票
     * @param flightTouristSubmitOrderDTO
     */
    void makeOrder(FlightTouristSubmitOrderDTO flightTouristSubmitOrderDTO);


}
