package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;

import com.sky.dto.FlightUserPageQueryDTO;

import com.sky.entity.FlightUser;
import com.sky.enumeration.OperationType;
import com.sky.vo.FlightUserVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface FlightUserMapper {
    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    @Select("select * from user where user_name = #{userName}")
    FlightUser getByUsername(String userName);

    /**
     * 注册新的用户账号
     * @param flightUser
     */
    @Insert("insert into user (user_id, user_name, user_pwd, real_name, user_phone, user_sex, user_identity, user_status) values (#{userId}, #{userName}, #{userPwd}, #{realName}, #{userPhone}, #{userSex}, #{userIdentity}, #{userStatus})")

//    @AutoFill(value = OperationType.INSERT)
    void insert(FlightUser flightUser);

    /**
     * 分页查询
     * @param flightUserPageQueryDTO
     * @return
     */
    Page<FlightUser> pageQuery(FlightUserPageQueryDTO flightUserPageQueryDTO);

    /**
     * 根据主键动态修改属性
     * @param flightUser
     */
//    @AutoFill(value = OperationType.UPDATE)
    void update(FlightUser flightUser);

    /**
     * 根据userId查询用户信息
     * @param userId
     * @return
     */
    @Select("select * from user where user_id = #{userId}")
    FlightUser getById(Integer userId);
}
