package com.sky.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Flight implements Serializable {
    private Integer flightId;
    private String flightNumber;
    private String flightStartPlace;
    private String flightEndPlace;
    private String flightStartAirport;
    private String flightEndAirport;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime flightStartTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime flightEndTime;
    private double flightHighPrice;
    private Integer flightHighNumber;
    private double flightMiddlePrice;
    private Integer flightMiddleNumber;
    private double flightBasePrice;
    private Integer flightBaseNumber;
    private String flightLineSort;

}
