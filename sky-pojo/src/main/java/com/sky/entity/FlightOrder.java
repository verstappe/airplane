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
public class FlightOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer orderId;
    private String orderName;
    private String orderUser;
    private String flightNumber;
    private String personName;
   @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDate;
    private String grade;
    private String personId;
    private String contactName;
    private String contactPhone;
    private String orderMoney;
    private Integer flightId;
    private Integer userId;
}
