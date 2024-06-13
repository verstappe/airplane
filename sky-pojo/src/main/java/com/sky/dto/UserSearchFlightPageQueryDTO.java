package com.sky.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime flightStartTime;
    private String flightStartPlace;
    private String flightEndPlace;
}
