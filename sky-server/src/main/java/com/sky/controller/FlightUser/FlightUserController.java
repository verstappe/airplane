package com.sky.controller.FlightUser;

import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.FlightUserDTO;
import com.sky.dto.FlightUserLoginDTO;
import com.sky.dto.FlightUserPageQueryDTO;
import com.sky.entity.FlightUser;
import com.sky.properties.JwtProperties;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.FlightUserService;
import com.sky.utils.JwtUtil;
import com.sky.vo.FlightUserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/tourist2/flightUser1")
@Slf4j
@Api(tags = "乘客账号接口")
public class FlightUserController {
    @Autowired
    private FlightUserService flightUserService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 登录
     *
     * @param flightUserLoginDTO
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    public Result<FlightUserLoginVO> login(@RequestBody FlightUserLoginDTO flightUserLoginDTO) {
        log.info("用户登录：{}", flightUserLoginDTO);

         FlightUser flightUser = flightUserService.login(flightUserLoginDTO);

        //登录成功后，生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, flightUser.getUserId());
        String token = JwtUtil.createJWT( //JWTUtils工具类生成JWT令牌
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims);

        FlightUserLoginVO flightUserLoginVO = FlightUserLoginVO.builder()
                .userId(flightUser.getUserId())
                .userName(flightUser.getUserName())
                .token(token)
                .build();

        return Result.success(flightUserLoginVO);
    }
    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    @ApiOperation("用户退出")
    public Result<String> logout() {
        return Result.success();
    }

    /**
     * 注册用户账号
     * * @param flightUserDTO
     * @return
     */
    @PostMapping
    @ApiOperation("注册用户账号")
    public Result save(@RequestBody FlightUserDTO flightUserDTO){
        log.info("注册用户账号：{}",flightUserDTO);
        flightUserService.save(flightUserDTO);
        return Result.success();
    }
}
