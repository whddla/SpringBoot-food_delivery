package com.example.food_delivery.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class OrderMenuVO {
    private Integer no;
    private String foodName;
    private Integer num;
    private Integer price;
    private Integer orderNo;
}
