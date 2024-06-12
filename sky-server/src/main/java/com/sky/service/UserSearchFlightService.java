package com.sky.service;


import com.sky.dto.UserSearchFlightPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.UserSearchFlightVO;

public interface UserSearchFlightService {

    /**
     * 航班信息展示
     */
    PageResult getFlightMessage(UserSearchFlightPageQueryDTO userSearchFlightPageQueryDTO);
}
