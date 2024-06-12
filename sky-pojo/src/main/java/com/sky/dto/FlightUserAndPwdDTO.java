package com.sky.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightUserAndPwdDTO implements Serializable {
    private int pageNum;
    private int pageSize;
    private int userId;
    private String userName;
    private String userPwd;
    private String userPhone;
    private String userSex;
    private String userIdentity;
    private Integer userStatus;
}
