package com.sky.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LuggageVO implements Serializable {
    private Integer luggageId;
    private String statue;
    private String location;
    private Integer flightId;
}
