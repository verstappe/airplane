package com.sky.controller.FlightManage;

import com.sky.dto.FlightOrderDTO;
import com.sky.entity.Flight;
import com.sky.entity.FlightOrder;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.FlightOrderService;
import com.sky.vo.FlightOrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/manage4/flightOrder")
@Api(tags = "订单信息管理")
public class FlightOrderController {
    @Autowired
    private FlightOrderService flightOrderService;

    /**
     * 根据id查询订单信息
     */
    @GetMapping("/{orderId}")
    @ApiOperation("根据id查询订单信息")
    public Result<FlightOrderVO> getOrderById(@PathVariable Integer orderId){
        FlightOrderVO flightOrderVO = flightOrderService.getOrderById(orderId);
        return Result.success(flightOrderVO);
    }
    /**
     * 根据id删除订单
     */
    @DeleteMapping("/{orderId}")
    @ApiOperation("根据id删除订单")
    public Result deleteOrderById(@PathVariable Integer orderId){
         flightOrderService.deleteOrderById(orderId);
        return Result.success();
    }

    /**
     * 根据id批量删除订单
     *
     */
    @DeleteMapping("/deleteids")
    @ApiOperation("根据id批量删除订单")
    public Result deleteOrderById(@RequestParam List<Integer> orderIds){
        flightOrderService.deleteOrderByIds(orderIds);
        return Result.success();
    }


    /**
     * 分页搜索订单
     *
     */
    @GetMapping
    @ApiOperation("分页搜索订单")
    public Result<PageResult> getOrderByPage(@RequestBody FlightOrderDTO flightOrderDTO){
        PageResult pageResult = flightOrderService.getOrderByPage(flightOrderDTO);
        return Result.success(pageResult);
    }

}
