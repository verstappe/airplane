package com.sky.service;

import com.sky.dto.*;

import com.sky.entity.FlightUser;
import com.sky.result.PageResult;
import io.swagger.models.auth.In;


public interface FlightUserService {

    /**
     * 用户登录
     * @param flightUserLoginDTO
     * @return
     */
    FlightUser login(FlightUserLoginDTO flightUserLoginDTO);
    /**
     * 注册用户账号
     * @param flightUserDTO
     */
    void save(FlightUserDTO flightUserDTO);

    /**
     * 分页查询
     * @param flightUserPageQueryDTO
     * @return
     */
    PageResult pageQuery(FlightUserPageQueryDTO flightUserPageQueryDTO);

    /**
     * 启用禁用员工账号
     * @param userStatus
     * @param userId
     */
    void startOrStop(Integer userStatus, Integer userId);

    /**
     * 根据userId查询用户
     * @param userId
     * @return
     */
    FlightUser getById(Integer userId);

    /**
     * 编辑用户信息
     * @param flightUserDTO
     */
    void update(FlightUserDTO flightUserDTO);
}
