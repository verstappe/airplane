package com.sky.vo;

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
public class FlightDiscussVO implements Serializable {
    private int id;
    private String time;
    private String userName;
    private String messageContent;

}
