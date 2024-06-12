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
public class FlightUserMakeLuggageDTO implements Serializable {

    private String realName;
    private String personId;
    private Integer orderId;
}
