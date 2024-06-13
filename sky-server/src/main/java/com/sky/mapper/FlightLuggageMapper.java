package com.sky.mapper;

import com.sky.dto.LuggageDTO;
import com.sky.dto.LuggageGetDTO;
import com.sky.entity.FlightLuggage;
import com.sky.vo.LuggageVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FlightLuggageMapper {
    /**
     * 查看行李
     * @param luggage
     * @return
     */
    List<LuggageVO> showLuggage(LuggageGetDTO luggage);

    /**
     * 删除行李
     * @param luggageId
     */
    @Delete("delete from luggage where luggage_id = #{luggageId}")
    void deleteLuggage(Integer luggageId);


    /**
     * 更改行李的状态和位置
     * @param luggageDTO
     */
    void updateLuggage(LuggageDTO luggageDTO);

    /**
     * 添加行李
     * @param flightLuggage
     */
    void makeLuggage(FlightLuggage flightLuggage);

    /**
     * 根据行李ID查看行李
     * @param luggageId
     * @return
     */
    @Select("select * from luggage where luggage_id = #{luggageId}")
    List<LuggageVO> getLuggageById(Integer luggageId);
}
