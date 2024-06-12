package com.sky.controller.FlightManage;

import com.sky.dto.FlightmakeLuggageDTO;
import com.sky.dto.LuggageDTO;
import com.sky.result.Result;
import com.sky.service.FlightLuggageService;
import com.sky.vo.LuggageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage/flightManageLuggage")
@Api(tags = "管理行李")
public class FlightManageLuggageController {
    @Autowired
    private FlightLuggageService flightLuggageService;
    /**
     * 查看行李
     */
    @GetMapping("/list")
    @ApiOperation("查看行李")
    public Result<List<LuggageVO>> list(@RequestBody LuggageDTO luggageDTO ){
        List<LuggageVO> list = flightLuggageService.showLuggage(luggageDTO);
        return Result.success(list);
    }

    /**
     * 根据行李ID查看行李
     * @param luggageId
     * @return
     */
    @GetMapping("/{luggageId}")
    @ApiOperation("根据行李ID查看行李")
    public List<LuggageVO> getLuggageById(@PathVariable Integer luggageId ){
        List<LuggageVO> list = flightLuggageService.getLuggageById(luggageId);
        return list;
    }
    /**
     * 删除行李
     */
    @DeleteMapping
    @ApiOperation("删除行李")
    public Result deleteLuggage(@RequestParam Integer luggageId ){
        flightLuggageService.deleteLuggage(luggageId);
        return Result.success();
    }

    /**
     * 更改行李的状态和位置
     * @param luggageDTO
     */
    @PutMapping
    @ApiOperation("更改行李的状态和位置")
    public Result updateLuggage(@RequestBody LuggageDTO luggageDTO ){
        flightLuggageService.updateLuggage(luggageDTO);
        return Result.success();
    }

    /**
     * 添加行李
     * @param luggageDTO
     */
    @PostMapping
    @ApiOperation("添加行李")
    public Result makeLuggage(@RequestBody FlightmakeLuggageDTO luggageDTO){
        flightLuggageService.makeLuggage(luggageDTO);
        return Result.success();
    }

}
