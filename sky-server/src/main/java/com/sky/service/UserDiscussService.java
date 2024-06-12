package com.sky.service;

import com.sky.dto.FlightAddDiscussDTO;
import com.sky.dto.FlightDiscussDTO;
import org.springframework.stereotype.Service;


@Service
public interface UserDiscussService {
    /**
     * 添加评论信息
     * @param flightAddDiscussDTO
     */
    void addDiscuss(FlightAddDiscussDTO flightAddDiscussDTO);

    /**
     * 修改评论信息
     * @param flightAddDiscussDTO
     */
    void updateDiscuss(FlightAddDiscussDTO flightAddDiscussDTO);
}
