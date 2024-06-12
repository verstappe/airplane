package com.sky.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightTouristSubmitOrderDTO implements Serializable {
    private String orderName;
    private String orderUser;
    private String flightNumber;
    private String personName;
//    private LocalDateTime orderDate;
    private String grade;
    private String personId;
    private String contactName;
    private String contactPhone;
    private String orderMoney;
    private int flightId;

}
