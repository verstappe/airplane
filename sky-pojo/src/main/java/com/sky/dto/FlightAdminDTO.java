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
    private int pageNum;
    private int pageSize;
    private int userId;
    private String userName;
    private String userPwd;
}
