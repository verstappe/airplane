package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.FlightContentDTO;
import com.sky.vo.FlightContentVO;
import com.sky.vo.FlightDiscussVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface FlightContentMapper {
    /**
     * 添加广告信息
     * @param flightContentDTO
     */
    void save(FlightContentDTO flightContentDTO);

    /**
     * 删除广告信息
     * @param contentId
     */
    @Delete("delete from content where content_id = #{contentId}")
    void deleteContentById(Integer contentId);

    /**
     * 查询广告信息
     * @param flightContentDTO
     * @return
     */
    Page<FlightContentVO> getContent(FlightContentDTO flightContentDTO);
}
