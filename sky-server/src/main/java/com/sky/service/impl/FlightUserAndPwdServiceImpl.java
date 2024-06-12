package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.controller.FlightManage.FlightUserAndPwd;
import com.sky.dto.FlightUserAndPwdDTO;
import com.sky.entity.FlightUser;
import com.sky.mapper.FlightUserAndPwdMapper;
import com.sky.result.PageResult;
import com.sky.service.FlightOrderService;
import com.sky.service.FlightUserAndPwdService;
import com.sky.vo.FlightOrderVO;
import com.sky.vo.FlightUserAndPwdVO;
import com.sky.vo.FlightUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 林先生
 * @version 1.0
 */
@Service
public class FlightUserAndPwdServiceImpl implements FlightUserAndPwdService {

    @Autowired
    private FlightUserAndPwdMapper flightUserAndPwdMapper;
    @Override
    public void deleteBySelectIds(List<Integer> userIds) {
        for(Integer id:userIds) {

            flightUserAndPwdMapper.deleteBySelectId(id);
        }
    }

    /**
     * 用户搜索
     * @param flightUserAndPwdDTO
     */
    @Override
    public PageResult searchUserMessage(FlightUserAndPwdDTO flightUserAndPwdDTO) {
        PageHelper.startPage(flightUserAndPwdDTO.getPageNum(),flightUserAndPwdDTO.getPageSize());
        Page<FlightUserAndPwdVO> page = flightUserAndPwdMapper.searchUserMessage(flightUserAndPwdDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 根据用户的真实姓名来查询用户信息
     * @param realName
     * @return
     */
    @Override
    public FlightUserVO getUserMessage(String realName) {
        FlightUserVO flightUser = flightUserAndPwdMapper.getUserMessage(realName);
        return flightUser;
    }
}
