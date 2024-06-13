package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.dto.FlightAddDiscussDTO;
import com.sky.dto.FlightDiscussDTO;
import com.sky.entity.FlightDiscuss;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDiscussMapper {
    /**
     * 添加评论信息
     * @param flightDiscuss
     */
    void addDiscuss(FlightDiscuss flightDiscuss);

    /**
     * 修改评论信息
     * @param flightDiscuss
     */
    void updateDiscuss(FlightDiscuss flightDiscuss);

    /**
     * 修改评论信息(username和flightNumber和id)
     * @param flightDiscuss
     */
    void updateDiscussById(FlightDiscuss flightDiscuss);

    /**
     * 查询评论信息
     * @param id
     */
    FlightDiscuss selectDiscuss(Integer id);
}
