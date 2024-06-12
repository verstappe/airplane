package com.sky.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightDiscussDTO implements Serializable {
    private int pageNum;
    private int pageSize;

    private Integer id;
    private String time;
    private String userName;
    private String messageContent;
}
