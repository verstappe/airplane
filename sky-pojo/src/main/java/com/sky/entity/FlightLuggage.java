package com.sky.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightLuggage implements Serializable {
    private Integer luggageId;
    private String statue;
    private String location;
    private Integer flightId;
    private Integer orderId;
}
