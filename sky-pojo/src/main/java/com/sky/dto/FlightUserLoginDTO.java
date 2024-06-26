package com.sky.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "用户登录时传递的数据模型")
public class FlightUserLoginDTO implements Serializable {
    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String userPwd;
}
