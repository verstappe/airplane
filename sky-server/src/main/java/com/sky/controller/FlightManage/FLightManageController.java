package com.sky.controller.FlightManage;



import com.sky.dto.FlightFlyTimeDTO;
import com.sky.dto.FlightNumberDTO;
import com.sky.dto.FlightPriceDTO;
import com.sky.dto.FlightTouristSubmitOrderDTO;
import com.sky.entity.Flight;
import com.sky.result.Result;
import com.sky.service.FlightManageService;
import com.sky.vo.FlightVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage/flightManage")
@Slf4j
@Api(tags = "航班接口")
public class FLightManageController {
    @Autowired
    private FlightManageService flightManageService;
    /**
     * 新增航班信息
     * @param flight
     * @return
     */
    @PostMapping
    @ApiOperation("新增航班信息")
    public Result addFlight(@RequestBody Flight flight) {
        log.info("新增航班信息：{}", flight);
        flightManageService.addFlight(flight);
        return Result.success();
    }

    /**
     * 修改航班的舱位的价位
     * @param flightPriceDTO
     * @return
     */
    @PutMapping("/updateFlightPrice")
    @ApiOperation("修改航班的舱位的价位")
    public Result updateFlightPrice(@RequestBody FlightPriceDTO flightPriceDTO) {
        log.info("修改航班的舱位的价位：{}",flightPriceDTO);
        flightManageService.updateFlightPrice(flightPriceDTO);
        return Result.success();
    }

    /**
     * 修改航班的各舱位的座位数量
     * @param flightNumberDTO
     * @return
     */
    @PutMapping("/updateFlightStatusNumber")
    @ApiOperation("修改航班的各舱位的座位数量")
    public Result updateFlightStatusNumber(@RequestBody FlightNumberDTO flightNumberDTO) {
        log.info("修改航班的舱位的价位：{}",flightNumberDTO);
        flightManageService.updateFlightStatusNumber(flightNumberDTO);
        return Result.success();
    }
    /**
     * 修改航班的起始时间
     * @param flightFlyTimeDTO
     * @return
     */
    @PutMapping("/updateFlightStartTime")
    @ApiOperation("修改航班的起始时间")
    public Result updateFlightStartTime(@RequestBody FlightFlyTimeDTO flightFlyTimeDTO) {
        log.info("修改航班的起始时间：{}",flightFlyTimeDTO);
        flightManageService.updateFlightStartTime(flightFlyTimeDTO);
        return Result.success();
    }

    /**
     * 修改航班信息
     * @param
     * @return
     */
    @PutMapping("/updateFlight")
    @ApiOperation("修改航班信息")
    public Result updateFlight(@RequestBody Flight flight) {
        log.info("新增航班信息：{}",flight);
        flightManageService.updateFlight(flight);
        return Result.success();
    }

    /**
     * 根据航班号查询航班信息
     * @param flightNumber
     * @return
     */
    @GetMapping("/getFlightByFlightNumber")
    @ApiOperation("根据航班号查询航班信息")
    public Result<FlightVO> getFlightByFlightNumber(@RequestParam String flightNumber) {
        log.info("航班号：{}",flightNumber);

        FlightVO flightVO = flightManageService.getFlightByFlightNumber(flightNumber);
        return Result.success(flightVO);
    }

    /**
     * 根据id查询航班信息
     * @param
     * @return
     */
    @GetMapping("/{flightId}")
    @ApiOperation("根据id查询航班信息")
    public Result<FlightVO> getFlight(@PathVariable Integer flightId) {
        log.info("新增航班信息：{}",flightId);
        //  String flightId = flight.getFlightId();
       FlightVO flightVO = flightManageService.getFlight(flightId);
        return Result.success(flightVO);
    }
    /**
     * 航班信息的删除
     * @param flightId
     * @return
     */
    @DeleteMapping("/{flightId}")
    @ApiOperation("航班信息批量删除")
    public Result deleteFlight(@PathVariable Integer flightId) {
        log.info("航班信息批量删除：{}", flightId);
        flightManageService.deleteFlight(flightId);

        return Result.success();
    }
    @PutMapping("/getFlightMessage")
    @ApiOperation("获取航班信息")
    public Result<List<FlightVO>> getFlightMessage(@RequestBody Flight flight) {
        List<FlightVO> flightVO =  flightManageService.getFlightMessage(flight);
        return Result.success(flightVO);
    }

    //    /**
//     * 根据航班的时间、地点、票量查询航班信息
//     */
//    @GetMapping("/flightTimeLocationTicket")
//    @ApiOperation("航班的时间、地点、票量查询航班信息")
//    public Result<FlightVO> getFlightTimeLocationTicket(@RequestBody FlightTouristSubmitOrderDTO flightTouristSubmitOrderDTO) {
//        log.info("新增航班信息：{}",flightTouristSubmitOrderDTO);
//        FlightVO flightVO = flightManageService.getFlightTimeLocationTicket(flightTouristSubmitOrderDTO);
//        return Result.success(flightVO);
//    }

}
