package com.example.food_delivery.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderMenuVO {
    private Integer no;
    private String foodName;
    private String num;
    private String price;
    private String orderNo;
    private Integer userNo;

}
