package com.zxw.service.entity;


import lombok.Data;

@Data
public class App {
    private Integer id;
    private String appId;
    private String appName;
    private String appSecret;
    private String appToken;
    private String isFlag;
}