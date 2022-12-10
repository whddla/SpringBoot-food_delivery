package com.example.food_delivery.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MenuVO {/*회원.*/
    private Integer no;
    private Integer menuCate;
    private String foodName;
    private Integer price;
    private Integer ceoNo;
    private String img;
}
