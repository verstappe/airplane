package com.sky.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightUser implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer userId;
    private String userName;
    private String userPwd;
    private String realName;
    private String userPhone;
    private String userSex;
    private String userIdentity;
    private Integer userStatus;
    private Integer orderId;
}
