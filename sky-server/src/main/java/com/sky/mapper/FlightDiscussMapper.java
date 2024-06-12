package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.FlightDiscussDTO;
import com.sky.vo.FlightDiscussVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FlightDiscussMapper {
    /**
     * 删除评论
     * @param id
     */
    @Delete("delete from discuss where id = #{id}")
    void deleteUserDidcussById(Integer id);

    /**
     * 根据日期或者留言用户来查询
     * @param flightDiscussDTO
     * @return
     */
    Page<FlightDiscussVO> getDiscussByDateOrUser(FlightDiscussDTO flightDiscussDTO);
}
