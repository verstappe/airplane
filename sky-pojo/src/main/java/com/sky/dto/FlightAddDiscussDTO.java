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
public class FlightAddDiscussDTO implements Serializable {
    private Integer id;
    private String userName;
    private String flightNumber;
    private String messageContent;
}
