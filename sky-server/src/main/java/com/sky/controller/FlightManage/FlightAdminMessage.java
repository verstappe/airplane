package com.sky.controller.FlightManage;

import com.sky.dto.FlightAdminDTO;
import com.sky.dto.FlightContentDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.FlightAdminService;
import com.sky.service.FlightContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manage/flightAdminMessage")
@Api(tags = "管理者")
public class FlightAdminMessage {
    @Autowired
    private FlightAdminService flightAdminService;

    /**
     * 查看管理端的信息
     * @param flightAdminDTO
     * @return
     */
    @GetMapping
    @ApiOperation("查看管理端的信息")
    public Result<PageResult> getAdmin(@RequestBody FlightAdminDTO flightAdminDTO){
        PageResult pageResult = flightAdminService.getAdmin(flightAdminDTO);
        return Result.success(pageResult);
    }
    /**
     * 修改管理端用户的信息
     */
    @PutMapping
    @ApiOperation("修改管理端用户的信息")
    public Result updateAdmin(@RequestBody FlightAdminDTO flightAdminDTO){
        flightAdminService.updateAdmin(flightAdminDTO);
        return Result.success();
    }
}
