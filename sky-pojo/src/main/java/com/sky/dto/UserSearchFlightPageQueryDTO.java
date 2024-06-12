package com.sky.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSearchFlightPageQueryDTO implements Serializable {
    private Integer pageNum;
    private Integer pageSize;
    private LocalDateTime flightStartTime;
    private String flightStartPlace;
    private String flightEndPlace;
}
