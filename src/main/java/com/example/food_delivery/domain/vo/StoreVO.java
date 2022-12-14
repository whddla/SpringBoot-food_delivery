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
    private Integer menuNo;
    private Integer ceoNo;
    private String storeName;
    private Integer tip;
    private Integer limitPrice;
    private String img;
}
