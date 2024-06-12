package com.sky.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightNumberDTO  implements Serializable {
    private Integer flightId;
    private String flightNumber;

    private Integer flightHighNumber;

    private Integer flightMiddleNumber;

    private Integer flightBaseNumber;


}

