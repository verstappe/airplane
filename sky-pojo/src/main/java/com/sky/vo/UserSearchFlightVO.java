package com.sky.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserSearchFlightVO implements Serializable {
    private int flightId;
    private String flightNumber;
    private String flightStartPlace;
    private String flightEndPlace;
    private String flightStartAirport;
    private String flightEndAirport;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date flightStartTime;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date flightEndTime;
    private double flightHighPrice;
    private int flightHighNumber;
    private double flightMiddlePrice;
    private int flightMiddleNumber;
    private double flightBasePrice;
    private int flightBaseNumber;
    private String flightLineSort;
}
