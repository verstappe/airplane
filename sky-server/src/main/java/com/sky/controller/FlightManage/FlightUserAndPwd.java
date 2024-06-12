package com.sky.controller.FlightManage;

import com.github.pagehelper.Page;
import com.sky.dto.FlightUserAndPwdDTO;
import com.sky.entity.FlightUser;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.FlightUserAndPwdService;
import com.sky.vo.FlightUserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/manage/flightUserAndPwd")
@Api(tags = "乘客信息表")
public class FlightUserAndPwd {
    @Autowired
    private FlightUserAndPwdService flightUserAndPwdService;


    /**
     *删除用户信息表
     */
    @DeleteMapping
    @ApiOperation("删除用户信息表")
    public Result deleteBySelectIds(@RequestParam List<Integer> userIds){
        flightUserAndPwdService.deleteBySelectIds(userIds);
        return Result.success();
    }

    /**
     * 用户搜索
     */
    @GetMapping
    @ApiOperation("用户搜索")
    public Result<PageResult> searchUserMessage(@RequestBody FlightUserAndPwdDTO flightUserAndPwdDTO){
        PageResult pageResult = flightUserAndPwdService.searchUserMessage(flightUserAndPwdDTO);
        return Result.success(pageResult);
    }

    /**
     * 根据用户的真实姓名来查询用户信息
     */
    @GetMapping("/realname")
    @ApiOperation("根据用户的真实姓名来查询用户信息")
    public Result<FlightUserVO> getUserMessage(@RequestParam String realName ){
        FlightUserVO flightUser = flightUserAndPwdService.getUserMessage(realName);
        return  Result.success(flightUser);
    }

}
