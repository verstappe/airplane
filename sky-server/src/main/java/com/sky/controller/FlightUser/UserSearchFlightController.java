package com.sky.controller.FlightUser;

import com.sky.dto.UserSearchFlightPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.UserSearchFlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/tourist/flightMessage")
@Api(tags = "航班信息")
public class UserSearchFlightController {
    @Autowired
    private UserSearchFlightService userSearchFlightService;
//    /**
//     * 航班信息展示
//     */
//    @GetMapping
//    @ApiOperation("航班信息展示")
//    public Result<PageResult> getFlightMessage(@RequestBody UserSearchFlightPageQueryDTO userSearchFlightPageQueryDTO){
//        PageResult pageResult = userSearchFlightService.getFlightMessage(userSearchFlightPageQueryDTO);
//        return Result.success(pageResult);
//    }
    /**
     * 航班信息查询(起飞时间 或 起飞地点 或 到达地点)
     */
    @GetMapping("/searchFlightMessage")
    @ApiOperation("航班信息查询")
    public Result<PageResult> searchFlightMessage(@RequestBody UserSearchFlightPageQueryDTO userSearchFlightPageQueryDTO){
        PageResult pageResult = userSearchFlightService.getFlightMessage(userSearchFlightPageQueryDTO);
        return Result.success(pageResult);
    }


}
