package com.sky.controller.FlightUser;

import com.sky.dto.FlightOrderDTO;
import com.sky.dto.FlightOrderUpdateDTO;
import com.sky.dto.FlightTouristSubmitOrderDTO;
import com.sky.result.Result;
import com.sky.service.FlightOrderService;
import com.sky.vo.FlightOrderVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tourist1/usermanage")
@Api(tags = "乘客订单")
public class UserOrderController1 {
    @Autowired
    private FlightOrderService flightOrderService;

    /**
     * 订票
     */
    @PostMapping
    @ApiOperation("订票")
    public Result makeOrder(@RequestBody FlightTouristSubmitOrderDTO flightTouristSubmitOrderDTO){
        flightOrderService.makeOrder(flightTouristSubmitOrderDTO);
        return Result.success();
    }
    /**
     * 查看支付成功的订单信息
     */
    @GetMapping("/{orderId}")
    @ApiOperation("查看支付成功的订单信息")
    public Result<FlightOrderVO> getOrderById(@PathVariable Integer orderId){
        FlightOrderVO flightOrderVO = flightOrderService.getOrderById(orderId);
        return Result.success(flightOrderVO);
    }

    /**
     * 更改订单的日期
     */
    @PutMapping
    @ApiOperation("更改订单的日期")
    public Result updateOrderMessage(@RequestBody FlightOrderUpdateDTO flightOrderUpdateDTO){
        flightOrderService.updateOrderMessage(flightOrderUpdateDTO);
        return Result.success();
    }

    /**
     * 退票
     */
    @DeleteMapping
    @ApiOperation("退票")
    public Result deleteOrder(@RequestBody FlightOrderDTO flightOrderDTO){
        flightOrderService.deleteOrder(flightOrderDTO);
        return Result.success();
    }
}
