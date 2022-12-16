package com.example.food_delivery.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserOrderVO {
    private Integer no;
    private Integer userNo;
    private Integer status;
    private String storeName;
    private String orderDate;
    private Integer tip;
    private String payment;
    private String forCeo;
    private String forRider;
    private String location;
    private String totalMoney;
}
