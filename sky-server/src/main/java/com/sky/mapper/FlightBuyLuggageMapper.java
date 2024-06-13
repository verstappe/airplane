package com.sky.mapper;

import com.sky.dto.LuggageDTO;
import com.sky.entity.FlightLuggage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FlightBuyLuggageMapper {
    /**
     * 购买行李
     * @param flightLuggage
     */
    void buyLuggage(FlightLuggage flightLuggage);

    /**
     * 查看行李信息
     * @param luggageId
     * @return
     */
    @Select("select * from luggage where luggage_id = #{luggageId};")
    FlightLuggage getLuggage(Integer luggageId);

}
