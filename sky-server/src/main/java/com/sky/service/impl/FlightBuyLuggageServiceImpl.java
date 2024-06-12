package com.sky.service.impl;

import com.sky.constant.MessageConstant;
import com.sky.dto.FlightUserMakeLuggageDTO;
import com.sky.dto.LuggageDTO;
import com.sky.entity.FlightLuggage;
import com.sky.exception.FlightLuggageException;
import com.sky.mapper.FlightBuyLuggageMapper;
import com.sky.mapper.FlightManageMapper;
import com.sky.mapper.FlightOrderMapper;
import com.sky.mapper.FlightUserAndPwdMapper;
import com.sky.service.FlightBuyLuggageService;
import com.sky.vo.FlightOrderVO;
import com.sky.vo.FlightUserVO;
import com.sky.vo.FlightVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class FlightBuyLuggageServiceImpl implements FlightBuyLuggageService {
    @Autowired
    private FlightBuyLuggageMapper flightBuyLuggageMapper;
    @Autowired
    private FlightOrderMapper flightOrderMapper;
    @Autowired
    private FlightManageMapper flightManageMapper;
    @Autowired
    private FlightUserAndPwdMapper flightUserAndPwdMapper;
    /**
     * 购买行李
     * @param flightUserMakeLuggageDTO
     */
    @Override
    public void buyLuggage(FlightUserMakeLuggageDTO flightUserMakeLuggageDTO) {
        FlightLuggage flightLuggage = new FlightLuggage();
       //第一种订购方式：订单id和乘客的真实姓名进行购买行李
        if(flightUserMakeLuggageDTO.getOrderId() != null && flightUserMakeLuggageDTO.getRealName() != null) {
            FlightUserVO flightUserVO;
            FlightOrderVO flightOrderVO;
            try {
                flightOrderVO = flightOrderMapper.getOrderById(flightUserMakeLuggageDTO.getOrderId());
              flightUserVO= flightUserAndPwdMapper.getUserMessage(flightUserMakeLuggageDTO.getRealName());
                flightOrderVO.getOrderId();
                String realName = flightUserVO.getRealName();
                log.info("真实姓名：{}",realName);
                Integer flightId = flightOrderVO.getFlightId();
                flightLuggage.setOrderId(flightOrderVO.getOrderId());
                flightLuggage.setFlightId(flightId);
                String contactName = flightOrderVO.getContactName();
                log.info("姓名：{}",contactName);

            } catch (Exception e) {
                throw new FlightLuggageException(MessageConstant.ORDER_ID_OR_REAL_NAME_NULL);
            }

            if (!flightOrderVO.getContactName().equals(flightUserVO.getRealName())){
                throw new FlightLuggageException("用户名输入错误");
            }

        }else if (flightUserMakeLuggageDTO.getPersonId() != null && flightUserMakeLuggageDTO.getRealName() != null){
            //第二种订购方式：乘客的personId身份证号和乘客的真实姓名进行购买行李
            FlightOrderVO flightOrderVO;
            FlightUserVO flightUserVO;
            try {
                flightOrderVO = flightOrderMapper.getOrderByPersonId(flightUserMakeLuggageDTO.getPersonId());
                flightUserVO= flightUserAndPwdMapper.getUserMessage(flightUserMakeLuggageDTO.getRealName());
                //检验订单里面存在该用户的身份证号码和真实姓名
                flightOrderVO.getPersonId();
                flightUserVO.getRealName();
                Integer flightId = flightOrderVO.getFlightId();
                flightLuggage.setOrderId(flightOrderVO.getOrderId());
                flightLuggage.setFlightId(flightId);
            } catch (Exception e) {
                throw new FlightLuggageException(MessageConstant.ORDER_ID_OR_REAL_NAME_NULL);
            }
            if (!flightOrderVO.getContactName().equals(flightUserVO.getRealName())){
                throw new FlightLuggageException("用户名输入错误");
            }
        }
        flightLuggage.setStatue("运输中");
        flightLuggage.setLocation("运输中");
        flightBuyLuggageMapper.buyLuggage(flightLuggage);
    }

    /**
     * 查看行李信息
     * @param luggageId
     * @return
     */
    @Override
    public FlightLuggage getLuggage(Integer luggageId) {

        return flightBuyLuggageMapper.getLuggage(luggageId);

    }
}
