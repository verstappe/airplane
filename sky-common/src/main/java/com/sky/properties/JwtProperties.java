package com.sky.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component //响应客户端发送的http请求
@ConfigurationProperties(prefix = "sky.jwt")
@Data
public class JwtProperties {
    //配置属性类(封装配置文件当中的配对象) application.yml 中sky.jwt的 配对象
    //将 配对象 封装 JwtProperties类的java对象
    //将 JwtProperties类的java对象 注入到 FlightUserController
    /**
     * 乘客端生成jwt令牌相关配置
     */
    private String userSecretKey;
    private long userTtl;
    private String userTokenName;

}
