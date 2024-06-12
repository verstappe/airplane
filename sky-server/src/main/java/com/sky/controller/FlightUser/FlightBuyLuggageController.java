package com.sky.controller.FlightUser;

import com.sky.dto.FlightUserMakeLuggageDTO;
import com.sky.dto.LuggageDTO;
import com.sky.entity.FlightLuggage;
import com.sky.result.Result;
import com.sky.service.FlightBuyLuggageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tourist1/FlightBuyLuggageController")
@Api(tags = "旅客行李接口")
public class FlightBuyLuggageController {
    @Autowired
    private FlightBuyLuggageService flightBuyLuggageService;
    /**
     * 购买行李
     */
    @PostMapping
    @ApiOperation("购买行李")
    public Result buyLuggage(@RequestBody FlightUserMakeLuggageDTO flightUserMakeLuggageDTO){
        flightBuyLuggageService.buyLuggage(flightUserMakeLuggageDTO);
        return Result.success();
    }
    /**
     * 查看行李信息
     */
    @GetMapping("/{luggageId}")
    @ApiOperation("查看行李信息")
    public Result<FlightLuggage> getLuggage(@PathVariable Integer luggageId){
       FlightLuggage luggage =  flightBuyLuggageService.getLuggage(luggageId);
        return Result.success(luggage);
    }

}
