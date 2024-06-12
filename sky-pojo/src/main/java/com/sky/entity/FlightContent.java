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
public class FlightContent implements Serializable {
    private Integer contentId;
    private String contentDescribe;
    private String contentUrl;
    private String contentPictureUrl;
}
