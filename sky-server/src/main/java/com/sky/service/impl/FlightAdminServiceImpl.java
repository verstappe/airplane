package com.sky.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sky.dto.FlightAdminDTO;
import com.sky.mapper.FlightAdminMapper;
import com.sky.result.PageResult;
import com.sky.service.FlightAdminService;
import com.sky.vo.FlightAdminVO;
import com.sky.vo.FlightContentVO;
import com.sky.vo.FlightVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FlightAdminServiceImpl implements FlightAdminService {

    @Autowired
    private FlightAdminMapper flightAdminMapper;

    /**
     *查看管理端的信息
     * @param flightAdminDTO
     * @return
     */
    @Override
    public PageResult getAdmin(FlightAdminDTO flightAdminDTO) {
        PageHelper.startPage(flightAdminDTO.getPageNum(),flightAdminDTO.getPageSize());
        Page<FlightAdminVO> page = flightAdminMapper.getAdmin(flightAdminDTO);
        return new PageResult(page.getTotal(), page.getResult());
    }

    /**
     * 修改管理端用户的信息
     * @param flightAdminDTO
     */
    @Override
    public void updateAdmin(FlightAdminDTO flightAdminDTO) {
        flightAdminMapper.updateAdmin(flightAdminDTO);
    }
}
