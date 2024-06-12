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
public class FlightUserDTO implements Serializable {
    private Integer userId;
    private String userName;
    private String userPwd;
    private String realName;
    private String userPhone;
    private String userSex;
    private String userIdentity;


}
