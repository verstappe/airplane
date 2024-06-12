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
public class FlightOrderVO implements Serializable {
    private Integer orderId;
    private String orderName;
    private String orderUser;
    private String flightNumber;
    private String personName;
    private Date orderDate;
    private String grade;
    private String personId;
    private String contactName;
    private String contactPhone;
    private String orderMoney;
    private Integer flightId;
}
