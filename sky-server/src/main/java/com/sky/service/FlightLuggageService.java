package com.sky.service;

import com.sky.dto.FlightmakeLuggageDTO;
import com.sky.dto.LuggageDTO;
import com.sky.dto.LuggageGetDTO;
import com.sky.vo.LuggageVO;

import java.util.List;


public interface FlightLuggageService {
    /**
     * 查看行李
     * @param luggageDTO
     * @return
     */
    List<LuggageVO> showLuggage(LuggageGetDTO luggageDTO);
    /**
     * 根据行李ID查看行李
     * @param luggageId
     * @return
     */
    List<LuggageVO> getLuggageById( Integer luggageId);
    /**
     * 删除行李
     */
    public void deleteLuggage( Integer luggageId);

    /**
     * 更改行李的状态和位置
     * @param luggageDTO
     */

    void updateLuggage(LuggageDTO luggageDTO);

    /**
     * 添加行李
     * @param luggageDTO
     */
    void makeLuggage(FlightmakeLuggageDTO luggageDTO);


}
