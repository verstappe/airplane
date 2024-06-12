package com.sky.service;


import com.sky.dto.FlightUserMakeLuggageDTO;
import com.sky.dto.LuggageDTO;
import com.sky.entity.FlightLuggage;

public interface FlightBuyLuggageService {
    /**
     * 购买行李
     * @param luggageDTO
     */
    void buyLuggage(FlightUserMakeLuggageDTO flightUserMakeLuggageDTO);

    /**
     * 查看行李信息
     * @param luggageId
     * @return
     */
    FlightLuggage getLuggage(Integer luggageId);
}
