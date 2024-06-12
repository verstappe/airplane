package com.sky.service.impl;


import com.sky.dto.FlightAddDiscussDTO;
import com.sky.dto.FlightDiscussDTO;
import com.sky.entity.FlightDiscuss;
import com.sky.exception.FlightDiscussException;
import com.sky.exception.FlightException;
import com.sky.mapper.FlightUserAndPwdMapper;
import com.sky.mapper.UserDiscussMapper;
import com.sky.service.UserDiscussService;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;

@Service
public class UserDiscussServiceImpl implements UserDiscussService {
    @Autowired
    private UserDiscussMapper userDiscussMapper;
    @Autowired
    private FlightUserAndPwdMapper flightUserAndPwdMapper;
    /**
     * 添加评论信息
     * @param flightAddDiscussDTO
     */
    @Override
    public void addDiscuss(FlightAddDiscussDTO flightAddDiscussDTO) {
        if (flightAddDiscussDTO.getUserName() == null){
            throw new FlightDiscussException("用户名不能为空");
        }
        if (flightAddDiscussDTO.getMessageContent() == null){
            throw new FlightDiscussException("内容不能为空");
        }
        if (flightAddDiscussDTO.getFlightNumber() == null){
            throw new FlightDiscussException("航班号不能为空");
        }

         Integer userId = flightUserAndPwdMapper.getUserMessageByuserName(flightAddDiscussDTO.getUserName()).getUserId();
        FlightDiscuss flightDiscuss = new FlightDiscuss();
        BeanUtils.copyProperties(flightAddDiscussDTO,flightDiscuss);
        flightDiscuss.setUserId(userId);
        flightDiscuss.setTime(LocalDateTime.now());
        userDiscussMapper.addDiscuss(flightDiscuss);
    }

    /**
     * 修改评论信息
     * @param flightAddDiscussDTO
     */
    @Override
    public void updateDiscuss(FlightAddDiscussDTO flightAddDiscussDTO) {
        if (flightAddDiscussDTO.getUserName() == null){
            throw new FlightDiscussException("用户名不能为空");
        }
        if (flightAddDiscussDTO.getMessageContent() == null){
            throw new FlightDiscussException("内容不能为空");
        }
        if (flightAddDiscussDTO.getFlightNumber() == null){
            throw new FlightDiscussException("航班号不能为空");
        }
        Integer userId = flightUserAndPwdMapper.getUserMessageByuserName(flightAddDiscussDTO.getUserName()).getUserId();
        FlightDiscuss flightDiscuss = new FlightDiscuss();
        BeanUtils.copyProperties(flightAddDiscussDTO,flightDiscuss);
        flightDiscuss.setTime(LocalDateTime.now());
        flightDiscuss.setUserId(userId);
        //是否填写discuss的id
        if(flightDiscuss == null) {
            userDiscussMapper.updateDiscuss(flightDiscuss);
        }else {
            userDiscussMapper.updateDiscussById(flightDiscuss);
        }

    }
}
