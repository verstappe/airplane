package com.sky.service.impl;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.constant.MessageConstant;
import com.sky.dto.FlightOrderDTO;
import com.sky.dto.FlightOrderUpdateDTO;
import com.sky.dto.FlightTouristSubmitOrderDTO;

import com.sky.entity.Flight;
import com.sky.entity.FlightOrder;
import com.sky.entity.FlightUser;
import com.sky.exception.FlightException;
import com.sky.exception.FlightTicketException;
import com.sky.mapper.FlightManageMapper;
import com.sky.mapper.FlightOrderMapper;
import com.sky.mapper.FlightUserAndPwdMapper;
import com.sky.result.PageResult;
import com.sky.service.FlightOrderService;
import com.sky.vo.FlightOrderVO;
import com.sky.vo.FlightTouristSubmitOrderVO;
import com.sky.vo.FlightVO;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 林先生
 * @version 1.0
 */
@Service
public class FlightOrderServiceImpl implements FlightOrderService {
    @Autowired
    private FlightOrderMapper flightOrderMapper;
    @Autowired
    private FlightUserAndPwdMapper flightUserAndPwdMapper;
    @Autowired
    private FlightManageMapper flightManageMapper;
    /**
     * 根据id查询订单信息
     * @param orderId
     * @return
     */
    @Override
    public FlightOrderVO getOrderById(Integer orderId) {
        return flightOrderMapper.getOrderById(orderId);
    }

    /**
     * 根据id删除订单信息
     */
    public void deleteOrderById(Integer orderId){
        flightOrderMapper.deleteOrderById(orderId);
    }

    /**
     * 根据id批量删除订单
     * @param orderIds
     */
    @Override
    public void deleteOrderByIds(List<Integer> orderIds) {
        flightOrderMapper.deleteOrderByIds(orderIds);
    }



    /**
     * 根据页码查询订单
     * @param flightOrderDTO
     */
    @Override
    public PageResult getOrderByPage(FlightOrderDTO flightOrderDTO) {

        PageHelper.startPage(flightOrderDTO.getPageNum(),flightOrderDTO.getPageSize());
        Page<FlightOrderVO> page = flightOrderMapper.getOrderByPage(flightOrderDTO);

        return new PageResult(page.getTotal(), page.getResult());

    }

    /**
     * 更改订单的日期(修改航班号,修改航班id,修改订单价钱)
     * @param flightOrderUpdateDTO
     */

    @Override
    public void updateOrderMessage(FlightOrderUpdateDTO flightOrderUpdateDTO) {
        if(flightOrderUpdateDTO.getFlightStartTime() == null ||  flightOrderUpdateDTO.getFlightStartTime().toString() == ""){
            throw new FlightTicketException("修改的航班起飞时间不能为空");
        }
        //查找旧的航班地点，时间，机场位置
        FlightOrderVO flightOrder = flightOrderMapper.getOrderById(flightOrderUpdateDTO.getOrderId());
        FlightVO flight1 = flightManageMapper.getFlight(flightOrder.getFlightId());

        //查找新的航班
        Flight flight = Flight.builder()
               .flightStartTime(flightOrderUpdateDTO.getFlightStartTime())
                .flightStartAirport(flight1.getFlightStartAirport())
                .flightEndAirport(flight1.getFlightEndAirport())
                .flightStartPlace(flight1.getFlightStartPlace())
                .flightEndPlace(flight1.getFlightEndPlace())
                .build();
       Flight flightMessage = flightManageMapper.getFlightMessage1(flight);
        FlightOrder flightOrder1 = new FlightOrder();
        BeanUtils.copyProperties(flightOrder,flightOrder1);
        flightOrder1.setFlightId(flightMessage.getFlightId());
        flightOrder1.setFlightNumber(flightMessage.getFlightNumber());
        //将更新过后的订单价增加25块钱
        Integer flightOrder2 = Integer.parseInt(flightOrder1.getOrderMoney()) + 25;
        String flightOrder3 = flightOrder2.toString();
        flightOrder1.setOrderMoney(flightOrder3);
        //设置用户的orderID和ordername
        flightOrder1.setOrderId(flightOrderUpdateDTO.getOrderId());
        flightOrder1.setOrderUser(flightOrderUpdateDTO.getOrderUser());
//        flightOrder1.setOrderDate(LocalDateTime.now());
        //更新
        flightOrderMapper.updateOrderMessage(flightOrder1);
    }

    /**
     * 删除订单(订单ID和订单用户是必填)
     * @param flightOrderDTO
     */
    @Override
    public void deleteOrder(FlightOrderDTO flightOrderDTO) {
        if(flightOrderDTO.getOrderId() == null ||  flightOrderDTO.getOrderId().toString() == ""){
            throw new FlightTicketException("订单Id不能为空");
        }
        if(flightOrderDTO.getOrderUser() == null ||  flightOrderDTO.getOrderUser().toString() == ""){
            throw new FlightTicketException("订单用户名不能为空");
        }

        flightOrderMapper.deleteOrder(flightOrderDTO);
    }

    /**
     * 订票
     * @param flightTouristSubmitOrderDTO
     */
    @Override
    public void makeOrder(FlightTouristSubmitOrderDTO flightTouristSubmitOrderDTO) {
        List<FlightTouristSubmitOrderVO> flightTouristSubmitOrderVO= flightOrderMapper.getFlightMessage(flightTouristSubmitOrderDTO);
        int flag = 0;
        for (FlightTouristSubmitOrderVO num: flightTouristSubmitOrderVO){
            String flightHighNumber =  num.getFlightHighNumber();
            String flightMiddleNumber = num.getFlightMiddleNumber();
            String flightBaseNumber = num.getFlightBaseNumber();
            if(flightHighNumber!="0" &&flightMiddleNumber!="0"&&flightBaseNumber!="0" ){
                flag = 1;
            }
            if (flag == 1){
                break;
            }
        }
        if (flag == 0){
            throw new FlightTicketException(MessageConstant.TICKET_NUMBER);
        }
        if(flag == 1){
            FlightOrder flightOrder = new FlightOrder();
            BeanUtils.copyProperties(flightTouristSubmitOrderDTO,flightOrder);
           if( flightUserAndPwdMapper.getUserMessage(flightOrder.getContactName()) != null ){
               throw new FlightTicketException("用户姓名填写错误");
           }
           if(flightManageMapper.getFlight(flightTouristSubmitOrderDTO.getFlightId()) == null){
               throw new FlightTicketException("机票ID不存在");
           }
            flightOrderMapper.insertTicketOrder(flightOrder);

        }
    }

}
