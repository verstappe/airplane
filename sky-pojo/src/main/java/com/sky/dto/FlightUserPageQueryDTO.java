package com.sky.dto;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightUserPageQueryDTO implements Serializable {



    //页码
    private int pageNum;

    //每页显示记录数
    private int pageSize;
    //用户姓名
    private String realName;
}
