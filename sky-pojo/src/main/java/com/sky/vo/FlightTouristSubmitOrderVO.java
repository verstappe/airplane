package com.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightTouristSubmitOrderVO implements Serializable {
    private Integer orderId;
    private String orderName;
    private String orderUser;
    private String flightNumber;
    private String personName;
    private String orderDate;
    private String grade;
    private String personId;
    private String contactName;
    private String contactPhone;
    private String orderMoney;
    private String flightStartPlace;
    private String flightEndPlace;
    private String flightStartTime;
    private String flightEndTime;
    private String flightStartAirport;
    private String flightEndAirport;
    private String flightHighNumber;
    private String flightMiddleNumber;
    private String flightBaseNumber;
    private String flightLineSort;
}
