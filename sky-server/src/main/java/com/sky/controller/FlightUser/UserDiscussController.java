package com.sky.controller.FlightUser;

import com.sky.dto.FlightAddDiscussDTO;
import com.sky.dto.FlightDiscussDTO;
import com.sky.result.Result;
import com.sky.service.FlightDiscussService;
import com.sky.service.UserDiscussService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tourist/Discuss")
@Api(tags = "乘客评论")
public class UserDiscussController {
    @Autowired
    private UserDiscussService userDiscussService;
    @Autowired
    private FlightDiscussService flightDiscussService;
    /**
     * 添加评论信息
     */
    @PostMapping
    @ApiOperation("添加评论信息")
    public Result addDiscuss(@RequestBody FlightAddDiscussDTO flightAddDiscussDTO){
        userDiscussService.addDiscuss(flightAddDiscussDTO);
        return Result.success();
    }
    /**
     * 修改评论信息
     */
    @PutMapping
    @ApiOperation("修改评论信息")
    public Result updateDiscuss(@RequestBody FlightAddDiscussDTO flightAddDiscussDTO){
        userDiscussService.updateDiscuss(flightAddDiscussDTO);
        return Result.success();
    }
    /**
     * 删除评论(ids)
     */
    @DeleteMapping
    @ApiOperation("删除评论信息")
    public Result deleteUserDiscussByIds(@RequestParam List<Integer> ids ){
        flightDiscussService.deleteUserDiscussByIds(ids);
        return Result.success();
    }

}
