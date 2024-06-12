package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.dto.UserSearchFlightPageQueryDTO;
import com.sky.entity.Flight;
import com.sky.exception.FlightException;
import com.sky.mapper.UserSearchFlightMapper;
import com.sky.result.PageResult;
import com.sky.service.UserSearchFlightService;

import com.sky.vo.UserSearchFlightVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserSearchFlightServiceImpl implements UserSearchFlightService {

    @Autowired
    private UserSearchFlightMapper userSearchFlightMapper;
    /**
     * 航班信息查询(根据航班起飞时间和航班的起点和航班的终点)
     */
    @Override
    public PageResult getFlightMessage(UserSearchFlightPageQueryDTO userSearchFlightPageQueryDTO) {
        PageHelper.startPage(userSearchFlightPageQueryDTO.getPageNum(), userSearchFlightPageQueryDTO.getPageSize());
        if(userSearchFlightPageQueryDTO.getFlightEndPlace() == null || userSearchFlightPageQueryDTO.getFlightStartTime() == null || userSearchFlightPageQueryDTO.getFlightStartPlace() == null){
            throw new FlightException("日期未填写或开始地点或终点未填写");
        }
        Page<UserSearchFlightVO> page = userSearchFlightMapper.getFlightMessage(userSearchFlightPageQueryDTO);
        if(page == null){
            throw new FlightException("两地无航班飞行");
        }
        return new PageResult(page.getTotal(), page.getResult());

    }
}
