package com.sky.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightOrderDTO implements Serializable {
    private int pageNum;
    private int pageSize;
    private String flightNumber;
    private String orderDate;
    private Integer orderId;
    private String orderUser;
}
