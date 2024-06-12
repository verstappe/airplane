package com.sky.controller.FlightManage;



import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.*;
import com.sky.entity.FlightUser;
import com.sky.properties.JwtProperties;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.FlightUserService;
import com.sky.utils.JwtUtil;

import com.sky.vo.FlightUserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/manage/adminManageUser")
@Slf4j
@Api(tags = "管理乘客相关接口")
public class FlightAdminManageUserController {
    @Autowired
    private FlightUserService flightUserService;


    /**
     * 用户分页查询
     * @param flightUserPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("用户分页查询")
    public Result<PageResult> page(@RequestBody FlightUserPageQueryDTO flightUserPageQueryDTO){
        log.info("用户分页查询，参数为：{}", flightUserPageQueryDTO);
        PageResult pageResult = flightUserService.pageQuery(flightUserPageQueryDTO);
        return Result.success(pageResult);
    }


    /**
     * 启用禁用用户账号
     * @param userStatus
     * @param userId
     * @return
     */
    @PostMapping("/userStatus/{userStatus}")
    @ApiOperation("启用禁用用户账号")
    public Result startOrStop(@PathVariable Integer userStatus,@RequestParam Integer userId){
        log.info("启用禁用用户账号：{},{}",userStatus,userId);
        flightUserService.startOrStop(userStatus,userId);
        return Result.success();
    }

    /**
     * 根据userId查询员工信息
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    @ApiOperation("根据userId查询员工信息")
    public Result<FlightUser> getById(@PathVariable Integer userId){
        FlightUser flightUser = flightUserService.getById(userId);
        return Result.success(flightUser);
    }

    /**
     * 编辑用户信息
     * @param flightUserDTO
     * @return
     */
    @PutMapping
    @ApiOperation("编辑用户信息")
    public Result update(@RequestBody FlightUserDTO flightUserDTO){
        log.info("编辑用户信息：{}", flightUserDTO);
        flightUserService.update(flightUserDTO);
        return Result.success();
    }
}

