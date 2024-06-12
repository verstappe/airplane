package com.sky.service;

import com.sky.dto.FlightDiscussDTO;
import com.sky.result.PageResult;

import java.util.List;


public interface FlightDiscussService {
    /**
     * 删除评论
     * @param ids
     */
    void deleteUserDiscussByIds(List<Integer> ids);

    /**
     * 根据评论日期来查询评论
     * @param flightDiscussDTO
     * @return
     */
    PageResult getDiscussByDateOrUser(FlightDiscussDTO flightDiscussDTO);
}
