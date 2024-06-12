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
public class LuggageDTO implements Serializable {
    private Integer luggageId;
    private String personId;
    private Integer touristId;
    private Integer flightId;
    private String statue;
    private String location;
}
