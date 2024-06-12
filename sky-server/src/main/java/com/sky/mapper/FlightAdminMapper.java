package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.FlightAdminDTO;
import com.sky.dto.FlightContentDTO;
import com.sky.vo.FlightAdminVO;
import com.sky.vo.FlightContentVO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface FlightAdminMapper {
    /**
     * 查看管理端的信息
     */
    Page<FlightAdminVO> getAdmin(FlightAdminDTO flightAdminDTO);

    /**
     * 修改管理端用户的信息
     * @param flightAdminDTO
     */
    void updateAdmin(FlightAdminDTO flightAdminDTO);
}
