package com.sky.controller.FlightManage;

import com.sky.dto.FlightDiscussDTO;
import com.sky.dto.FlightOrderDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.FlightDiscussService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/manage/flightDiscuss")
@Api(tags = "评论接口")
public class FlightDiscuss {
    @Autowired
    FlightDiscussService flightDiscussService;

    /**
     * 删除评论
     */
    @DeleteMapping
    @ApiOperation("删除评论")
    public Result deleteUserDiscussByIds(@RequestParam List<Integer> ids ){
        flightDiscussService.deleteUserDiscussByIds(ids);
        return Result.success();
    }

    /**
     * 根据日期或者留言用户来查询
     *
     */
    @GetMapping
    @ApiOperation("根据日期或者留言用户来查询")
    public Result<PageResult> getDiscussByDateOrUser(@RequestBody FlightDiscussDTO flightDiscussDTO){
        PageResult pageResult = flightDiscussService.getDiscussByDateOrUser(flightDiscussDTO);
        return Result.success(pageResult);
    }
}
