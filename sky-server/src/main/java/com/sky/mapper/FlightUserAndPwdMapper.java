package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.FlightUserAndPwdDTO;
import com.sky.entity.FlightUser;
import com.sky.vo.FlightUserAndPwdVO;
import com.sky.vo.FlightUserVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface FlightUserAndPwdMapper {

    /**
     * 删除用户信息
     */
    @Delete("delete from user where user_id = #{userId} ")
    public void deleteBySelectId(Integer userId);

    /**
     * 用户搜索
     */
    Page<FlightUserAndPwdVO> searchUserMessage(FlightUserAndPwdDTO flightUserAndPwdDTO);


    /**
     *根据用户的真实姓名来查询用户信息
     * @param realName
     * @return
     */
    @Select("select * from user where real_name = #{realName}")
    FlightUserVO getUserMessage(String realName);

    /**
     * 根据用户名来查询用户信息
     */
    @Select("select * from user where user_name = #{userName}")
    FlightUserVO getUserMessageByuserName(String userName);
}
