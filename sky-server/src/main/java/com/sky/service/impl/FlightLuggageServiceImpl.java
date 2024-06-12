package com.sky.service.impl;


import com.sky.constant.MessageConstant;
import com.sky.dto.FlightmakeLuggageDTO;
import com.sky.dto.LuggageDTO;
import com.sky.entity.FlightLuggage;
import com.sky.exception.FlightLuggageException;
import com.sky.mapper.FlightLuggageMapper;
import com.sky.mapper.FlightOrderMapper;
import com.sky.mapper.FlightUserAndPwdMapper;
import com.sky.service.FlightLuggageService;
import com.sky.vo.LuggageVO;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightLuggageServiceImpl  implements FlightLuggageService {
   @Autowired
   private FlightLuggageMapper flightLuggageMapper;
   @Autowired
   private FlightOrderMapper flightOrderMapper;
    @Autowired
    private FlightUserAndPwdMapper flightUserAndPwdMapper;
    /**
     * 查看行李
     * @param luggageDTO
     * @return
     */
    @Override
    public List<LuggageVO> showLuggage(LuggageDTO luggageDTO) {
            List<LuggageVO> list = flightLuggageMapper.showLuggage(luggageDTO);
        return list;
    }
    /**
     * 根据行李ID查看行李
     * @param luggageId
     * @return
     */
    @Override
    public List<LuggageVO> getLuggageById( Integer luggageId) {
        List<LuggageVO> list = flightLuggageMapper.getLuggageById(luggageId);
        return list;
    }

    /**
     * 删除行李
     */
    public void deleteLuggage(  Integer luggageId){
        LuggageDTO luggageDTO = new LuggageDTO();
        luggageDTO.setLuggageId(luggageId);
        List<LuggageVO> list = flightLuggageMapper.showLuggage(luggageDTO);
        if(list.get(0).getStatue() == "已登机" || list.get(0).getLocation().contains("登机口")) {
            throw new FlightLuggageException(MessageConstant.LUGGAGE_IN);
        }else{
            flightLuggageMapper.deleteLuggage(luggageId);
        }
    }

    /**
     * 更改行李的状态和位置
     * @param luggageDTO
     */
    @Override
    public void updateLuggage(LuggageDTO luggageDTO) {

        //判断行李ID是否存在
          try {
              flightLuggageMapper.getLuggageById(luggageDTO.getLuggageId()).get(0);
          }catch (Exception e){
              throw new FlightLuggageException(MessageConstant.LUGGAGE_NO_EXIST);
           }

           flightLuggageMapper.updateLuggage(luggageDTO);

    }



    /**
     * 添加行李
     * @param luggageDTO1
     */
    @Override
    public void makeLuggage(FlightmakeLuggageDTO flightmakeLuggageDTO) {
    if( flightmakeLuggageDTO.getPersonId() == null ){
        throw new FlightLuggageException("旅客的身份证未填写");
    }
    if(flightOrderMapper.getOrderByPersonId(flightmakeLuggageDTO.getPersonId()) == null){
        throw new FlightLuggageException("旅客的身份证号输入错误或该旅客没有相关的订单，不能购买行李");
    }

    if (flightmakeLuggageDTO.getOrderId() == null){
        //查询订单id
        Integer orderId = flightOrderMapper.getOrderByPersonId(flightmakeLuggageDTO.getPersonId()).getOrderId();
        flightmakeLuggageDTO.setOrderId(orderId);
    }
    //查询航班id
        Integer flightId = flightOrderMapper.getOrderByPersonId(flightmakeLuggageDTO.getPersonId()).getFlightId();

        FlightLuggage flightLuggage = new FlightLuggage();
        BeanUtils.copyProperties(flightmakeLuggageDTO,flightLuggage);
       flightLuggage.setFlightId(flightId);
        flightLuggage.setStatue("运输中");
        flightLuggage.setLocation("运输中");


       flightLuggageMapper.makeLuggage(flightLuggage);
    }


}
