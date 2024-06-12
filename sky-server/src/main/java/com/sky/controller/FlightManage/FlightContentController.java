package com.sky.controller.FlightManage;

import com.sky.dto.FlightContentDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.FlightContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Api(tags = "广告接口")
@RequestMapping("/manage/flightContentController")
public class FlightContentController {
    @Autowired
    private FlightContentService flightContentService;
    /**
     * 添加广告信息
     */
    @PostMapping
    @ApiOperation("添加广告信息")
    public Result save(@RequestBody FlightContentDTO flightContentDTO){
        flightContentService.save(flightContentDTO);
        return Result.success();
    }
    /**
     * 删除广告信息
     */
    @DeleteMapping
    @ApiOperation("删除广告信息")
    public Result deleteContentById(@RequestParam List<Integer> contentIds){
        flightContentService.deleteContentById(contentIds);
        return Result.success();
    }

    /**
     * 查询广告
     */
    @GetMapping
    @ApiOperation("查询广告信息")
    public Result<PageResult> getContent(@RequestBody FlightContentDTO flightContentDTO){
        PageResult pageResult = flightContentService.getContent(flightContentDTO);
        return Result.success(pageResult);
    }
}
