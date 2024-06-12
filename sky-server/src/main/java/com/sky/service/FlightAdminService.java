package com.sky.service;

import com.sky.dto.FlightAdminDTO;
import com.sky.result.PageResult;

public interface FlightAdminService {
    /**
     *查看管理端的信息
     */
    PageResult getAdmin(FlightAdminDTO flightAdminDTO);

    /**
     * 修改管理端用户的信息
     * @param flightAdminDTO
     */
    void updateAdmin(FlightAdminDTO flightAdminDTO);
}
