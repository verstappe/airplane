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
public class FlightContentDTO implements Serializable {
    private int pageNum;
    private int pageSize;
    private int contentId;
    private String contentDescribe;
    private String contentUrl;
    private String contentPictureUrl;
}
