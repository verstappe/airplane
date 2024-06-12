package com.sky.service;

import com.sky.dto.FlightContentDTO;
import com.sky.result.PageResult;

import java.util.List;


public interface FlightContentService {
    /**
     * 添加广告信息
     * @param flightContentDTO
     */
    void save(FlightContentDTO flightContentDTO);

    /**
     * 删除广告信息
     * @param contentIds
     */
    void deleteContentById(List<Integer> contentIds);

    /**
     * 查询广告信息
     * @param flightContentDTO
     * @return
     */

    PageResult getContent(FlightContentDTO flightContentDTO);
}
