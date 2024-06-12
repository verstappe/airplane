package com.sky.service;

import com.sky.dto.FlightUserAndPwdDTO;
import com.sky.entity.FlightUser;
import com.sky.result.PageResult;
import com.sky.vo.FlightUserVO;
import io.swagger.models.auth.In;

import java.util.List;


public interface FlightUserAndPwdService {
    /**
     * 删除用户信息表
     */
    public void deleteBySelectIds(List<Integer> userIds);

    /**
     * 用户搜索
     * @param flightUserAndPwdDTO
     */
    PageResult searchUserMessage(FlightUserAndPwdDTO flightUserAndPwdDTO);

    /**
     * 根据用户的真实姓名来查询用户信息
     * @param realName
     * @return
     */
    FlightUserVO getUserMessage(String realName);
}
