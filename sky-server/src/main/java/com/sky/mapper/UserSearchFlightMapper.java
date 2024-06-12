package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.UserSearchFlightPageQueryDTO;
import com.sky.vo.UserSearchFlightVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserSearchFlightMapper {
    /**
     * 航空信息查询
     */
   // @Select("select * from flight where flight_id = #{flightId} ")

    Page<UserSearchFlightVO> getFlightMessage(UserSearchFlightPageQueryDTO userSearchFlightPageQueryDTO);
}
