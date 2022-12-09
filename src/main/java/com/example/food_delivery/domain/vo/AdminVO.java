package com.example.food_delivery.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AdminVO {
    private Integer no;
    private String id;
    private String pw;
}
