package com.example.food_delivery.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserOrderVO {
    private Integer no;
    private Integer user_no;
    private Integer status;
    private String food_name;
    private String store_name;
    private String order_date;
    private String cnt;
    private Integer tip;
    private Integer price;
    private String payment;
    private String for_ceo;
    private String for_rider;
    private String location;
}
