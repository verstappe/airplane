package com.sky.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightAdminDTO {
    private Integer pageNum;
    private Integer pageSize;
    private Integer userId;
    private String userName;
    private String userPwd;
}
