package com.example.food_delivery.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class StoreVO {
    private Integer no;
    private String account;
    private String location;
    private String review;
    private Integer grade;
    private Integer menu_no;
    private Integer ceo_no;
}
